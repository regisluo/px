package com.bitspur.jb.generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TypeErasureDemo {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		List<String> ss = new ArrayList<>();
		List<Integer> ii = new ArrayList<>();

		System.out.println(ss.getClass() == ii.getClass());
		ss.add("string1");
		Method m = List.class.getMethod("add", Object.class);
		Integer i = 1;
		m.invoke(ss, i);

		for (Object s : ss) {
			System.out.println(s);
		}

		// list1 is not the same to list2
		List<String> list1 = new ArrayList<>();
		List list2 = new ArrayList<String>();// reference
		// Are the below four statements correct?
		// list1.add(1); // 1
		list2.add(1); // 2

		new ArrayList<String>().add("1"); // 3
		// new ArrayList<String>().add(1); // 4
	}
}
