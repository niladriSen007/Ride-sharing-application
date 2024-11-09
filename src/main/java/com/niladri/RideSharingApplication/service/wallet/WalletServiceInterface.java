package com.niladri.RideSharingApplication.service.wallet;

import com.niladri.RideSharingApplication.model.enums.TransactionMethod;
import com.niladri.RideSharingApplication.model.ride.RideModel;
import com.niladri.RideSharingApplication.model.user.UserModel;
import com.niladri.RideSharingApplication.model.wallet.WalletModel;

public interface WalletServiceInterface {

	WalletModel addMoneyToWallet(Double amount, UserModel userModel, String transactionId, RideModel rideModel, TransactionMethod transactionMethod);

	void withdrawMoneyFromWallet(WalletModel walletModel, Double amount, UserModel userModel);

	WalletModel createNewWallet(UserModel userModel);

	WalletModel getUserWallet(UserModel userModel);

	WalletModel getWalletById(Long walletId);

	WalletModel deductMoneyFromWallet(Double amount, UserModel userModel,String transactionId, RideModel rideModel, TransactionMethod transactionMethod);


}
