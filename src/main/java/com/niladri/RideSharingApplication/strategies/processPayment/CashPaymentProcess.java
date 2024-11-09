package com.niladri.RideSharingApplication.strategies.processPayment;

import com.niladri.RideSharingApplication.model.driver.DriverModel;
import com.niladri.RideSharingApplication.model.enums.PaymentStatus;
import com.niladri.RideSharingApplication.model.enums.TransactionMethod;
import com.niladri.RideSharingApplication.model.payment.PaymentModel;
import com.niladri.RideSharingApplication.repository.payment.PaymentRepository;
import com.niladri.RideSharingApplication.service.wallet.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CashPaymentProcess implements PaymentProcessInterface {

	private final WalletService walletService;

	private final PaymentRepository paymentRepository;

	@Override
	@Transactional
	public void processPayment(PaymentModel paymentModel) {
		DriverModel driver = paymentModel.getRide().getDriver();

		Double platformFee = paymentModel.getAmount() * PLATFORM_FEE;
		walletService.deductMoneyFromWallet(platformFee, driver.getUser(),null,
				paymentModel.getRide(), TransactionMethod.RIDE);

		paymentModel.setPaymentStatus(PaymentStatus.SUCCESS);
		paymentRepository.save(paymentModel);
	}
}



