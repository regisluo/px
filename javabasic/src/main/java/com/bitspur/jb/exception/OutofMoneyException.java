package com.bitspur.jb.exception;

public class OutofMoneyException extends Exception {

	public OutofMoneyException() {
		super();
	}

	public OutofMoneyException(String message) {
		super(message);
	}

	public static void main(String[] args) {
		OutofMoneyException outofMoneyException = new OutofMoneyException();
		outofMoneyException.printStackTrace();
	}

}
