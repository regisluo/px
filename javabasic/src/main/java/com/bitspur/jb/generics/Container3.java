package com.bitspur.jb.generics;

import com.bitspur.jb.container.Student;

public class Container3<T> {

	private T t;

	public static void main(String[] args) {
		Container3<String> container3 = new Container3<>("test");
		System.out.println(container3.getT());

		Container3<Student> container32 = new Container3<Student>(new Student(3, "Alex"));
		System.out.println(container32.getT());

	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public Container3() {
		super();
	}

	public Container3(T t) {
		super();
		this.t = t;
	}

}
