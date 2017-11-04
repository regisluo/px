package com.bitspur.hi.entity;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = EmployeeType.Values.PERMANENT)
public class PermanentEmployee extends  Employee implements Serializable{
	private BigDecimal salary;
	private BigDecimal bonus;

	public PermanentEmployee(){

	}

	public PermanentEmployee(String name, BigDecimal salary, BigDecimal bonus) {
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
