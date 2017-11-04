package com.bitspur.jb.thread;

public class DeadLockDemo {
	public static void main(String[] args) {
		final String r1 = "resource1";
		final String r2 = "resource2";

		new Thread() {
			@Override
			public void run() {
				synchronized (r1) {
					System.out.println("1: t1 locked r1");

					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					synchronized (r2) {
						System.out.println("2: t1 locked r2");
					}
				}
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				synchronized (r2) {
					System.out.println("3: t2 locked r2");

					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					synchronized (r1) {
						System.out.println("4: t2 locked r1");
					}
				}
			}
		}.start();

	}
}
