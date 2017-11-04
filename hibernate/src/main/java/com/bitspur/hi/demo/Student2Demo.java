package com.bitspur.hi.demo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bitspur.hi.entity.Address;
import com.bitspur.hi.entity.Student2;
import com.bitspur.hi.util.JpaUtil;

public class Student2Demo {
 
	public static void main(String[] args) {
		Student2 student2 = new Student2();
		student2.setName("Tom");
//		Set<String> phones = new HashSet<>();
//		phones.add("123");
//		phones.add("456");
//		
//		student2.setPhones(phones);
		
		Set<Address> addresses = new HashSet<Address>();
		Address address1 = new Address("1 dd road", "office", "2000");
		Address address2 = new Address("2 dd road", "home", "2662");
		Address address3 = new Address("3 dd road", "office", "2008");
		addresses.add(address1);
		addresses.add(address2);
		addresses.add(address3);
		student2.setAddresses(addresses);
		
		EntityManager em = JpaUtil.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(student2);
		tx.commit();
		em.close();
		JpaUtil.close();

	}

}
