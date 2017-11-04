package com.bitspur.hi.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TSTUDENT")
public class Student3  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	//List mapping: basic type
	@ElementCollection
	@CollectionTable(name = "person_phone_list", joinColumns = {@JoinColumn(name = "student_id")})
	@Column(name = "person_phone")
	@OrderColumn(name = "phone_order")
	List<String> phones;

	//list mapping: embeddable type
	@ElementCollection
	@CollectionTable(name = "person_address_list", joinColumns = {@JoinColumn(name = "student_id")})
	@AttributeOverrides({@AttributeOverride(name = "addressLine", column = @Column(name = "address_line")),
			@AttributeOverride(name = "type", column = @Column(name = "address_type")),
			@AttributeOverride(name = "postcode", column = @Column(name = "address_postcode"))})
	@OrderBy("postcode")
	List<Address> addresses;

	public Student3() {
	}

	public Student3(String name) {
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

	public List<String> getPhones() {
		return phones;
	}

	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
}
