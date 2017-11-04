package com.bitspur.jb.generics;

public class GenericMethodDemo {

	// add type parameters before return value
	public <T, U> void genericMethod(T t, U u) {
		System.out.println();
		System.out.println(u.getClass());
	}

	public static void main(String[] args) {
		GenericMethodDemo genericMethodDemo = new GenericMethodDemo();
		genericMethodDemo.genericMethod(new String(), new Integer(1));
	}
}
