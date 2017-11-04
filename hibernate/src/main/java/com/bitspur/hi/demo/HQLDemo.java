package com.bitspur.hi.demo;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import com.bitspur.hi.entity.Student;
import com.bitspur.hi.util.JpaUtil;

public class HQLDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEm();
		Session session = JpaUtil.getSession(em);

		List<Student> students = session.createQuery("from Student").list();
		System.out.println("from clause: "+students.size());
		
		List<Student> students2 = session.createQuery("select s from Student s").list();
		System.out.println("select clause: "+students2.size());
		
		List<Student> students3 = session.createQuery("select s from Student s where s.name = ?")
				.setParameter(0, "Tom").list();
		System.out.println("expression clause: "+students3.size());
		

	}

}
