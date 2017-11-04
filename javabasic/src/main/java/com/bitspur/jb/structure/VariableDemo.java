package com.bitspur.jb.structure;

public class VariableDemo {
	private String s = "instance string"; // instance variable

	private static String ss = "static String"; // static variable

	public static String method() {
		String localS = "local variable"; // local variable, must be initialized
		return localS;
	}

	public static void main(String[] args) {
		System.out.println(VariableDemo.ss);
		VariableDemo variableDemo = new VariableDemo();
		variableDemo.setS("changed s");
		System.out.println(variableDemo.getS());
		System.out.println(method());

	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

}
