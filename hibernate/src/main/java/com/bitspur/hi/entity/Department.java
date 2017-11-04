package com.bitspur.hi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TDepartment")
public class Department implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="department_name")
	private String name;
	
	@OneToOne
	@JoinColumn(name = "manager_id")
	private Manger manger;

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

	public Manger getManger() {
		return manger;
	}

	public void setManger(Manger manger) {
		this.manger = manger;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String name) {
		super();
		this.name = name;
	}
	
	
	

}
