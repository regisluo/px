package com.bitspur.jb.thread;

public class BiggerPriThread implements Runnable {

	public BiggerPriThread() {
		super();
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
