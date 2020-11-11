package com.middle.SimpleWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SimpleWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleWebApplication.class, args);
                System.out.println("Welcome");
	}
        
        @Bean
        public RestTemplate getRestTemplate() {
            return new RestTemplate();
        }

}
