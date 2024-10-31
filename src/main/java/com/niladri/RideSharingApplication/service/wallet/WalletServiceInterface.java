package com.niladri.RideSharingApplication.service.wallet;

import com.niladri.RideSharingApplication.model.user.UserModel;
import com.niladri.RideSharingApplication.model.wallet.WalletModel;

public interface WalletServiceInterface {

	WalletModel addMoneyToWallet( Double amount, UserModel userModel);

	void withdrawMoneyFromWallet(WalletModel walletModel, Double amount, UserModel userModel);

	WalletModel createNewWallet(UserModel userModel);

	WalletModel getUserWallet(UserModel userModel);

	WalletModel getWalletById(Long walletId);

}
