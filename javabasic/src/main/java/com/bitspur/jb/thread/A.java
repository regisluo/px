package com.bitspur.jb.thread;

public class A implements Runnable {

	@Override
	public void run() {
		System.out.println("A is running");
	}

	public static void main(String[] args) {
		Thread t = new Thread(new A());
		t.start();
	}

}
