package com.bitspur.jb.oo;

public class SuperClass {
	public static String staticString = "9:SuperClass -> static String";
	public String non_staticString = "10:SuperClass -> non static String";

	public void method(SuperClass superClass1, SuperClass superClass2) {
		System.out.println("0:SuperClass->method(SuperClass, SuperClass)");
	}

	public static void firstMethod() {
		System.out.println("5:SuperClass->firstMethod()");
	}

	public void secondMethod() {
		System.out.println("6:SuperClass->secondMethod()");
	}

	public void aMethod() {
		System.out.println("SuperClass->aMethod()");
	}
}
