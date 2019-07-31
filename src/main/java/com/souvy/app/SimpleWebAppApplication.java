package com.souvy.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class SimpleWebAppApplication {
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(SimpleWebAppApplication.class, args);
//		User user= applicationContext.getBean(User.class);
//		user.setId("12");
//		user.setName("souvik");
//		user.setEmail("Email@demo.com");
//		user.setPassword("12345");
//		user.setSQues("na");
//		user.setSAns("na");
//		
//		UserRepo uRepo = applicationContext.getBean(UserRepo.class);
//		uRepo.save(user);
//		System.out.println(uRepo.findById("12").toString());
	}

}
