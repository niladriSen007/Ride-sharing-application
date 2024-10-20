package com.niladri.RideSharingApplication.service.auth;

import com.niladri.RideSharingApplication.dto.auth.SignupRequestDto;
import com.niladri.RideSharingApplication.dto.driver.DriverResponseDto;
import com.niladri.RideSharingApplication.dto.user.UserResponseDto;

public interface AuthServiceInterface {

	String login(String username, String password);

	UserResponseDto signup(SignupRequestDto signupRequestDto);

	DriverResponseDto signupNewDriver(Long userId);
}
