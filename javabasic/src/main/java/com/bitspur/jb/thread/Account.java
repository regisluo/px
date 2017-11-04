package com.bitspur.jb.thread;

import java.math.BigDecimal;

public class Account {
	private String id;
	private BigDecimal balance;

	public Account(String id, BigDecimal balance) {
		super();
		this.id = id;
		this.balance = balance;
	}

	public synchronized void withdraw(BigDecimal amount) {
		System.out.println("I want to withdraw: " + amount);
		if (amount != null && amount.compareTo(this.balance) > 0) {
			try {
				System.out.println("No sufficient money! Call boyfriend to deposit");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance = this.balance.subtract(amount);
			System.out.println("Boyfriend's account balance changed to: " + this.balance);
		}
	}

	public synchronized void deposit(BigDecimal amount) {
		System.out.println("Boyfriend is depositing money: $" + amount);
		this.balance = this.balance.add(amount);
		System.out.println("Call girlfriend that money has been saved");
		notify();
		System.out.println("The current balance is: $" + this.balance);
	}

	public void operate(BigDecimal amount) {
		try {
			Thread.sleep(100);
			if (amount != null) {
				this.balance = this.balance.add(amount);
				System.out.println(Thread.currentThread().getName() + ", Balance: " + this.balance);
			}
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void secureOperate(BigDecimal amount) {

		try {
			if (amount != null) {
				synchronized (this) {
					this.balance = this.balance.add(amount);
					System.out.println(Thread.currentThread().getName() + ", Balance: " + this.balance);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public synchronized void secureOperate2(BigDecimal amount) {
		try {
			if (amount != null) {
				this.balance = this.balance.add(amount);
				System.out.println(Thread.currentThread().getName() + ", Balance: " + this.balance);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
