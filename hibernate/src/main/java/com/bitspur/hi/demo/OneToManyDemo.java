package com.bitspur.hi.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bitspur.hi.entity.Person;
import com.bitspur.hi.entity.Phone;
import com.bitspur.hi.util.JpaUtil;

public class OneToManyDemo {

	public static void main(String[] args) {
		Person person = new Person("Jim", null);
		
		Phone phone1 = new Phone("123", "HOME", person);
		Phone phone2 = new Phone("456", "OFFICE", person);
		
		List<Phone> phones = new ArrayList<Phone>();
		phones.add(phone1);
		phones.add(phone2);
		
		person.setPhones(phones);
		
		EntityManager em = JpaUtil.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(person);
		em.persist(phone1);
		em.persist(phone2);
		
		tx.commit();
		JpaUtil.close(em);
		

	}

}
