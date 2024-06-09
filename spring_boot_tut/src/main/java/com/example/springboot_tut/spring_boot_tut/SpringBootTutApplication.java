package com.example.springboot_tut.spring_boot_tut;

import java.util.List;
import java.util.Optional;

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

		// User user = new User();
		// user.setId(1);
		// user.setName("Raj Patani");
		// user.setCity("Ahmedabad");
		// user.setStatus("I am a java programmer");

		// User user1 = userRepository.save(user);

		// System.out.println(user1);

		// create object of user

		User user1 = new User();
		user1.setCity("Delhi");
		user1.setName("Seenu");
		user1.setStatus("Pyhton programmer");

		User user2 = new User();
		user2.setCity("Ayodhya");
		user2.setName("Ram");
		user2.setStatus("Rust programmer");

		// Saving single user
		// User resultUser = userRepository.save(user1);

		// System.out.println("saved user" + resultUser);
		// List<User> users = List.of(user1, user2);
		// //save multiple objects
		// Iterable<User> result = userRepository.saveAll(users);

		// result.forEach(user -> {
		// System.out.println(user);
		// });
		// System.out.println("Done");

		// Update the user of id 52
		Optional<User> optional = userRepository.findById(52);

		User user = optional.get();

		user.setName("Varun");

		User result = userRepository.save(user);
		System.out.println(result);

		//How to get the data
		Iterable<User> users = userRepository.findAll();

		users.forEach(user -> {
			System.out.println(user);
		});



		
	}

}
