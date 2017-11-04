package com.bitspur.jb.reflect;

public class InstanceOfDemo {
	public static void main(String[] args) {
		Animal a = new Animal();
		Dog d = new Dog();

		Animal a2d = d;
		// group 1
		System.out.println("a instanceof Animal: " + (a instanceof Animal));
		System.out.println("d instanceof Animal: " + (d instanceof Animal));
		System.out.println("a2d instanceof Animal: " + (a2d instanceof Animal));
		System.out.println("a2d instanceof Dog: " + (a2d instanceof Dog));
		System.out.println("a instanceof Dog: " + (a instanceof Dog));
		System.out.println("null instanceof Animal: " + (null instanceof Animal));

		// group 2
		System.out.println("a.getClass().isInstance(d): " + (a.getClass().isInstance(d)));
		System.out.println("a.getClass().isInstance(a2d): " + (a.getClass().isInstance(a2d)));
		System.out.println("a.getClass().isInstance(null): " + (a.getClass().isInstance(null)));

		// group 3
		System.out.println("d.getClass().isInstance(a): " + (d.getClass().isInstance(a)));
		System.out.println("d.getClass().isInstance(a2d): " + (d.getClass().isInstance(a2d)));
		System.out.println("ad.getClass().isInstance(null): " + (d.getClass().isInstance(null)));

		// group 4
		System.out.println("a2d.getClass().isInstance(a): " + (a2d.getClass().isInstance(a)));
		System.out.println("a2d.getClass().isInstance(d): " + (a2d.getClass().isInstance(d)));
		System.out.println("a2d.getClass().isInstance(null): " + (a2d.getClass().isInstance(null)));

	}
}
