package com.bitspur.jb.thread;

public class SmallerPriThread implements Runnable {

	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

}
