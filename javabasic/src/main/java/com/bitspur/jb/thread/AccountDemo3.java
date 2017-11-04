package com.bitspur.jb.thread;

import java.math.BigDecimal;

public class AccountDemo3 {// out class
	public static void main(String[] args) {
		Account account = new Account("1", new BigDecimal(1000));
		AccountDemo3 accountDemo1 = new AccountDemo3();
		Thread t1 = accountDemo1.new AccountThread(account, new BigDecimal(100), "t1");
		Thread t2 = accountDemo1.new AccountThread(account, new BigDecimal(200), "t2");
		Thread t3 = accountDemo1.new AccountThread(account, new BigDecimal(-300), "t3");
		Thread t4 = accountDemo1.new AccountThread(account, new BigDecimal(-500), "t4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	class AccountThread extends Thread {// inner class
		private Account account;
		private BigDecimal amount;

		public AccountThread(Account account, BigDecimal amount, String name) {
			super(name);
			this.account = account;
			this.amount = amount;
		}

		@Override
		public void run() {
			account.secureOperate2(amount);
		}

	}

}
