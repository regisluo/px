package com.bitspur.hi.demo;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bitspur.hi.entity.Student;
import com.bitspur.hi.util.JpaUtil;

public class WorkingWithObject {

	public static void main(String[] args) {
		Student student = new Student();
		student.setName("Tom");
		
		EntityManager em = JpaUtil.getEm();
		Session session = JpaUtil.getSession(em);
		Transaction tx = session.getTransaction();
		tx.begin();
		
		Long id = (Long) session.save(student);
		
		System.out.println("Student saved with id: " + id + " and name is: " + student.getName());

		//session.detach(student);
		student.setName("Tom2");
		session.update(student);
		
		Student student2 = session.get(Student.class, (long)1);
		
		session.delete(student2);
		
		tx.commit();
		JpaUtil.close(em);
	}

}
