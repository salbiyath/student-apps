package com.salbiyath.updatestudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UpdateStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpdateStudentApplication.class, args);
	}

}
