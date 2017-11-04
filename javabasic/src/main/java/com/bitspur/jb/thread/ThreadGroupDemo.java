package com.bitspur.jb.thread;

public class ThreadGroupDemo {
	public static void main(String[] args) {
		ThreadGroup tg = new ThreadGroup("tg");

		Thread t1 = new MyThread(tg, "t1");
		Thread t2 = new MyThread(tg, "t2");
		Thread t3 = new MyThread(tg, "t3");
		t1.start();
		t2.start();
		t3.start();
		tg.list();

	}

}