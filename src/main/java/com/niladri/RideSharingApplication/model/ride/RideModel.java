package com.niladri.RideSharingApplication.model.ride;

import com.niladri.RideSharingApplication.model.driver.DriverModel;
import com.niladri.RideSharingApplication.model.enums.PaymentMethods;
import com.niladri.RideSharingApplication.model.enums.RideStatus;
import com.niladri.RideSharingApplication.model.rider.RiderModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class RideModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "Geometry(Point, 4326)")
	private Point pickupLocation;
	@Column(columnDefinition = "Geometry(Point, 4326)")
	private Point dropLocation;

	@CreationTimestamp
	private LocalDateTime createdTime;

	@ManyToOne(fetch = FetchType.LAZY)
	private RiderModel rider;

	@ManyToOne(fetch = FetchType.LAZY)
	private DriverModel driver;

	@Enumerated(EnumType.STRING)
	private PaymentMethods paymentMethod;

	@Enumerated(EnumType.STRING)
	private RideStatus status;

	private Double fare;
	private LocalDateTime startTime;
	private LocalDateTime endTime;


}
