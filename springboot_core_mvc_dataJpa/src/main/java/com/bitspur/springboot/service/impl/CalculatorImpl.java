package com.bitspur.springboot.service.impl;

import org.springframework.stereotype.Component;

import com.bitspur.springboot.service.Calculator;

@Component
public class CalculatorImpl implements Calculator {

	@Override
	public int add(int i, int j) {
		// System.out.println("add begins...");
		return i + j;
	}

	@Override
	public int sub(int i, int j) {
		// System.out.println("sub begins...");
		return i - j;
	}

	@Override
	public int mul(int i, int j) {
		// System.out.println("mul begins...");
		return i * j;
	}

	@Override
	public int div(int i, int j) {
		// System.out.println("div begins...");
		return i / j;
	}

}
