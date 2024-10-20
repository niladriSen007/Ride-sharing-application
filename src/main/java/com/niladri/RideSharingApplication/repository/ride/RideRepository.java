package com.niladri.RideSharingApplication.repository.ride;

import com.niladri.RideSharingApplication.model.ride.RideModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<RideModel, Long> {
}
