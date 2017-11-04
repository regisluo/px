package com.bitspur.jb.thread;

public class ThreadNamingDemo extends Thread {

	public ThreadNamingDemo(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.print(Thread.currentThread().getName());
	}

	public ThreadNamingDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ThreadNamingDemo t1 = new ThreadNamingDemo("my 1");
		//t1.setName("mythread 1");
		t1.start();
	}
}
