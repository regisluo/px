package com.bitspur.jb.structure;

public class StringDemo {
	private static String base = "base";
	private static int count = 200000;

	public static void main(String[] args) {
		// "a"+"b"
		stringDemo();
		stringBufferDemo();
		stringBuilderDemo();
	}

	public static void stringDemo() {
		long start, end;
		start = System.currentTimeMillis();
		String s = new String(base);
		for (int i = 0; i < count / 10; i++) {
			s += "add";
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static void stringBufferDemo() {
		long start, end;
		start = System.currentTimeMillis();
		StringBuffer sbBuffer = new StringBuffer(base);
		for (int i = 0; i < count; i++) {
			sbBuffer.append("add");
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static void stringBuilderDemo() {
		long start, end;
		start = System.currentTimeMillis();
		StringBuilder sBuilder = new StringBuilder(base);
		for (int i = 0; i < count; i++) {
			sBuilder.append("add");
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}
