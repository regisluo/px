package com.bitspur.hi.entity;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "TPERMANENTEMP2")
@PrimaryKeyJoinColumn(name = "employee_id")
public class PermanentEmployee2 extends  Employee2 implements Serializable{
	private BigDecimal salary;
	private BigDecimal bonus;

	public PermanentEmployee2(){

	}

	public PermanentEmployee2(String name, BigDecimal salary, BigDecimal bonus) {
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
