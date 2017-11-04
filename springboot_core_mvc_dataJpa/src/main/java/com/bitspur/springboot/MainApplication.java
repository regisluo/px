package com.bitspur.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.bitspur.springboot.config.JPAConfig;

@Import({ JPAConfig.class })
@SpringBootApplication
@EnableAspectJAutoProxy
public class MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
