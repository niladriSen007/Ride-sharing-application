package com.niladri.RideSharingApplication.dto.rideRequest;

import com.niladri.RideSharingApplication.dto.rider.RiderResponseDto;
import com.niladri.RideSharingApplication.model.enums.PaymentMethods;
import com.niladri.RideSharingApplication.model.enums.RideRequestStatus;
import com.niladri.RideSharingApplication.model.rider.RiderModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDto {

	private Long id;
	private Point pickupLocation;
	private Point dropLocation;
	private LocalDateTime pickupTime;
	private RiderResponseDto rider;
	private PaymentMethods paymentMethod;
	private RideRequestStatus status;

}
