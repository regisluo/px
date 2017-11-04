package com.bitspur.hi.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TEMPLOYEE2")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee2 implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="employee_name")
	private String name;

	public Employee2() {
	}

	public Employee2(String name) {
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

	public void setName() {
		this.name = name;
	}
}
