package com.niladri.RideSharingApplication.repository.payment;

import com.niladri.RideSharingApplication.model.payment.PaymentModel;
import com.niladri.RideSharingApplication.model.ride.RideModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {
	Optional<PaymentModel> findByRide(RideModel rideModel);
}
