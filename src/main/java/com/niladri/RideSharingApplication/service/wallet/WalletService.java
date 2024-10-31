package com.niladri.RideSharingApplication.service.wallet;

import com.niladri.RideSharingApplication.exception.WalletNotFound;
import com.niladri.RideSharingApplication.model.user.UserModel;
import com.niladri.RideSharingApplication.model.wallet.WalletModel;
import com.niladri.RideSharingApplication.repository.wallet.WalletRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class WalletService implements WalletServiceInterface {

	private final WalletRepository walletRepository;

	@Override
	public WalletModel addMoneyToWallet(Double amount, UserModel userModel) {
		WalletModel walletModel = walletRepository.findByUser(userModel).orElseThrow(() -> new WalletNotFound("Wallet not found for user: " + userModel.getId()));

		if (amount < 0) {
			throw new IllegalArgumentException("Amount cannot be negative");
		}

		walletModel.setBalance(walletModel.getBalance() + amount);
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
		return null;
	}

	@Override
	public WalletModel getWalletById(Long walletId) {
		return walletRepository.findById(walletId).orElseThrow(() -> new WalletNotFound("Wallet not found with id: " + walletId));
	}
}
