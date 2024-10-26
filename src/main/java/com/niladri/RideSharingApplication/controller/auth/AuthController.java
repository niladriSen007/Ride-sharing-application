package com.niladri.RideSharingApplication.controller.auth;

import com.niladri.RideSharingApplication.dto.auth.SignupRequestDto;
import com.niladri.RideSharingApplication.dto.user.UserResponseDto;
import com.niladri.RideSharingApplication.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

	private final AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<UserResponseDto> signup(@RequestBody SignupRequestDto signupRequestDto) {
		return ResponseEntity.ok(authService.signup(signupRequestDto));
	}

}
