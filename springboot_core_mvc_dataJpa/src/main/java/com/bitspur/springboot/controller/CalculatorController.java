package com.bitspur.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitspur.springboot.service.Calculator;

@RestController
public class CalculatorController {

	@Autowired
	private Calculator calculator;

	@RequestMapping("/aop/before")
	public void beforeTest() {
		System.out.println("result to client: " + calculator.add(6, 3));
		System.out.println("result to client: " + calculator.sub(6, 3));
		System.out.println("result to client: " + calculator.mul(6, 3));
		System.out.println("result to client: " + calculator.div(6, 3));

	}

}
