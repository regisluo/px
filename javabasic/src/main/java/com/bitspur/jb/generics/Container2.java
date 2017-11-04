package com.bitspur.jb.generics;

import com.bitspur.jb.container.Student;

public class Container2 {
	private Object object;

	public static void main(String[] args) {
		Container2 container2 = new Container2(new Student(2, "Tom"));
		System.out.println(container2.getObject());

		container2.setObject("changed to a string");
		System.out.println(container2.getObject());

	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Container2(Object object) {
		super();
		this.object = object;
	}

}
