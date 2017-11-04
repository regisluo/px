package com.bitspur.jb.container;

public class LinkedListStackDemo {
	public static void main(String[] args) {
		LinkedListStack stack = new LinkedListStack();

		Student s1 = new Student(1, "Jim");
		Student s2 = new Student(2, "Tim");
		Student s3 = new Student(3, "Alen");

		stack.push(s1);
		stack.push(s2);
		stack.push(s3);

		while (!stack.isEmpty()) {
			Student s = stack.top();
			System.out.println(s.getId() + ":" + s.getName());
			stack.pop();
		}

	}
}
