package com.bitspur.hi.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TSTUDENT2")
public class Student2 implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	@ElementCollection
	//joinColumn is used for define foreign key
	@CollectionTable(name="student_phone", joinColumns={@JoinColumn(name="student_id")})
	@Column(name="student_phone")
	private Set<String> phones;
	
	@ElementCollection
	@CollectionTable(name="student_address",joinColumns={@JoinColumn(name="student_id")})
	@AttributeOverrides({@AttributeOverride(name="addressLine", column=@Column(name="address_line")),
		@AttributeOverride(name="type", column=@Column(name="address_type")),
		@AttributeOverride(name="postcode", column=@Column(name="address_postcode"))})
	private Set<Address> addresses;
	

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

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	public Student2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student2(Long id, String name, Set<String> phones) {
		super();
		this.id = id;
		this.name = name;
		this.phones = phones;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
	
}
