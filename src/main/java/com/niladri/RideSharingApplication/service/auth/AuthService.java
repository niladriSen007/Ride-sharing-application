package com.niladri.RideSharingApplication.service.auth;

import com.niladri.RideSharingApplication.dto.auth.SignupRequestDto;
import com.niladri.RideSharingApplication.dto.driver.DriverResponseDto;
import com.niladri.RideSharingApplication.dto.user.UserResponseDto;

public class AuthService implements AuthServiceInterface {
	@Override
	public String login(String username, String password) {
		return null;
	}

	@Override
	public UserResponseDto signup(SignupRequestDto signupRequestDto) {
		return null;
	}

	@Override
	public DriverResponseDto signupNewDriver(Long userId) {
		return null;
	}
}
