package com.bitspur.jb.reflect;

public class Cat extends Animal {

	@Override
	public void sleep() {
		System.out.println(this + ".sleep()");
	}

}
