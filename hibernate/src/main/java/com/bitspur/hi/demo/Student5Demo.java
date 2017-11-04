package com.bitspur.hi.demo;

import com.bitspur.hi.entity.Address;
import com.bitspur.hi.entity.Student5;
import com.bitspur.hi.util.AddressComparator;
import com.bitspur.hi.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Student5Demo {
	public static void main(String args[]){
		Student5 student5 = new Student5();
		student5.setName("student5");

		SortedSet<Address> addresses = new TreeSet<Address>(new AddressComparator());
		Address address1 =  new Address("home","home address 1", "2010");
		Address address2 =  new Address("office1","office address 1", "2000");
		Address address3 =  new Address("office2","office address 2", "2060");

		addresses.add(address1);
		addresses.add(address2);
		addresses.add(address3);

		student5.setAddresses(addresses);

		EntityManager em = JpaUtil.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(student5);
		tx.commit();
		em.close();
		JpaUtil.close();
	}
}
