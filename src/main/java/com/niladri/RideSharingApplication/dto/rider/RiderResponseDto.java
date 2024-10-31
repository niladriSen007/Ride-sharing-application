package com.niladri.RideSharingApplication.dto.rider;

import com.niladri.RideSharingApplication.dto.user.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiderResponseDto {

	private Long id;
	private UserResponseDto user;
	private Double rating;

}
