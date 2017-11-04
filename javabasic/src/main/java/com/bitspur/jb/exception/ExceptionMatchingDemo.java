package com.bitspur.jb.exception;

public class ExceptionMatchingDemo {
	public static void main(String[] args) {
		try {
			throw new SubExceptionOne();
		} catch (SubExceptionOne e) {
			System.out.println("1");
		} catch (Exception e) {

		}

		System.out.println("");

		try {
			throw new SuperException();
		} catch (SubException e) {
			System.out.println("4");
		} catch (SuperException e) {
			System.out.println("5");
		} catch (Exception e) {
			System.out.println("6");
		}

		System.out.println("");

		try {
			throw new Exception();
		} catch (SubException e) {
			System.out.println("7");
		} catch (SuperException e) {
			System.out.println("8");
		} catch (Exception e) {
			System.out.println("9");
		}
	}
}
