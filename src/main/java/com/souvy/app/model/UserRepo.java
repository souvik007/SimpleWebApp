package com.souvy.app.model;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;



@Component
public interface UserRepo extends JpaRepository<User, String>{
	
	public List<User> findByEmail(String email);
	
	public List<User> findByDepartment(String department);
}
