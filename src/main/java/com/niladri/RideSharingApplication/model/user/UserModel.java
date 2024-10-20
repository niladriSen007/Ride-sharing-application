package com.niladri.RideSharingApplication.model.user;

import com.niladri.RideSharingApplication.model.enums.UserRoles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "app_user")
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	@Column(unique = true)
	private String email;
	private String password;

//	@ElementCollection(fetch = FetchType.LAZY)
//	is an annotation used in JPA (Java Persistence API) to specify that the `roles` field
//	in the `UserModel` class is a collection of elements that are not entities but are still part of the entity's state.
//	   - `@ElementCollection` indicates that the `roles` field is a collection of basic or embeddable types.
//       - `fetch = FetchType.LAZY` specifies that the collection should be fetched lazily,
//		 meaning the data will be loaded on-demand when accessed, rather than being loaded
//	     immediately when the entity is retrieved.
	@ElementCollection(fetch = FetchType.LAZY)
	@Enumerated(EnumType.STRING)
	private Set<UserRoles> roles;




}
