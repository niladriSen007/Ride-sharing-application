package com.niladri.RideSharingApplication.service.payment;

import com.niladri.RideSharingApplication.model.enums.PaymentStatus;
import com.niladri.RideSharingApplication.model.payment.PaymentModel;
import com.niladri.RideSharingApplication.model.ride.RideModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class PaymentService implements PaymentServiceInterface {

	@Override
	public void processPayment(RideModel rideModel) {

	}

	@Override
	public PaymentModel createNewPayment(RideModel rideModel) {
		return null;
	}

	@Override
	public void updatePaymentStatus(PaymentModel paymentModel, PaymentStatus paymentStatus) {

	}
}
