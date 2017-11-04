package com.bitspur.hi.util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

public class JpaUtil {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bitspur.px.jpa");;

	public static EntityManager getEm() {
		return emf.createEntityManager();
	}

	public static void close(){
		emf.close();
	}

	
	public static Session getSession(EntityManager em){
		return em.unwrap(Session.class);
	}
	
	public static void close(EntityManager em){
		em.close();
		emf.close();
	}
}
