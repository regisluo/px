package com.bitspur.hi.demo;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bitspur.hi.entity.Tutor;
import com.bitspur.hi.entity.TutorId;
import com.bitspur.hi.util.JpaUtil;

public class BasicMappingDemo {
	public static void main(String[] args) {
		TutorId id = new TutorId("Jim", "Green");
		
		//Tutor tutor = new Tutor(id, "04210011001", "jim@gmail.com");
		
		EntityManager em = JpaUtil.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//em.persist(tutor);
		Tutor tutor2 = em.find(Tutor.class, id);
		em.remove(tutor2);
		//System.out.println(tutor2);
		
		tx.commit();
		em.close();
		JpaUtil.close();
	}
}
