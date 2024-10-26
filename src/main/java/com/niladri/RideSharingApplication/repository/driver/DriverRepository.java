package com.niladri.RideSharingApplication.repository.driver;

import com.niladri.RideSharingApplication.model.driver.DriverModel;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<DriverModel, Long> {

	@Query(value = "select d,ST_Distance(d.current_location,:pickupLocation) as distance from DriverModel d " +
			"where d.available = true and ST_DWithin(d.current_location, :pickupLocation, 10000) " +
			"order by distance limit 10",nativeQuery = true)
	List<DriverModel> findMatchingDriversNearby(Point pickupLocation);


	@Query(value = "select d,ST_Distance(d.current_location,:pickupLocation) as distance from DriverModel d " +
			"where d.available = true and ST_DWithin(d.current_location, :pickupLocation, 15000) " +
			"order by d.rating desc limit 10",nativeQuery = true)
	List<DriverModel> findMatchingDriversNearbyAndHighestRated(Point pickupLocation);
}
