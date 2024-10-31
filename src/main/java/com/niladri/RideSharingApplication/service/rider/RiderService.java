package com.niladri.RideSharingApplication.service.rider;

import com.niladri.RideSharingApplication.dto.driver.DriverResponseDto;
import com.niladri.RideSharingApplication.dto.ride.RideDto;
import com.niladri.RideSharingApplication.dto.rideRequest.RideRequestDto;
import com.niladri.RideSharingApplication.dto.rider.RiderResponseDto;
import com.niladri.RideSharingApplication.exception.RideStatusNotConfirmed;
import com.niladri.RideSharingApplication.exception.RiderNotAuthorizedToCancelRide;
import com.niladri.RideSharingApplication.exception.UserNotFound;
import com.niladri.RideSharingApplication.model.driver.DriverModel;
import com.niladri.RideSharingApplication.model.enums.RideRequestStatus;
import com.niladri.RideSharingApplication.model.enums.RideStatus;
import com.niladri.RideSharingApplication.model.ride.RideModel;
import com.niladri.RideSharingApplication.model.rideRequest.RideRequestModel;
import com.niladri.RideSharingApplication.model.rider.RiderModel;
import com.niladri.RideSharingApplication.model.user.UserModel;
import com.niladri.RideSharingApplication.repository.rideRequest.RideRequestRepository;
import com.niladri.RideSharingApplication.repository.rider.RiderRepository;
import com.niladri.RideSharingApplication.service.driver.DriverService;
import com.niladri.RideSharingApplication.service.ride.RideService;
import com.niladri.RideSharingApplication.strategies.RideStrategyManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderService implements RiderServiceInterface {

	private final ModelMapper modelMapper;
	private final RideStrategyManager rideStrategyManager;
	private final RideRequestRepository rideRequestRepository;
	private final RiderRepository riderRepository;
	private final RideService rideService;
	private final DriverService driverService;



	@Override
	@Transactional
	public RideRequestDto requestRide(RideRequestDto rideRequestDto) {

		RiderModel currentRider = getCurrentRider();

		//Mapping DTO to Model
		RideRequestModel rideRequest = modelMapper.map(rideRequestDto, RideRequestModel.class);
		rideRequest.setStatus(RideRequestStatus.PENDING);
		rideRequest.setRider(currentRider);

		//Calculating fare
		rideRequest.setFare(rideStrategyManager.rideFareCalculator().calculateFare(rideRequest));

		//Saving ride request
		RideRequestModel newRideRequest = rideRequestRepository.save(rideRequest);

		//Matching driver
		List<DriverModel> matchingDrivers = rideStrategyManager.driverMatchingStrategy
				(currentRider.getRating())
				.findMatchingDrivers(rideRequest);

		//TODO : Notify drivers

		return modelMapper.map(newRideRequest, RideRequestDto.class);
	}

	@Override
	public RideDto cancelRide(Long rideId) {
		RideModel ride = rideService.getRideById(rideId);

		RiderModel currentRider = getCurrentRider();
		if(!ride.getRider().equals(currentRider)){
			throw new RiderNotAuthorizedToCancelRide("Ride can not be cancelled as it is not requested by current rider");
		}

		if(!ride.getStatus().equals(RideStatus.CONFIRMED)){
			throw new RideStatusNotConfirmed("Ride can not be cancelled as it is not confirmed");
		}
		RideModel rideModel = rideService.updateRideStatus(rideId, RideStatus.CANCELLED);
		driverService.updateDriverAvailability(rideModel.getDriver(), true);
		return modelMapper.map(rideModel, RideDto.class);
	}

	@Override
	public DriverResponseDto rateDriver(Long rideId, Integer rating) {
		return null;
	}

	@Override
	public RideDto getRideDetails(Long rideId) {
		return null;
	}

	@Override
	public RiderResponseDto getRiderProfile() {
		return modelMapper.map(getCurrentRider(), RiderResponseDto.class);
	}

	@Override
	public Page<RideDto> getRiderAllRides(PageRequest pageRequest) {
		RiderModel currentRider = getCurrentRider();
		return rideService.getAllRidesOfRider(currentRider, pageRequest).map(
				ride -> modelMapper.map(ride,RideDto.class)
		);

	}

	@Override
	public RiderModel createRiderProfile(UserModel user) {
		return riderRepository.save(RiderModel.builder().user(user).build());
	}

	@Override
	public RiderModel getCurrentRider() {
		//TODO : get current rider from security context
		return riderRepository.findById(1L).orElseThrow(
				() -> new UserNotFound("Rider not found with id : 1"));
	}
}
