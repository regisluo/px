package com.bitspur.springboot.config;

import org.junit.Before;
import org.springframework.context.annotation.Bean;

import com.bitspur.springboot.demo.HelloWorld;

public class SimpleBeanConfig {

	@Bean(initMethod="myInit2", destroyMethod="myDestroy2")
	public HelloWorld getHelloWorld(){
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setName("Spring2");
		return helloWorld;
	}
}
