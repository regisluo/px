package com.bitspur.jb.structure;

import java.util.ArrayList;
import java.util.List;

public class StatementsDemo {
	public static void main(String[] args) {
		// selectionDemo();
		/*
		 * dlajfd ldsfj ldsjf
		 */
		loopDemo();// comments...
	}

	private static void loopDemo() {
		// int i = 3;
		// while (i > 0) {
		// System.out.println(i);
		// i--;
		// }
		// System.out.println("");
		// for (int j = 0; j < 5; j++) {
		// System.out.println(j);
		// }

		System.out.println("");

		List<Integer> list = new ArrayList<Integer>();
		for (int k = 0; k < 3; k++) {

			list.add(k);
		}

		for (int m = 0; m < 3; m++) {
			if (m == 1) {
				// continue;
				break;
			}

			System.out.println(list.get(m));
		}
		//
		// for (Object i : list) {
		//
		// System.out.println(i);
		// }

	}

	private static void selectionDemo() {
		// ifDemo();
		switchDemo();
	}

	/**
	 * switchDemo
	 * 
	 * @author regisl
	 */
	private static void switchDemo() {
		int i = 1;
		switch (i) {
		case 0:
			System.out.println("i is 0");
			break;
		case 1:
			System.out.println("i is 1");
			break;
		default:
			System.out.println("other value");
			break;
		}

		String s = "yes";
		switch (s) {
		case "yes":
			System.out.println("yes");
			break;
		case "no":
			System.out.println("no");
			break;
		default:
			System.out.println("other value");
			break;
		}
		enumSwitchDemo(Color.BLUE);
	}

	private static void enumSwitchDemo(Color color) {
		switch (color) {
		case RED:
			System.out.println("red");
			break;
		case BLUE:
			System.out.println("blue");
			break;
		case GREEN:
			System.out.println("green");
			break;
		default:
			System.out.println("other color");
			break;
		}

	}

	private static void ifDemo() {
		int i = 1;
		int j = 0;
		if (i == 1) {
			System.out.println("i is 1");
			if (j == 0) {
				System.out.println("j is 0");
			} else {
				System.out.println("");
			}
		} else if (i == 2) {
			System.out.println("i is 2");
		} else {
			System.out.println("other value");
		}

	}
}
