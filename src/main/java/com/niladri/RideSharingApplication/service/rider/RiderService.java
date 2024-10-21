package com.niladri.RideSharingApplication.service.rider;

import com.niladri.RideSharingApplication.dto.driver.DriverResponseDto;
import com.niladri.RideSharingApplication.dto.ride.RideDto;
import com.niladri.RideSharingApplication.dto.rideRequest.RideRequestDto;
import com.niladri.RideSharingApplication.dto.rider.RiderResponseDto;
import com.niladri.RideSharingApplication.model.rideRequest.RideRequestModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RiderService implements RiderServiceInterface {

	private final ModelMapper modelMapper;

	@Override
	public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
		RideRequestModel rideRequest = modelMapper.map(rideRequestDto, RideRequestModel.class);
		return null;
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
}
