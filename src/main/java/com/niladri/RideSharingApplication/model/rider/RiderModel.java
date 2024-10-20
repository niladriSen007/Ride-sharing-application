package com.niladri.RideSharingApplication.model.rider;

import com.niladri.RideSharingApplication.model.user.UserModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class RiderModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double rating;

	@OneToOne
	@JoinColumn(name = "user_id")
	private UserModel user;

}
