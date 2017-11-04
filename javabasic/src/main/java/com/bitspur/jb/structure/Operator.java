package com.bitspur.jb.structure;

public class Operator {

	public static void main(String[] args) {
		int i = 0;
		int j = 1;
		System.out.println(i++);// i==1
		System.out.println(++i);// i==2
		j = i++;// j==2,i==3
		System.out.println(j);
		System.out.println(i == j);
		j += i; // j = j+i; j==5;i==3
		// boolean expression?value1:value2
		System.out.println(j == i ? "true" : "false");
		System.out.println(j == i && j > 2);
	}

}
