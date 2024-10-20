package com.niladri.RideSharingApplication.model.driver;

import com.niladri.RideSharingApplication.model.user.UserModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Entity
@Getter
@Setter
public class DriverModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "user_id")
	private UserModel user;

	private Double rating;

	private Boolean available;

//	@Column(columnDefinition = "geometry(Point,4326)")
//	is an annotation used in the `DriverModel` class to specify the column definition for the `currentLocation` field.
//		- `@Column` is a JPA annotation that specifies the mapped column for a persistent property or field.
//		- `columnDefinition = "geometry(Point,4326)"` indicates that the column type in the
//			database should be a geometry type with a specific SRID (Spatial Reference System
//			Identifier) of 4326, which corresponds to the WGS 84 coordinate system.
//	This setup is used to store geographical point data (latitude and longitude) in the database.
	@Column(columnDefinition = "Geometry(Point, 4326)")
	private Point currentLocation;
}
