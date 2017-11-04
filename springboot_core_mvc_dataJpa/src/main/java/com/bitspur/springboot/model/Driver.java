package com.bitspur.springboot.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;



public class Driver {

	private String name;
	private int age;
	private String company;
	private BigDecimal salary;
	
	private Car car;
	
	private List<String> certificates;
	
	Map<String, Integer> score;
	
	
	
	
	public Map<String, Integer> getScore() {
		return score;
	}
	public void setScore(Map<String, Integer> score) {
		this.score = score;
	}
	public List<String> getCertificates() {
		return certificates;
	}
	public void setCertificates(List<String> certificates) {
		this.certificates = certificates;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Driver(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Driver(String name, int age, String company) {
		super();
		this.name = name;
		this.age = age;
		this.company = company;
	}
	
	
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public Driver() {
	}
	
	
}
