package com.bitspur.hi.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TEMPLOYEE3")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "employee3Seq", sequenceName = "employee3_seq", allocationSize = 1)
public class Employee3 implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee3Seq")
	private Long id;

	@Column(name = "employee_name")
	private String name;

	public Employee3() {
	}

	public Employee3(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
