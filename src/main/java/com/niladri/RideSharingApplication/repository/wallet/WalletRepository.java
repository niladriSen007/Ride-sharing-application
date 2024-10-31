package com.niladri.RideSharingApplication.repository.wallet;

import com.niladri.RideSharingApplication.model.user.UserModel;
import com.niladri.RideSharingApplication.model.wallet.WalletModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<WalletModel, Long> {
	Optional<WalletModel> findByUser(UserModel userModel);
}
