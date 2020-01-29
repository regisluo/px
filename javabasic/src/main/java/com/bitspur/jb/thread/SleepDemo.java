package com.bitspur.jb.thread;

public class SleepDemo extends Thread {

	@Override
	public void run() {

		try {
			Thread.sleep(2000);
			System.out.println(this.getName());
			for (int i = 1; i <= 2; i++) {
				System.out.println(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Thread t1 = new SleepDemo();
		t1.setName("Thread-1");
		Thread t2 = new SleepDemo();
		t2.setName("Thread-2");
		t1.start();
		t1.interrupt();
		System.out.println(t1.isInterrupted());
		t2.start();
	}

}
