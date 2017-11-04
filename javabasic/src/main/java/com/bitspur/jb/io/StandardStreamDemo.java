package com.bitspur.jb.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StandardStreamDemo {
	public static void main(String[] args) {
		System.out.println("Please input:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String s = br.readLine();

			List<String> ss = new ArrayList<>();

			while (!s.equalsIgnoreCase("Q")) {
				ss.add(s);
				s = br.readLine();
			}
			System.out.println("after input:");
			for (String s1 : ss) {
				System.err.println(s1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
