package com.bitspur.jb.container;

import java.util.LinkedList;

public class LinkedListStack {
	LinkedList<Student> data = new LinkedList<>();

	public boolean isEmpty() {
		return data.isEmpty();
	}

	public void push(Student s) {
		data.addFirst(s);
	}

	public Student top() {
		return data.getFirst();
	}

	public void pop() {
		data.removeFirst();
	}

}
