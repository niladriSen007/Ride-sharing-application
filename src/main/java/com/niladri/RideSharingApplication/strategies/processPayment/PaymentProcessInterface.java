package com.niladri.RideSharingApplication.strategies.processPayment;

import com.niladri.RideSharingApplication.model.payment.PaymentModel;

public interface PaymentProcessInterface {

	static final Double PLATFORM_FEE = 0.3;

	void processPayment(PaymentModel paymentModel);
}
