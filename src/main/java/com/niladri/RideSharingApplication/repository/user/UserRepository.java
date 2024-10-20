package com.niladri.RideSharingApplication.repository.user;

import com.niladri.RideSharingApplication.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
}
