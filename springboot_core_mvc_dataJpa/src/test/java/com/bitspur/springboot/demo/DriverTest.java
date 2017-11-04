package com.bitspur.springboot.demo;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bitspur.springboot.config.SimpleBeanConfig;
import com.bitspur.springboot.model.Driver;



public class DriverTest {

	private static ApplicationContext applicationContext;
	
	@BeforeClass
	public static void beforeClass(){
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testSetterBasedDI() {
		Driver driver = (Driver) applicationContext.getBean("driver");
//		assertTrue(driver.getAge()==20);
//		assertTrue(driver.getName().equals("Jim"));
		
		//assertTrue(driver.getAge()==19);
		//assertTrue(driver.getName().equals("Tom"));
		assertTrue(driver.getSalary().equals(new BigDecimal("80000")));
		assertTrue(driver.getCar().getBrand().equals("BMW"));
		assertTrue(driver.getCar().getColor().equals("black"));
		List<String> a = driver.getCertificates();
		assertTrue(driver.getCertificates().size()==3);
		Map<String, Integer> map = driver.getScore();
		assertTrue(map.size()==3);
	}

}
