package com.example.springboot_tut.spring_boot_tut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.springboot_tut.spring_boot_tut.dao.UserRepository;
import com.example.springboot_tut.spring_boot_tut.entities.User;

@SpringBootApplication
public class SpringBootTutApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootTutApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);

		User user = new User();
		user.setId(1);
		user.setName("Raj Patani");
		user.setCity("Ahmedabad");
		user.setStatus("I am a java programmer");

		User user1 = userRepository.save(user);

		System.out.println(user1);

	}

}
