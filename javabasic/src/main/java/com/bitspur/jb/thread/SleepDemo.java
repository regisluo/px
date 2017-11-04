package com.bitspur.jb.thread;

public class SleepDemo extends Thread {

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			for (int i = 1; i <= 2; i++) {
				System.out.println(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ww");
	}

	public static void main(String[] args) {
		Thread t1 = new SleepDemo();
		Thread t2 = new SleepDemo();
		t1.start();
		t1.interrupt();
		System.out.println(t1.isInterrupted());
		t2.start();
	}

}
