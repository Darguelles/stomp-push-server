package com.verizon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.verizon")
public class PushNotificationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PushNotificationsApplication.class, args);
	}
}
