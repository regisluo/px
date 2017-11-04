package com.bitspur.springboot.demo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.bitspur.springboot.config.SimpleBeanConfig;

@Component
// @Service
// @Repository
// @Controller
// @RestController
public class HelloWorld implements InitializingBean, DisposableBean {
	private String name;

	public String sayHello() {
		return "Hello " + name;
	}

	public void myInit() {
		System.out.println("HelloWorld.myInit()");
	}

	public void myDestroy() {
		System.out.println("HelloWorld.myDestroy()");
	}

	public void myInit2() {
		System.out.println("HelloWorld.myInit2()");
	}

	public void myDestroy2() {
		System.out.println("HelloWorld.myDestroy2()");
	}

	public HelloWorld() {
		System.out.println("HelloWorld constructor");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("HelloWorld destroy");

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("HelloWorld afterPropertiesSet");

	}

	public static void main(String[] args) {
		// ApplicationContext applicationContext = new
		// ClassPathXmlApplicationContext("applicationContext.xml");
		// ((ClassPathXmlApplicationContext)applicationContext).close();
		ApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(SimpleBeanConfig.class);
		((AnnotationConfigApplicationContext) applicationContext2).close();

	}

}
