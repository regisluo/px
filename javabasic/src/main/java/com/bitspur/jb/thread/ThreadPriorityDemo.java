package com.bitspur.jb.thread;

public class ThreadPriorityDemo {
	public static void main(String[] args) {
		Runnable r1 = new BiggerPriThread();
		Thread t1 = new Thread(r1);
		t1.setName("bigger-pri");
		t1.setPriority(9);

		Runnable r2 = new SmallerPriThread();
		Thread t2 = new Thread(r2);
		t2.setName("smaller-pri");
		t2.setPriority(2);

		t1.start();
		t2.start();

	}
}
