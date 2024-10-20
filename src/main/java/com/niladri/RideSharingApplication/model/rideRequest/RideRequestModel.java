package com.niladri.RideSharingApplication.model.rideRequest;

import com.niladri.RideSharingApplication.model.enums.PaymentMethods;
import com.niladri.RideSharingApplication.model.enums.RideRequestStatus;
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
public class RideRequestModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "Geometry(Point, 4326)")
	private Point pickupLocation;
	@Column(columnDefinition = "Geometry(Point, 4326)")
	private Point dropLocation;

	@CreationTimestamp
	private LocalDateTime pickupTime;

	//one rider has many ride requests
	@ManyToOne(fetch = FetchType.LAZY)
	private RiderModel rider;

	@Enumerated(EnumType.STRING)
	private PaymentMethods paymentMethod;

	@Enumerated(EnumType.STRING)
	private RideRequestStatus status;
}
