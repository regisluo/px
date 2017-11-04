package com.bitspur.jb.generics;

import com.bitspur.jb.container.Student;

public class Container4<T, U> {
	private T t;
	private U u;

	public static void main(String[] args) {
		Student s = new Student(1, "Jim");
		Postgraduate postgraduate = new Postgraduate(2, "Tom", "Alex");
		Container4<Student, Postgraduate> container4 = new Container4<Student, Postgraduate>(s, postgraduate);

		System.out.println(container4.getT());
		System.out.println(container4.getU());
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public U getU() {
		return u;
	}

	public void setU(U u) {
		this.u = u;
	}

	public Container4(T t, U u) {
		super();
		this.t = t;
		this.u = u;
	}

	public Container4() {
		super();
		// TODO Auto-generated constructor stub
	}

}
