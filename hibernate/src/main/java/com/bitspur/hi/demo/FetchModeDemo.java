package com.bitspur.hi.demo;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import com.bitspur.hi.entity.Person;
import com.bitspur.hi.util.JpaUtil;

public class FetchModeDemo {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEm();
		Session session = JpaUtil.getSession(em);

		Person person = session.load(Person.class, (long) 1);

		System.out.println(person.getName());

		System.out.println(person.getPhones().size());

	}
}
