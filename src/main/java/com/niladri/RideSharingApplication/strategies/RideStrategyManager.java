package com.niladri.RideSharingApplication.strategies;

import com.niladri.RideSharingApplication.strategies.calculateFare.RideFareCalculatorDefault;
import com.niladri.RideSharingApplication.strategies.calculateFare.RideFareCalculatorInterface;
import com.niladri.RideSharingApplication.strategies.calculateFare.RideFareCalculatorSurgePricingFair;
import com.niladri.RideSharingApplication.strategies.matchingDriver.DriverMatchingHighestRated;
import com.niladri.RideSharingApplication.strategies.matchingDriver.DriverMatchingInterface;
import com.niladri.RideSharingApplication.strategies.matchingDriver.DriverMatchingNearby;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {

	private final DriverMatchingHighestRated driverMatchingHighestRated;
	private final DriverMatchingNearby driverMatchingNearby;
	private final RideFareCalculatorDefault rideFareCalculatorDefault;
	private final RideFareCalculatorSurgePricingFair rideFareCalculatorSurgePricingFair;

	public DriverMatchingInterface driverMatchingStrategy(Double rating){
		if(rating>4.5){
			return driverMatchingHighestRated;
		}
		return driverMatchingNearby;
	}

	public RideFareCalculatorInterface rideFareCalculator(){
		LocalTime surgeStartTime = LocalTime.of(18,0);
		LocalTime surgeEndTime = LocalTime.of(23,59);
		LocalTime currentTime = LocalTime.now();

		if(currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime)){
			return rideFareCalculatorSurgePricingFair;
		}
		return rideFareCalculatorDefault;
	}
}
