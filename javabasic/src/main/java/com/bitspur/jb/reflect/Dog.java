package com.bitspur.jb.reflect;

public class Dog extends Animal {

	@Override
	public void sleep() {
		System.out.println(this + ".sleep()");
	}

}
