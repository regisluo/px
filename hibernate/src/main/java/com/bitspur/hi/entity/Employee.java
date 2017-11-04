package com.bitspur.hi.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TEMPLOYEE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "employ_type",length = 1)
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="employee_name")
	private String name;

	public Employee() {
	}

	public Employee(String name) {
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
