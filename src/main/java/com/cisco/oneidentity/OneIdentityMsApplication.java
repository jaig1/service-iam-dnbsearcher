package com.cisco.oneidentity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages = "com.cisco")
public class OneIdentityMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneIdentityMsApplication.class, args);
	}
}
