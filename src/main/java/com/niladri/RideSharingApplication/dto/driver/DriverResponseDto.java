package com.niladri.RideSharingApplication.dto.driver;

import com.niladri.RideSharingApplication.dto.user.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverResponseDto {

	private Long id;
	private UserResponseDto user;
	private Double rating;
	private Boolean available;
	private String vehicleId;

}
