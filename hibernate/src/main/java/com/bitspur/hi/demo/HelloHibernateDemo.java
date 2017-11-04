package com.bitspur.hi.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bitspur.hi.entity.Student;

public class HelloHibernateDemo {
	public static void main(String[] args) {
		Student s = new Student();
		s.setName("Jim");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bitspur.px.jpa");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(s);
		tx.commit();
		
		em.close();
		emf.close();
	}
}
