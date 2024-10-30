package com.niladri.RideSharingApplication.service.driver;

import com.niladri.RideSharingApplication.dto.driver.DriverResponseDto;
import com.niladri.RideSharingApplication.dto.ride.RideDto;
import com.niladri.RideSharingApplication.exception.DriverNotAuthorisedToStartRide;
import com.niladri.RideSharingApplication.exception.InvalidOtp;
import com.niladri.RideSharingApplication.exception.ResourceNotFound;
import com.niladri.RideSharingApplication.exception.RideNotStarted;
import com.niladri.RideSharingApplication.model.driver.DriverModel;
import com.niladri.RideSharingApplication.model.enums.RideRequestStatus;
import com.niladri.RideSharingApplication.model.enums.RideStatus;
import com.niladri.RideSharingApplication.model.ride.RideModel;
import com.niladri.RideSharingApplication.model.rideRequest.RideRequestModel;
import com.niladri.RideSharingApplication.repository.driver.DriverRepository;
import com.niladri.RideSharingApplication.repository.ride.RideRepository;
import com.niladri.RideSharingApplication.service.ride.RideService;
import com.niladri.RideSharingApplication.service.rideRequest.RideRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DriverService implements DriverServiceInterface {

	private final RideRequestService rideRequestService;
	private final DriverRepository driverRepository;
	private final RideService rideService;
	private final ModelMapper modelMapper;
	private final RideRepository rideRepository;

	@Override
	@Transactional
	public RideDto acceptRide(Long rideRequestId) {
		RideRequestModel rideRequest = rideRequestService.getRideRequestById(rideRequestId);

		if(!rideRequest.getStatus().equals(RideRequestStatus.PENDING)) {
			throw new RuntimeException("Ride request can not be accepted as it is not pending");
		}

		DriverModel driver = getCurrentDriver();
		if(Boolean.FALSE.equals(driver.getAvailable())){
			throw new RuntimeException("Driver is not available to accept the ride");
		}

		driver.setAvailable(false);
		DriverModel savedDriver = driverRepository.save(driver);
		RideModel ride = rideService.createNewRide(rideRequest, savedDriver);
		rideRequest.setStatus(RideRequestStatus.CONFIRMED);

		return modelMapper.map(ride, RideDto.class);
	}

	@Override
	public RideDto cancelRide(Long rideId) {
		return null;
	}

	@Override
	public RideDto startRide(Long rideId,String otp) {
		RideModel ride = rideRepository.findById(rideId).orElseThrow(() -> new ResourceNotFound("Ride not found"));
//		RideModel rideModel = modelMapper.map(ride, RideModel.class);

		log.info("driver 1: {} - {}", ride.getOtp(),otp);
		log.info("driver 2: {}", getCurrentDriver().getId());


		DriverModel driver = getCurrentDriver();
		if(!driver.equals(ride.getDriver()) ){
			throw new DriverNotAuthorisedToStartRide("Driver is not authorized to start the ride");
		}

		if(!ride.getStatus().equals(RideStatus.CONFIRMED)){
			throw new RideNotStarted("Ride can not be started as it is not confirmed");
		}

		if(!otp.equals(ride.getOtp())){
			throw new InvalidOtp("Invalid OTP");
		}

		ride.setStartTime(LocalDateTime.now());
		RideModel updatedRide = rideService.updateRideStatus(rideId, RideStatus.ONGOING);

		return modelMapper.map(updatedRide, RideDto.class);
	}

	@Override
	public RideDto endRide(Long rideId) {
		return null;
	}

	@Override
	public RideDto rateRider(Long rideId, Integer rating) {
		return null;
	}

	@Override
	public DriverResponseDto getDriverProfile() {
		return null;
	}

	@Override
	public List<RideDto> getDriverAllRides() {
		return List.of();
	}

	@Override
	public DriverModel getCurrentDriver() {
		return driverRepository.findById(2L).orElseThrow(() -> new ResourceNotFound("Driver not found with " +
				"id "+2));
	}
}
