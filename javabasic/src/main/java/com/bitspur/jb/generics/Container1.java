package com.bitspur.jb.generics;

import com.bitspur.jb.container.Student;

public class Container1 {
	private Student student;

	public static void main(String[] args) {
		Container1 container1 = new Container1(new Student(1, "Jim"));
		System.out.println(container1.getStudent());

	}

	public Container1(Student student) {
		super();
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
