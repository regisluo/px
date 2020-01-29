package com.bitspur.jb.thread;

public class ThutdownHookDemo {
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		runtime.addShutdownHook(new MyThread());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
		System.out.println("main is finish");
	}
}
