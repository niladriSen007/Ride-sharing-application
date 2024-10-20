package com.niladri.RideSharingApplication.repository.rider;

import com.niladri.RideSharingApplication.model.rider.RiderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<RiderModel, Long> {
}
