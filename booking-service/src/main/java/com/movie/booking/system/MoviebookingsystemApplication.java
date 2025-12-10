package com.movie.booking.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MoviebookingsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviebookingsystemApplication.class, args);
	}

}
