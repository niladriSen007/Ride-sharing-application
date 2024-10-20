package com.niladri.RideSharingApplication.repository.driver;

import com.niladri.RideSharingApplication.model.driver.DriverModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<DriverModel, Long> {
}
