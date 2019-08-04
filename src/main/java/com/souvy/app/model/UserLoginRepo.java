package com.souvy.app.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface UserLoginRepo extends JpaRepository<UserLoginDetails, String>{
	
	@Modifying
	@Query("update UserLoginDetails u set u.password=?1 where u.username=?2")
	int setPassword(String password,String username);
	
}
