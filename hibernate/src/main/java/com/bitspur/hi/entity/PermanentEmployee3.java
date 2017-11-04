package com.bitspur.hi.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "TPERMANENTEMP3")
public class PermanentEmployee3 extends  Employee3 implements Serializable{
	private BigDecimal salary;
	private BigDecimal bonus;

	public PermanentEmployee3(){

	}

	public PermanentEmployee3(String name, BigDecimal salary, BigDecimal bonus) {
		super(name);
		this.salary = salary;
		this.bonus = bonus;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}
}
