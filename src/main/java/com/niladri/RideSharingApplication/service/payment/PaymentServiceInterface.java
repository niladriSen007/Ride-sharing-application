package com.niladri.RideSharingApplication.service.payment;

import com.niladri.RideSharingApplication.model.enums.PaymentStatus;
import com.niladri.RideSharingApplication.model.payment.PaymentModel;
import com.niladri.RideSharingApplication.model.ride.RideModel;

public interface PaymentServiceInterface {

	void processPayment(RideModel rideModel);

	PaymentModel createNewPayment(RideModel rideModel);

	void updatePaymentStatus(PaymentModel paymentModel, PaymentStatus paymentStatus);
}
