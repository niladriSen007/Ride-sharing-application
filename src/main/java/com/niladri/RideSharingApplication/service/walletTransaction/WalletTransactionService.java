package com.niladri.RideSharingApplication.service.walletTransaction;

import com.niladri.RideSharingApplication.model.walletTransaction.WalletTransactionModel;
import com.niladri.RideSharingApplication.repository.walletTransaction.WalletTransactionRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletTransactionService implements WalletTransactionServiceInterface {

	private final WalletTransactionRepository walletTransactionRepository;

	@Override
	public void createNewWalletTransaction(WalletTransactionModel walletTransaction) {
		walletTransactionRepository.save(walletTransaction);
	}
}
