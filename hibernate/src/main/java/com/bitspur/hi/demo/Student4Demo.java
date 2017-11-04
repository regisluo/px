package com.bitspur.hi.demo;


import com.bitspur.hi.entity.Address;
import com.bitspur.hi.entity.Student4;
import com.bitspur.hi.entity.Subject;
import com.bitspur.hi.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.HashMap;
import java.util.Map;

public class Student4Demo {
	public static void main(String  args[]){
		Student4 student4 = new Student4();
		student4.setName("student4");

		Map<String, Integer> scores = new HashMap<String, Integer>();
		scores.put("math",99);
		scores.put("java",98);
		scores.put("DB",90);
		student4.setScores(scores);

		Map<Integer, Address> addresses = new HashMap<Integer, Address>();
		Address address = new Address();
		address.setType("HOME");
		address.setAddressLine("101 George Street");
		address.setPostcode("2000");
		addresses.put(1,address);
		student4.setAddresses(addresses);

		Map<Subject,Float> subjectWeight = new HashMap<Subject, Float>();
		Subject subject = new Subject();
		subject.setName("Chinese");
		subjectWeight.put(subject,99.8f);
		student4.setSubjectWeight(subjectWeight);

		EntityManager em = JpaUtil.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(student4);
		tx.commit();
		em.close();
		JpaUtil.close();
	}
}
