package com.bitspur.hi.demo;


import com.bitspur.hi.entity.Address;
import com.bitspur.hi.entity.Student3;
import com.bitspur.hi.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class Student3Demo {
	public static void main(String args[]){
		Student3 student3 = new Student3();
		//student3.setId((long)3);
		student3.setName("Alan");
//
//		List<String> phones = new ArrayList<String>();
//		phones.add("0420000000");
//		phones.add("0420000001");
//		phones.add("0420000002");
//		student3.setPhones(phones);
//
		List<Address> addresses = new ArrayList<Address>();
		Address address1 = new Address();
		address1.setType("home");
		address1.setAddressLine("200 home street zetland");
		address1.setPostcode("2017");

		Address address2 = new Address();
		address2.setType("office");
		address2.setAddressLine("108 George street sydney");
		address2.setPostcode("2000");

		addresses.add(address1);
		addresses.add(address2);
		student3.setAddresses(addresses);

		EntityManager em = JpaUtil.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(student3);
		
		

//		Student3 student31 = em.find(Student3.class,Long.valueOf(1));
//		List<Address> addresses2 = student31.getAddresses();
//		for(Address address:addresses2){
//			System.out.println(address);
//		}

		tx.commit();

		em.close();
		JpaUtil.close();
	}
}
