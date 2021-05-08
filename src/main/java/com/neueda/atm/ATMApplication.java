package com.neueda.atm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"com.neueda"})
@EnableCaching
@EnableAsync
public class ATMApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ATMApplication.class, args);
	}
}
