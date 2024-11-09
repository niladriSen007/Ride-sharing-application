package com.niladri.RideSharingApplication.strategies.processPayment;

import com.niladri.RideSharingApplication.model.driver.DriverModel;
import com.niladri.RideSharingApplication.model.enums.PaymentStatus;
import com.niladri.RideSharingApplication.model.enums.TransactionMethod;
import com.niladri.RideSharingApplication.model.payment.PaymentModel;
import com.niladri.RideSharingApplication.model.rider.RiderModel;
import com.niladri.RideSharingApplication.repository.payment.PaymentRepository;
import com.niladri.RideSharingApplication.service.wallet.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WalletPaymentProcess implements PaymentProcessInterface {

	private final WalletService walletService;
	private final PaymentRepository paymentRepository;

	@Override
	@Transactional
	public void processPayment(PaymentModel paymentModel) {

		DriverModel driver = paymentModel.getRide().getDriver();
		RiderModel rider = paymentModel.getRide().getRider();


		// Calculate platform fee
		Double driversCut = paymentModel.getAmount() * (1 - PLATFORM_FEE);

		// Deduct platform fee from riders's wallet
		walletService.deductMoneyFromWallet(paymentModel.getAmount(), rider.getUser(), null,
				paymentModel.getRide(), TransactionMethod.RIDE);

		//Add money to driver's wallet
		walletService.addMoneyToWallet(driversCut, driver.getUser(), null,
				paymentModel.getRide(), TransactionMethod.RIDE);

		//Update payment status
		paymentModel.setPaymentStatus(PaymentStatus.SUCCESS);
		paymentRepository.save(paymentModel);
	}
}
