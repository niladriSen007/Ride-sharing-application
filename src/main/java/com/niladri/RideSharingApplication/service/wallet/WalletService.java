package com.niladri.RideSharingApplication.service.wallet;

import com.niladri.RideSharingApplication.exception.WalletNotFound;
import com.niladri.RideSharingApplication.model.enums.TransactionMethod;
import com.niladri.RideSharingApplication.model.enums.TransactionType;
import com.niladri.RideSharingApplication.model.ride.RideModel;
import com.niladri.RideSharingApplication.model.user.UserModel;
import com.niladri.RideSharingApplication.model.wallet.WalletModel;
import com.niladri.RideSharingApplication.model.walletTransaction.WalletTransactionModel;
import com.niladri.RideSharingApplication.repository.wallet.WalletRepository;
import com.niladri.RideSharingApplication.service.walletTransaction.WalletTransactionService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WalletService implements WalletServiceInterface {

	private final WalletRepository walletRepository;
	private final WalletTransactionService walletTransactionService;

	@Override
	@Transactional
	public WalletModel addMoneyToWallet(Double amount, UserModel userModel,
	                                    String transactionId, RideModel rideModel, TransactionMethod transactionMethod) {
		WalletModel walletModel = getUserWallet(userModel);

		if (amount < 0) {
			throw new IllegalArgumentException("Amount cannot be negative");
		}

		walletModel.setBalance(walletModel.getBalance() + amount);

		WalletTransactionModel walletTransactionModel = WalletTransactionModel.builder()
				.transactionType(TransactionType.CREDIT)
				.ride(rideModel)
				.transactionId(transactionId)
				.wallet(walletModel)
				.transactionMethod(transactionMethod)
				.amount(amount)
				.build();

//		walletTransactionService.createNewWalletTransaction(walletTransactionModel);

		walletModel.getWalletTransactions().add(walletTransactionModel);

		return walletRepository.save(walletModel);
	}

	@Override
	public void withdrawMoneyFromWallet(WalletModel walletModel, Double amount, UserModel userModel) {
	}

	@Override
	public WalletModel createNewWallet(UserModel userModel) {
		WalletModel walletModel = new WalletModel();
		walletModel.setBalance(0.0);
		walletModel.setUser(userModel);
		return walletRepository.save(walletModel);
	}

	@Override
	public WalletModel getUserWallet(UserModel userModel) {
		return walletRepository.findByUser(userModel).orElseThrow(() -> new WalletNotFound("Wallet not found for user: " + userModel.getId()));
	}

	@Override
	public WalletModel getWalletById(Long walletId) {
		return walletRepository.findById(walletId).orElseThrow(() -> new WalletNotFound("Wallet not found with id: " + walletId));
	}

	@Override
	@Transactional
	public WalletModel deductMoneyFromWallet(Double amount, UserModel userModel,
	                                         String transactionId, RideModel rideModel, TransactionMethod transactionMethod) {
		WalletModel walletModel = getUserWallet(userModel);
		if(walletModel.getBalance() < amount) {
			throw new IllegalArgumentException("Insufficient balance");
		}
		walletModel.setBalance(walletModel.getBalance() - amount);

		WalletTransactionModel walletTransactionModel = WalletTransactionModel.builder()
				.transactionType(TransactionType.DEBIT)
				.ride(rideModel)
				.transactionId(transactionId)
				.wallet(walletModel)
				.transactionMethod(transactionMethod)
				.amount(amount)
				.build();

		walletTransactionService.createNewWalletTransaction(walletTransactionModel);

		return walletRepository.save(walletModel);
	}


}
