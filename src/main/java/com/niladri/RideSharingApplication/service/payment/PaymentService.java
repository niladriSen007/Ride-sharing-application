package com.niladri.RideSharingApplication.service.payment;

import com.niladri.RideSharingApplication.exception.ResourceNotFound;
import com.niladri.RideSharingApplication.model.enums.PaymentStatus;
import com.niladri.RideSharingApplication.model.payment.PaymentModel;
import com.niladri.RideSharingApplication.model.ride.RideModel;
import com.niladri.RideSharingApplication.repository.payment.PaymentRepository;
import com.niladri.RideSharingApplication.strategies.PaymentProcessStrategyManager;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService implements PaymentServiceInterface {

	private final PaymentProcessStrategyManager paymentProcessStrategyManager;
	private final PaymentRepository paymentRepository;

	@Override
	public void processPayment(RideModel rideModel) {
		PaymentModel paymentModel = paymentRepository.findByRide(rideModel)
				.orElseThrow(()->new ResourceNotFound("Payment not found"));
		paymentProcessStrategyManager.paymentProcessStrategy(rideModel.getPaymentMethod())
				.processPayment(paymentModel);
	}

	@Override
	public PaymentModel createNewPayment(RideModel rideModel) {
		PaymentModel paymentModel = PaymentModel.builder()
				.paymentMethod(rideModel.getPaymentMethod())
				.ride(rideModel)
				.amount(rideModel.getFare())
				.paymentStatus(PaymentStatus.PENDING)
				.build();
		return paymentRepository.save(paymentModel);
	}

	@Override
	public void updatePaymentStatus(PaymentModel paymentModel, PaymentStatus paymentStatus) {
		paymentModel.setPaymentStatus(paymentStatus);
		paymentRepository.save(paymentModel);
	}
}
