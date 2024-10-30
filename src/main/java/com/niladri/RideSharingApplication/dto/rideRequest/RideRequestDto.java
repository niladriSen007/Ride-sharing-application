package com.niladri.RideSharingApplication.dto.rideRequest;

import com.niladri.RideSharingApplication.dto.point.PointDto;
import com.niladri.RideSharingApplication.dto.rider.RiderResponseDto;
import com.niladri.RideSharingApplication.model.enums.PaymentMethods;
import com.niladri.RideSharingApplication.model.enums.RideRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDto {

	private Long id;
	private PointDto pickupLocation;
	private PointDto dropLocation;
	private LocalDateTime pickupTime;
	private RiderResponseDto rider;
	private Double fare;
	private PaymentMethods paymentMethod;
	private RideRequestStatus status;

}
