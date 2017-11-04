package com.bitspur.jb.generics;

import com.bitspur.jb.container.Student;

public class Postgraduate extends Student {
	private String tutor;

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public Postgraduate(Integer id, String name, String tutor) {
		super(id, name);
		this.tutor = tutor;
	}

	@Override
	public String toString() {
		return "Postgraduate [id= " + this.getId() + ", tutor=" + tutor + "]";
	}

}
