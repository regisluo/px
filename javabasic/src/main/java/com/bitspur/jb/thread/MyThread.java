package com.bitspur.jb.thread;

public class MyThread extends Thread {

	public MyThread(ThreadGroup group, String name) {
		super(group, name);
		// TODO Auto-generated constructor stub
	}

	public MyThread() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		System.out.println("MyThread is running");
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		Thread t = new MyThread();
		t.start();
		System.out.println("main is finish");
	}
}
