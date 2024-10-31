package com.niladri.RideSharingApplication.repository.ride;

import com.niladri.RideSharingApplication.model.driver.DriverModel;
import com.niladri.RideSharingApplication.model.ride.RideModel;
import com.niladri.RideSharingApplication.model.rider.RiderModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<RideModel, Long> {
	Page<RideModel> findByDriver(DriverModel driver, Pageable pageRequest);

	Page<RideModel> findByRider(RiderModel riderModel, Pageable pageRequest);
}
