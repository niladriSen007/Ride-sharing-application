package com.niladri.RideSharingApplication.dto.point;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointDto {
	private Double[] coordinates;
	private String type = "Point";
}
