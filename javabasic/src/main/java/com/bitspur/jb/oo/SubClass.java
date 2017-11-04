package com.bitspur.jb.oo;

public class SubClass extends SuperClass {

	public static String staticString = "11:SubClass -> static String";
	public String non_staticString = "12:SubClass -> non static String";

	public void method(SuperClass superClass, SubClass subClass) {
		System.out.println("1:SubClass->method(SuperClass, SubClass)");
	}

	public void method(SubClass subClass, SuperClass superClass) {
		System.out.println("2:SubClass->method(SubClass, SuperClass)");
	}

	public void method(SubClass subClass1, SubClass subClass2) {
		System.out.println("3:SubClass->method(SubClass, SubClass)");
	}

	/*
	 * 这个方法是后加的，用于演示运行时多态
	 */
	public void method(SuperClass superClass1, SuperClass superClass2) {
		System.out.println("4:SubClass->method(SuperClass, SuperClass)");
	}

	public static void firstMethod() {
		System.out.println("7:SubClass->firstMethod()");
	}

	public void secondMethod() {
		System.out.println("8:SubClass->secondMethod()");
	}

	public void aMethod(String s) {
		System.out.println("SubClass->aMethod()");
	}
}
