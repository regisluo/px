package com.bitspur.jb.thread;

import java.math.BigDecimal;

public class ThreadCommunicationDemo {
	public static void main(String[] args) {
		Account account = new Account("1", new BigDecimal(10000));

		new Thread() {
			@Override
			public void run() {
				account.withdraw(new BigDecimal(30000));
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				account.deposit(new BigDecimal(20000));
			}
		}.start();

	}

}
