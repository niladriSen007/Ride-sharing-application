package com.niladri.RideSharingApplication.dto.osrmApiResponse;

import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.List;

@Data
public class OsrmApiResponseDto {
	private List<OsrmRoute> routes;
}



