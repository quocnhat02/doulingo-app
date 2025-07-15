package com.duolingo.clone.common;

import com.duolingo.clone.common.config.ClerkProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ClerkProperties.class)
public class CommonLibApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonLibApplication.class, args);
	}

}
