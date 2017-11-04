package com.bitspur.jb.generics;

public class Container5<T, U, R> extends Container4<T, U> {

	private R r;

	public R getR() {
		return r;
	}

	public void setR(R r) {
		this.r = r;
	}

	public Container5(T t, U u, R r) {
		super(t, u);
		this.r = r;
	}

}
