package com.bitspur.jb.exception;

public class AssertDemo {
	public static void main(String[] args) {
		int x = 1;
		assert x < 0 : "x is greater than 0"; // throw AssertionError
	}
}
