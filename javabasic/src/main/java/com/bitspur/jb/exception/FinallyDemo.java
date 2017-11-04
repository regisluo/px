package com.bitspur.jb.exception;

public class FinallyDemo {
	public static void main(String[] args) {
		String[] ss = new String[4];
		for (int i = 0; i < 3; i++) {
			try {
				if (i == 0) {
					int x = 1 / 0; // runtime exception
				} else if (i == 1) {
					ss[4] = "s";
				} else {
					return;
				}
			} catch (ArithmeticException e) {
				System.out.println("1");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("2");
			} finally {
				System.out.println("3");
			}
		}
	}
}
