package com.bitspur.springboot.demo;

import com.bitspur.springboot.service.Calculator;
import com.bitspur.springboot.service.impl.CalculatorImpl;

public class AopDemo {

	public static void main(String[] args) {
		Calculator calculator = new CalculatorImpl();
		System.out.println(calculator.add(6, 3));
		System.out.println(calculator.sub(6, 3));
		System.out.println(calculator.mul(6, 3));
		System.out.println(calculator.div(6, 3));
	}
}
