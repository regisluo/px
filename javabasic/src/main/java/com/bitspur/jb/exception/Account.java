package com.bitspur.jb.exception;

import java.math.BigDecimal;

public class Account {
	private BigDecimal balance = new BigDecimal(1000);

	public void transfer(BigDecimal amount) throws OutofMoneyException {
		if (balance.compareTo(amount) < 0) {
			throw new OutofMoneyException("balance < amount");
		}
		balance = balance.subtract(amount);
	}

	public static void main(String[] args) {
		BigDecimal amount = new BigDecimal(800);
		Account account = new Account();

		for (int i = 0; i < 3; i++) {
			try {
				account.transfer(amount);
				System.out.println(account.getBalance());
			} catch (Exception e) {
				e.printStackTrace();
			}

			amount = amount.subtract(new BigDecimal(300));
		}

	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
