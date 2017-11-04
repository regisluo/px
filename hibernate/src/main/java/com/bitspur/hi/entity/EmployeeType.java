	package com.bitspur.hi.entity;


public enum EmployeeType {
	PERMANENT(Values.PERMANENT),
	CONTRACT(Values.CONTRACT);

	private String type;

	EmployeeType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	static class Values{
		public static final String PERMANENT = "1";
		public static final String CONTRACT = "2";
	}

}
