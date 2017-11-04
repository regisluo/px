package com.bitspur.jb.oo;

public class OODemo extends SuperOODemo {
	private String name; // instance variable
	private int age;
	private static String YES = "y";

	{ // instance initializing block
		name = "Tom";
		age = 20;
		System.out.println("3: instance block");
	}

	static { // static initializing block
		System.out.println("2: static block");
	}

	public static void main(String[] args) {
		OODemo ooDemo = new OODemo("Jim", 200);
		System.out.println(ooDemo.getName() + "'s age is: " + ooDemo.getAge());
		OODemo ooDemo2 = new OODemo();
		System.out.println(ooDemo2.getName() + "'s age is: " + ooDemo2.getAge());
	}

	public OODemo() { // constructor
		super();
		System.out.println("0: constructor");
	}

	public OODemo(String name, int age) {// local variable
		super();
		System.out.println("1: constructor(String, age)");
		this.name = name;
		this.age = age;
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
		if (age > 0 && age < 150) {
			this.age = age;
		} else {
			System.out.println("age is invalid");
		}
	}

}
