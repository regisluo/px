package com.bitspur.jb.exception;

public class SubClass extends SuperClass {
	public void method() {
		/*
		 * If the superclass method declares an exception, subclass overridden
		 * method can declare the same, subclass-exception or no exception but
		 * cannot declare parent-exception
		 */
	}

	public void method2() throws NullPointerException {
		/*
		 * If the superclass method does not declare an exception, subclass
		 * overridden method cannot declare the checked exception but it can
		 * declare unchecked exception
		 */
	}

	/**
	 * any exceptions thrown in super-construct method must be thrown in
	 * sub-construct method
	 * 
	 * @throws SubExceptionThree
	 */
	public SubClass() throws SubExceptionThree {
		super();
	}

}
