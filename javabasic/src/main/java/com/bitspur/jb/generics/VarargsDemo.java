package com.bitspur.jb.generics;

import java.util.ArrayList;
import java.util.List;

import com.bitspur.jb.container.Student;

public class VarargsDemo {
	public <T> List<T> getList(String s, T... ts) {
		List<T> list = new ArrayList<>();
		System.out.println(s);
		for (T t : ts) {
			list.add(t);
		}
		return list;
	}

	public static void main(String[] args) {
		VarargsDemo varargsDemo = new VarargsDemo();
		List<String> list = varargsDemo.getList("this is a String", "s");
		for (Object o : list) {
			System.out.println(o);
		}

		Student s = new Student();
		Postgraduate p = new Postgraduate(1, "", "");
		s = p;

		List<Student> ls = new ArrayList<>();
		List<Postgraduate> lp = new ArrayList<>();

		// ls = lp;

	}

}
