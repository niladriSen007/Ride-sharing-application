package com.niladri.RideSharingApplication.service.ride;

import com.niladri.RideSharingApplication.exception.ResourceNotFound;
import com.niladri.RideSharingApplication.model.driver.DriverModel;
import com.niladri.RideSharingApplication.model.enums.RideRequestStatus;
import com.niladri.RideSharingApplication.model.enums.RideStatus;
import com.niladri.RideSharingApplication.model.ride.RideModel;
import com.niladri.RideSharingApplication.model.rideRequest.RideRequestModel;
import com.niladri.RideSharingApplication.model.rider.RiderModel;
import com.niladri.RideSharingApplication.repository.ride.RideRepository;
import com.niladri.RideSharingApplication.service.rideRequest.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class RideService implements RideServiceInterface {

	private final RideRepository rideRepository;
	private final ModelMapper modelMapper;
	private final RideRequestService rideRequestService;


	@Override
	public RideModel getRideById(Long rideId) {
		return rideRepository.findById(rideId).orElseThrow(() -> new ResourceNotFound("Ride not found"));
	}

	@Override
	public RideModel createNewRide(RideRequestModel rideRequestModel, DriverModel driverModel) {
		rideRequestModel.setStatus(RideRequestStatus.CONFIRMED);

		RideModel rideModel = modelMapper.map(rideRequestModel, RideModel.class);
		rideModel.setStatus(RideStatus.CONFIRMED);
		rideModel.setDriver(driverModel);
		rideModel.setOtp(generateRandomOTP());
		rideModel.setRider(rideRequestModel.getRider());
		rideModel.setId(null);


		rideRequestService.updateRideRequest(rideRequestModel);
		return rideRepository.save(rideModel);

	}

	@Override
	public RideModel updateRideStatus(Long rideId, RideStatus status) {
		RideModel rideModel = rideRepository.findById(rideId).orElseThrow(() -> new ResourceNotFound("Ride not found"));
		rideModel.setStatus(status);
		return rideRepository.save(rideModel);
	}

	@Override
	public Page<RideModel> getAllRidesOfRider(RiderModel riderModel, PageRequest pageRequest) {
		return rideRepository.findByRider(riderModel, pageRequest);
	}

	@Override
	public Page<RideModel> getAllRidesOfDriver(DriverModel driver, PageRequest pageRequest) {
		return rideRepository.findByDriver(driver, pageRequest);
	}



	private String generateRandomOTP() {
		Random random = new Random();
		int otpInt = random.nextInt(10000);  //0 to 9999
		return String.format("%04d", otpInt);
	}
}
