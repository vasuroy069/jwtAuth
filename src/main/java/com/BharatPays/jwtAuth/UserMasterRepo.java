package com.BharatPays.jwtAuth;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMasterRepo extends JpaRepository<UserMaster,Long> {

	UserMaster findByUserName(String userName);
	
	@Query("select u from UserMaster u where u.userName = :userName and u.password=:password")
	UserMaster authenticateUser(@Param("userName") String userName, @Param ("password") String password);

}
