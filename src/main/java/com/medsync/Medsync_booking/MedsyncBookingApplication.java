package com.medsync.Medsync_booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.medsync.Medsync_booking.Repository")
public class MedsyncBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedsyncBookingApplication.class, args);
	}

}
