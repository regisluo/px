package com.bitspur.jb.structure;

import java.util.Arrays;

public class ArrayDemo {
	public static void main(String[] args) {
		int[] intArray = new int[3];

		intArray[0] = 2;
		intArray[1] = 1;
		intArray[2] = 3;

		for (int j = 0; j < intArray.length; j++) {
			System.out.println(intArray[j]);
		}

		Arrays.sort(intArray);
		for (int j = 0; j < intArray.length; j++) {
			System.out.println(intArray[j]);
		}
	}
}
