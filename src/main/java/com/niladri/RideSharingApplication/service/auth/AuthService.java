package com.niladri.RideSharingApplication.service.auth;

import com.niladri.RideSharingApplication.dto.auth.SignupRequestDto;
import com.niladri.RideSharingApplication.dto.driver.DriverResponseDto;
import com.niladri.RideSharingApplication.dto.user.UserResponseDto;
import com.niladri.RideSharingApplication.exception.UserAlreadyExists;
import com.niladri.RideSharingApplication.model.enums.UserRoles;
import com.niladri.RideSharingApplication.model.rider.RiderModel;
import com.niladri.RideSharingApplication.model.user.UserModel;
import com.niladri.RideSharingApplication.repository.user.UserRepository;
import com.niladri.RideSharingApplication.service.rider.RiderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class AuthService implements AuthServiceInterface {

	private final ModelMapper modelMapper;
	private final UserRepository userRepository;
	private final RiderService riderService;

	@Override
	public String login(String username, String password) {
		return null;
	}

	@Override
	@Transactional
	public UserResponseDto signup(SignupRequestDto signupRequestDto) {

		UserModel userModel =
				userRepository.findByEmail(signupRequestDto.getEmail()).orElse(null);

		if (userModel != null) {
			throw new UserAlreadyExists("User already exists with email : " + signupRequestDto.getEmail());
		}


		UserModel user = modelMapper.map(signupRequestDto, UserModel.class);
		user.setRoles(Set.of(UserRoles.RIDER));
		UserModel newUser = userRepository.save(user);

		//create user related entities like rider,wallet, etc.
		RiderModel riderProfile = riderService.createRiderProfile(newUser);

		//TODO : create wallet

		return modelMapper.map(newUser, UserResponseDto.class);
	}

	@Override
	public DriverResponseDto signupNewDriver(Long userId) {
		return null;
	}
}
