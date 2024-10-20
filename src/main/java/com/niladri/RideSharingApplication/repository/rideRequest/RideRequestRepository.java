package com.niladri.RideSharingApplication.repository.rideRequest;

import com.niladri.RideSharingApplication.model.rideRequest.RideRequestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRequestRepository extends JpaRepository<RideRequestModel, Long> {
}
