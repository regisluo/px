package com.bitspur.hi.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

@Entity
@Table(name = "TSTUDENT")
public class Student4  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	/**
	 * map mapping: key and value is basic type
	 * using @MapKeyColumn to map the key
	 * using @Column to map the value
	 */
	@ElementCollection
	@CollectionTable(name = "student_score", joinColumns = {@JoinColumn(name = "student_id")})
	@MapKeyColumn(name = "subject")
	@Column(name = "score")
	private Map<String, Integer> scores;

	/*
	 * map mapping: map is basic type, value is embeddable
	 */
	@ElementCollection
	@CollectionTable(name = "student_address", joinColumns = {@JoinColumn(name = "student_id")})
	@MapKeyColumn(name = "address_index")
	@AttributeOverrides(value = {@AttributeOverride(name = "addressLine", column = @Column(name = "address_line")),
		@AttributeOverride(name = "type",column = @Column(name = "address_type")),
		@AttributeOverride(name = "postcode",column = @Column(name = "address_postcode"))})
	private Map<Integer, Address> addresses;


	/**
	 * map mapping: map is embeddable, value is basic type
	 */
	@ElementCollection
	@CollectionTable(name = "student_subject_weight", joinColumns = {@JoinColumn(name = "student_id")})
	@MapKeyColumn(name = "subject")
	@Column(name = "interest_weight")
	private Map<Subject,Float> subjectWeight;


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

	public Map<String, Integer> getScores() {
		return scores;
	}

	public void setScores(Map<String, Integer> scores) {
		this.scores = scores;
	}

	public Map<Integer, Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Map<Integer, Address> addresses) {
		this.addresses = addresses;
	}

	public Map<Subject, Float> getSubjectWeight() {
		return subjectWeight;
	}

	public void setSubjectWeight(Map<Subject, Float> subjectWeight) {
		this.subjectWeight = subjectWeight;
	}
}
