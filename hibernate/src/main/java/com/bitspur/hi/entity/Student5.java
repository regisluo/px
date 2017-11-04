package com.bitspur.hi.entity;

import com.bitspur.hi.util.AddressComparator;
import org.hibernate.annotations.SortComparator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.SortedSet;

@Entity
@Table(name = "TSTUDENT")
public class Student5 implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@SortComparator(AddressComparator.class)
	@ElementCollection
	@CollectionTable(name = "student5_address", joinColumns = {@JoinColumn(name = "student5_id")})
	SortedSet<Address> addresses;

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

	public SortedSet<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(SortedSet<Address> addresses) {
		this.addresses = addresses;
	}
}
