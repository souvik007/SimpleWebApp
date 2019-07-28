package com.souvy.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.souvy.app.model.User;
import com.souvy.app.model.UserRepo;
@SpringBootApplication
public class SimpleWebAppApplication {
	
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext= SpringApplication.run(SimpleWebAppApplication.class, args);
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
