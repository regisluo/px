package com.bitspur.hi.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "TCONTRACTEMP3")
public class ContractEmployee3 extends Employee3 implements Serializable {

	private BigDecimal dailyRate;
	private Short term;

	public ContractEmployee3() {
	}

	public ContractEmployee3(String name, BigDecimal dailyRate, Short term) {
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
