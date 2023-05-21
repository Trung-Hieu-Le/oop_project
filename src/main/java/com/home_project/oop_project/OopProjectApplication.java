package com.home_project.oop_project;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.home_project.oop_project.repository.OrderRepository;
import com.home_project.oop_project.repository.ShipperRepository;
import com.home_project.oop_project.repository.UserRepository;
import com.home_project.oop_project.entity.Order;


@SpringBootApplication
public class OopProjectApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(OopProjectApplication.class, args);
		System.out.println("Every thing is worked!");
	}

	@Autowired
	private OrderRepository orderRepository;
	private ShipperRepository shipperRepository;
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// for(int i = 0; i < 15; i++)
        //     {
        //         Order order = new Order("hà nội","tphcm", 120000, i,"OK "+i);
        //         orderRepository.save(order);
        //     }
		 
		
	}
}
