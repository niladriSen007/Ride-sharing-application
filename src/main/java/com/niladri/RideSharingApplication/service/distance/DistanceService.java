package com.niladri.RideSharingApplication.service.distance;

import com.niladri.RideSharingApplication.dto.osrmApiResponse.OsrmApiResponseDto;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class DistanceService implements DistanceServiceInterface {

	private static final String OSRM_API_BASE_URL = "http://router.project-osrm.org/route/v1/driving/";
//	http://router.project-osrm.org/route/v1/driving/13.388860,52.517037;13.397634,52.529407;13.428555,52.523219?overview=false
	@Override
	public double calculateDistance(Point start, Point destination) {
		try{
			OsrmApiResponseDto body = RestClient.builder()
					.baseUrl(OSRM_API_BASE_URL)
					.build()
					.get()
					.uri(start.getX() + "," +
							start.getY() + ";" +
							destination.getX() + "," +
							destination.getY())
					.retrieve()
					.body(OsrmApiResponseDto.class);



			return body.getRoutes().get(0).getDistance();
		}catch (Exception e){
			throw new RuntimeException("Error while calculating distance"+e.getMessage());
		}
	}
}
