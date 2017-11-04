package com.bitspur.jb.structure;

import java.math.BigDecimal;

public class WrapperDemo {
	public static void main(String[] args) {
		int i = 1; // primitive int
		Integer integer = i; // auto-boxing
		int j = integer; // auto-unboxing

		System.out.println(i + j);

		BigDecimal bigDecimal = null;// new BigDecimal("1.2");
		BigDecimal bigDecimal2 = new BigDecimal("2.4");

		if (bigDecimal == null) {
			bigDecimal = BigDecimal.ZERO;
			BigDecimal bigDecimal3 = bigDecimal.add(bigDecimal2);
			System.out.println(bigDecimal3);
		}

		// Long, Short, Character...

	}
}
