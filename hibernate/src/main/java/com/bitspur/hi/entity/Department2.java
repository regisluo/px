package com.bitspur.hi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TDepartment2")
public class Department2 implements Serializable{
	@Id
	private Long id;
	
	@Column(name="department_name")
	private String name;
	
	@OneToOne
	@MapsId
	private Manger2 manger;

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


	public Manger2 getManger() {
		return manger;
	}

	public void setManger(Manger2 manger) {
		this.manger = manger;
	}

	public Department2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department2(String name) {
		super();
		this.name = name;
	}
	
	
	

}
