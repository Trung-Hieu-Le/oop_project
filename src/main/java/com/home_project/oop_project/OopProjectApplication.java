package com.home_project.oop_project;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class OopProjectApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(OopProjectApplication.class, args);
		System.out.println("Every thing is worked!");
	}

	// @Autowired
	// private OrderRepository orderRepository;
	// private ShipperRepository shipperRepository;
	// private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {

	}
}
