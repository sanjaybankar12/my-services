package com.myservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@Configuration
@ComponentScan(basePackages="com.myservices")
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MyServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyServicesApplication.class, args);
	}
}
