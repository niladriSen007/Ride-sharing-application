package com.niladri.RideSharingApplication.dto.ride;

import com.niladri.RideSharingApplication.dto.driver.DriverResponseDto;
import com.niladri.RideSharingApplication.dto.point.PointDto;
import com.niladri.RideSharingApplication.dto.rider.RiderResponseDto;
import com.niladri.RideSharingApplication.model.driver.DriverModel;
import com.niladri.RideSharingApplication.model.enums.PaymentMethods;
import com.niladri.RideSharingApplication.model.enums.RideStatus;
import com.niladri.RideSharingApplication.model.rider.RiderModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideDto {

	private Long id;
	private PointDto pickupLocation;
	private PointDto dropLocation;
	private LocalDateTime createdTime;
	private RiderResponseDto rider;
	private DriverResponseDto driver;
	private PaymentMethods paymentMethod;
	private RideStatus status;
	private String otp;
	private Double fare;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
}
