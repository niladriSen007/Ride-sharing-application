package com.niladri.RideSharingApplication.service.rideRequest;

import com.niladri.RideSharingApplication.exception.ResourceNotFound;
import com.niladri.RideSharingApplication.model.rideRequest.RideRequestModel;
import com.niladri.RideSharingApplication.repository.rideRequest.RideRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideRequestService implements RideRequestInterface {

	private final RideRequestRepository rideRequestRepository;

	@Override
	public RideRequestModel getRideRequestById(Long rideRequestId) {
		return rideRequestRepository.findById(rideRequestId).orElseThrow(
				()->new ResourceNotFound("Ride Request not found"));
	}

	public void updateRideRequest(RideRequestModel rideRequestModel) {
		rideRequestRepository.findById(rideRequestModel.getId()).orElseThrow(
				()->new ResourceNotFound("Ride Request not found"));
		rideRequestRepository.save(rideRequestModel);
	}
}
