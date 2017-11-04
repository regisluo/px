package com.bitspur.hi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ttutor")
public class Tutor implements Serializable{
	
	@EmbeddedId
	private TutorId id;
	
	@Column(name="tutor_mobile")
	private String mobile;
	
	@Column(name="tutor_email")
	private String email;

	public Tutor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tutor(TutorId id, String mobile, String email) {
		super();
		this.id = id;
		this.mobile = mobile;
		this.email = email;
	}

	public TutorId getId() {
		return id;
	}

	public void setId(TutorId id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Tutor [firstName=" + id.getFirstName() + ", lastName="+id.getLastName()+", mobile=" + mobile + ", email=" + email + "]";
	}
	
	
	

}
