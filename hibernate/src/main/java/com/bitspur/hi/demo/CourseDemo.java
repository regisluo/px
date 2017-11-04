package com.bitspur.hi.demo;


import com.bitspur.hi.entity.Course;
import com.bitspur.hi.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CourseDemo {
	public static void main(String args[]){
		Course course = new Course();
		course.setTitle("Java Basic");
		course.setTutor("Jim");

		EntityManager em = JpaUtil.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(course);
		tx.commit();
		em.close();
		JpaUtil.close();
	}
}
