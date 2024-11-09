package com.niladri.RideSharingApplication.service.driver;

import com.niladri.RideSharingApplication.dto.driver.DriverResponseDto;
import com.niladri.RideSharingApplication.dto.ride.RideDto;
import com.niladri.RideSharingApplication.exception.*;
import com.niladri.RideSharingApplication.model.driver.DriverModel;
import com.niladri.RideSharingApplication.model.enums.RideRequestStatus;
import com.niladri.RideSharingApplication.model.enums.RideStatus;
import com.niladri.RideSharingApplication.model.payment.PaymentModel;
import com.niladri.RideSharingApplication.model.ride.RideModel;
import com.niladri.RideSharingApplication.model.rideRequest.RideRequestModel;
import com.niladri.RideSharingApplication.repository.driver.DriverRepository;
import com.niladri.RideSharingApplication.repository.ride.RideRepository;
import com.niladri.RideSharingApplication.service.payment.PaymentService;
import com.niladri.RideSharingApplication.service.ride.RideService;
import com.niladri.RideSharingApplication.service.rideRequest.RideRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	private final PaymentService paymentService;

	@Override
	@Transactional
	public RideDto acceptRide(Long rideRequestId) {
		RideRequestModel rideRequest = rideRequestService.getRideRequestById(rideRequestId);

		if(!rideRequest.getStatus().equals(RideRequestStatus.PENDING)) {
			throw new RideAlreadyConfirmed("Ride request can not be accepted as it is not pending");
		}

		DriverModel driver = getCurrentDriver();
		if(Boolean.FALSE.equals(driver.getAvailable())){
			throw new DriverNotAvailable("Driver is not available to accept the ride");
		}

		DriverModel driverModel = updateDriverAvailability(driver, false);

		RideModel ride = rideService.createNewRide(rideRequest, driverModel);
		rideRequest.setStatus(RideRequestStatus.CONFIRMED);

		return modelMapper.map(ride, RideDto.class);
	}

	@Override
	public RideDto cancelRide(Long rideId) {
		RideModel ride = rideService.getRideById(rideId);

		DriverModel driver = getCurrentDriver();

		if(!driver.equals(ride.getDriver()) ){
			throw new DriverNotAuthorisedToStartRide("Driver is not authorized to cancel the ride");
		}

		if (!ride.getStatus().equals(RideStatus.CONFIRMED)) {
			throw new RideNotStarted("Ride can not be cancelled as it is "+ride.getStatus());
		}

		rideService.updateRideStatus(rideId, RideStatus.CANCELLED);
		updateDriverAvailability(driver, true);

		return modelMapper.map(ride, RideDto.class);
	}

	@Override
	public RideDto startRide(Long rideId,String otp) {
		RideModel ride = rideService.getRideById(rideId);

		log.info("driver 1: {} - {}", ride.getOtp(),otp);
		log.info("driver 2: {}", getCurrentDriver().getId());


		DriverModel driver = getCurrentDriver();
		if(!driver.equals(ride.getDriver()) ){
			throw new DriverNotAuthorisedToStartRide("Driver is not authorized to start the ride");
		}

		if(!ride.getStatus().equals(RideStatus.CONFIRMED)){
			throw new RideStatusNotConfirmed("Ride can not be started as it is not confirmed");
		}

		if(!otp.equals(ride.getOtp())){
			throw new InvalidOtp("Invalid OTP");
		}

		ride.setStartTime(LocalDateTime.now());
		RideModel updatedRide = rideService.updateRideStatus(rideId, RideStatus.ONGOING);

		PaymentModel newPayment = paymentService.createNewPayment(updatedRide);

		return modelMapper.map(updatedRide, RideDto.class);
	}

	@Override
	@Transactional
	public RideDto endRide(Long rideId) {

		RideModel ride = rideService.getRideById(rideId);

		DriverModel driver = getCurrentDriver();
		if(!driver.equals(ride.getDriver()) ){
			throw new DriverNotAuthorisedToStartRide("Driver is not authorized to start the ride");
		}

		if(!ride.getStatus().equals(RideStatus.ONGOING)){
			throw new RideNotStarted("Ride can not be ended as it is not ONGOING");
		}

		ride.setEndTime(LocalDateTime.now());
		RideModel rideModel = rideService.updateRideStatus(rideId, RideStatus.ENDED);
		updateDriverAvailability(driver, true);

		paymentService.processPayment(ride);
		return modelMapper.map(rideModel, RideDto.class);
	}

	@Override
	public RideDto rateRider(Long rideId, Integer rating) {
		return null;
	}

	@Override
	public DriverResponseDto getDriverProfile() {
		DriverModel driver = getCurrentDriver();
		return modelMapper.map(driver, DriverResponseDto.class);
	}

	@Override
	public Page<RideDto> getDriverAllRides(PageRequest pageRequest) {
		DriverModel driver = getCurrentDriver();
		return rideService.getAllRidesOfDriver(driver, pageRequest)
				.map(ride -> modelMapper.map(ride, RideDto.class));
	}

	@Override
	public DriverModel getCurrentDriver() {
		return driverRepository.findById(2L)
				.orElseThrow(() -> new ResourceNotFound("Driver not found with " +
				"id "+2));
	}

	@Override
	public DriverModel updateDriverAvailability(DriverModel driver, Boolean isAvailable) {
		driver.setAvailable(isAvailable);
		return driverRepository.save(driver);
	}


}
