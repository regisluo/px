package com.bitspur.springboot.demo;

import static org.junit.Assert.*;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bitspur.springboot.config.SimpleBeanConfig;

public class HelloWorldTest {
	
	private static ApplicationContext applicationContext;
	private static ApplicationContext applicationContext2;

	@BeforeClass
	public static void beforeClass(){
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		applicationContext2 = new AnnotationConfigApplicationContext(SimpleBeanConfig.class);
	}

	@AfterClass
	public static void AfterClass(){
		//((ClassPathXmlApplicationContext)applicationContext).close();
	}
	@Test
	public void testXmlConfig() {
		HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
		assertTrue(helloWorld.getName().equals("Spring"));
		assertTrue(helloWorld.sayHello().equals("Hello Spring"));

	}
	
	@Test
	public void testJavaConfig(){
		HelloWorld helloWorld = applicationContext2.getBean(HelloWorld.class);
		assertTrue(helloWorld.getName().equals("Spring2"));
		assertTrue(helloWorld.sayHello().equals("Hello Spring2"));
	}

}
