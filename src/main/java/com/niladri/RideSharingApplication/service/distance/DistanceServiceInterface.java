package com.niladri.RideSharingApplication.service.distance;

import org.locationtech.jts.geom.Point;

public interface DistanceServiceInterface {
	double calculateDistance(Point start, Point destination);
}
