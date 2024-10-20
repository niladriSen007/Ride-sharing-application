package com.niladri.RideSharingApplication.dto.user;

import com.niladri.RideSharingApplication.model.enums.UserRoles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

	private String username;
	private String email;
	private Set<UserRoles> roles;
}
