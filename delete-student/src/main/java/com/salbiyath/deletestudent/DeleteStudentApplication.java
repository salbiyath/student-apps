package com.salbiyath.deletestudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DeleteStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeleteStudentApplication.class, args);
	}

}
