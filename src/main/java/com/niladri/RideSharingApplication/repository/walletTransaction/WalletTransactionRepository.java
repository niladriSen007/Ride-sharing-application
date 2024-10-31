package com.niladri.RideSharingApplication.repository.walletTransaction;

import com.niladri.RideSharingApplication.model.walletTransaction.WalletTransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletTransactionRepository extends JpaRepository<WalletTransactionModel, Long> {
}
