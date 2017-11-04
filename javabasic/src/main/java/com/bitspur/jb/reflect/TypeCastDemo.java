package com.bitspur.jb.reflect;

public class TypeCastDemo {
	public static void main(String[] args) {
		Object[] objects = new Object[] { new Dog(), new Cat() };
		for (Object obj : objects) {
			((Animal) obj).sleep();
		}
	}
}
