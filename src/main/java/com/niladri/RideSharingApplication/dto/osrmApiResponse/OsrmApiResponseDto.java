package com.niladri.RideSharingApplication.dto.osrmApiResponse;

import lombok.Data;

import java.util.List;

@Data
public class OsrmApiResponseDto {
	private List<OsrmRoute> routes;
}



