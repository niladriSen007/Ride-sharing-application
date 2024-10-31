package com.niladri.RideSharingApplication.controller.driver;

import com.niladri.RideSharingApplication.dto.ride.RideDto;
import com.niladri.RideSharingApplication.dto.rideStart.RideStartDto;
import com.niladri.RideSharingApplication.service.driver.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/driver")
public class DriverController {

	private final DriverService driverService;

	@PostMapping("/acceptRide/{rideRequestId}")
	public ResponseEntity<RideDto> acceptRide(@PathVariable  Long rideRequestId) {
		return ResponseEntity.ok(driverService.acceptRide(rideRequestId));
	}


	@PostMapping("/startRide/{rideId}")
	public ResponseEntity<RideDto> startRide(@PathVariable Long rideId, @RequestBody RideStartDto otp) {
		return ResponseEntity.ok(driverService.startRide(rideId,otp.getOtp()));
	}

	@PostMapping("/cancelRide/{rideId}")
	public ResponseEntity<RideDto> cancelRide(@PathVariable Long rideId) {
		return ResponseEntity.ok(driverService.cancelRide(rideId));
	}

}
