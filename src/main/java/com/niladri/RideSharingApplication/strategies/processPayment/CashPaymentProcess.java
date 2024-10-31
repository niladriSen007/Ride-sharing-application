package com.niladri.RideSharingApplication.strategies.processPayment;

import com.niladri.RideSharingApplication.model.payment.PaymentModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashPaymentProcess implements PaymentProcessInterface {

	@Override
	public void processPayment(PaymentModel paymentModel) {

	}
}



