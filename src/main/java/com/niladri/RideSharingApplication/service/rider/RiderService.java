package com.niladri.RideSharingApplication.service.rider;

import com.niladri.RideSharingApplication.dto.driver.DriverResponseDto;
import com.niladri.RideSharingApplication.dto.ride.RideDto;
import com.niladri.RideSharingApplication.dto.rideRequest.RideRequestDto;
import com.niladri.RideSharingApplication.dto.rider.RiderResponseDto;
import com.niladri.RideSharingApplication.model.enums.RideRequestStatus;
import com.niladri.RideSharingApplication.model.rideRequest.RideRequestModel;
import com.niladri.RideSharingApplication.model.rider.RiderModel;
import com.niladri.RideSharingApplication.model.user.UserModel;
import com.niladri.RideSharingApplication.repository.rideRequest.RideRequestRepository;
import com.niladri.RideSharingApplication.repository.rider.RiderRepository;
import com.niladri.RideSharingApplication.strategies.calculateFare.RideFareCalculatorInterface;
import com.niladri.RideSharingApplication.strategies.matchingDriver.DriverMatchingInterface;
import com.niladri.RideSharingApplication.strategies.matchingDriver.DriverMatchingNearby;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderService implements RiderServiceInterface {

	private final ModelMapper modelMapper;
	private final RideFareCalculatorInterface rideFareCalculatorInterface;
	private final DriverMatchingInterface driverMatchingInterface;
	private final RideRequestRepository rideRequestRepository;
	private final RiderRepository riderRepository;


	@Override
	public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
		//Mapping DTO to Model
		RideRequestModel rideRequest = modelMapper.map(rideRequestDto, RideRequestModel.class);
		rideRequest.setStatus(RideRequestStatus.PENDING);

		//Calculating fare
		rideRequest.setFare(rideFareCalculatorInterface.calculateFare(rideRequest));

		//Saving ride request
		RideRequestModel newRideRequest = rideRequestRepository.save(rideRequest);

		//Matching driver
		driverMatchingInterface.findMatchingDrivers(rideRequest);

		return modelMapper.map(newRideRequest, RideRequestDto.class);
	}

	@Override
	public RideDto cancelRide(Long rideId) {
		return null;
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
		return null;
	}

	@Override
	public List<RideDto> getRiderAllRides() {
		return List.of();
	}

	@Override
	public RiderModel createRiderProfile(UserModel user) {
		return riderRepository.save(RiderModel.builder().user(user).build());
	}
}
