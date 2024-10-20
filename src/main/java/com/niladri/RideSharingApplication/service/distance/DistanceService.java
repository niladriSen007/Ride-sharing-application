package com.niladri.RideSharingApplication.service.distance;

import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanceService implements DistanceServiceInterface {

	@Override
	public double calculateDistance(Point start, Point destination) {
		return 0;
	}
}
