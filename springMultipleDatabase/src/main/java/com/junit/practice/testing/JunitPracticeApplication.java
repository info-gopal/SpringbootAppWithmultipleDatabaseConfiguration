package com.junit.practice.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class JunitPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JunitPracticeApplication.class, args);
	}

}
