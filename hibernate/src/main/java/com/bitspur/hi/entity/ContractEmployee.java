package com.bitspur.hi.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

import static com.bitspur.hi.entity.EmployeeType.CONTRACT;

@Entity
@DiscriminatorValue(value = EmployeeType.Values.CONTRACT)
public class ContractEmployee extends Employee implements Serializable {
	private BigDecimal dailyRate;
	private Short term;

	public ContractEmployee() {
	}

	public ContractEmployee(String name, BigDecimal dailyRate, Short term) {
		super(name);
		this.dailyRate = dailyRate;
		this.term = term;
	}

	public BigDecimal getDailyRate() {
		return dailyRate;
	}

	public void setDailyRate(BigDecimal dailyRate) {
		this.dailyRate = dailyRate;
	}

	public Short getTerm() {
		return term;
	}

	public void setTerm(Short term) {
		this.term = term;
	}
}
