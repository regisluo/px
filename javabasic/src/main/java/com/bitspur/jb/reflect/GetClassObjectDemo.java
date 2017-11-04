package com.bitspur.jb.reflect;

public class GetClassObjectDemo {
	public static void main(String[] args) {
		// clazz1 is an instance of Class class
		Class clazz1 = Animal.class;
		System.out.println("1: " + clazz1.getName());

		Animal animal = new Animal();
		Class clazz2 = animal.getClass();
		System.out.println("2: " + clazz2.getName());

		try {
			Class clazz3 = Class.forName("com.bitspu3r.jb.reflect.Animal");
			System.out.println("3: " + clazz3.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
