package com.bitspur.jb.oo;

public class OutClass {// 外部类（外围类）out class
	private String s = "string";
	private static String staticS = "static string";

	class InnerClass {// 非静态内部类
		public void imethod() {
			System.out.println("InnerClass:" + s + ":" + staticS);
		}
	}

	/*
	 * 静态内部类和外部类一样，只是“恰巧”定义在外部类中而已
	 */
	static class StaticInnerClass {
		public void simethod() {
			System.out.println("StaticInnerClass:" + staticS);
		}
	}

	public static void main(String[] args) {
		OutClass outClass = new OutClass();
		InnerClass innerClass = outClass.new InnerClass();
		innerClass.imethod();

		StaticInnerClass staticInnerClass = new StaticInnerClass();
		staticInnerClass.simethod();

	}
}
