package com.shaon.NHSystem;

import com.shaon.NHSystem.model.User;
import com.shaon.NHSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NhSystemApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(NhSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		{
			User admin = new User("admin@gmail.com","admin","123456");
			userService.createAdmin(admin);
		}

	}
}
