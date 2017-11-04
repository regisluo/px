package com.bitspur.jb.container;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
	public static void main(String[] args) {
		Set<Integer> hashSet = new HashSet<>();
		Set<Integer> treeSet = new TreeSet<>();

		for (int i = 0; i < 10; i++) {
			hashSet.add((int) (Math.random() * 100));
			treeSet.add((int) (Math.random() * 100));
		}

		Iterator<Integer> it1 = hashSet.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		System.out.println("");
		Iterator<Integer> it2 = treeSet.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}

	}
}
