package com.niladri.RideSharingApplication.strategies.processPayment;

import com.niladri.RideSharingApplication.model.payment.PaymentModel;

public interface PaymentProcessInterface {
	void processPayment(PaymentModel paymentModel);
}
