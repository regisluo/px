package com.bitspur.jb.generics;

import java.util.ArrayList;
import java.util.List;

public class WildcardDemo {
	public static void main(String[] args) {
		List<?> list = new ArrayList<>();
		// 1: unbounded wildcare
		// only support read
		// not support write
		// except null
		// list.add("string");
		// list.add(1);
		list.add(null);

		List<String> ss = new ArrayList<>();
		ss.add("1");
		ss.add("2");
		ss.add("3");

		List<Integer> in = new ArrayList<>();
		in.add(4);
		in.add(5);
		in.add(6);

		printElement(ss);
		printElement(in);

		// 2: upper bounded wildcard
		List<? extends A> list2 = new ArrayList<>();
		// list2.add("");
		// only support read
		// not support write
		// except null
		// list2.add(new A());
		// list2.add(new B());
		// list2.add(new C());
		list2.add(null);

		// 3: super bounded wildcard
		// super bounded wildcard support witer,
		// only can add A and subclass of A
		List<? super A> list3 = new ArrayList<>();
		list3.add(new A()); // instance of A "is a" A(and superA)
		list3.add(new B()); // instance of B is a A
		list3.add(new C()); // instance of C is a A
		// list3.add(new Object()); // only can add A and subclass of A

	}

	public static void printElement(List<?> list) {
		for (Object object : list) {
			System.out.println(object);
		}
	}

	public static void printElement2(List<? extends String> list) {
		for (Object object : list) {
			System.out.println(object);
		}
	}
}
