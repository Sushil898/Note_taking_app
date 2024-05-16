package com.org.dao;

import java.awt.datatransfer.SystemFlavorMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.org.dto.User;

public class UserDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("sushil");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void saveAndUpdateUser(User user) {
		
		et.begin();
		em.merge(user);
		et.commit();
		
	}
	
	
	public User fetchUserByEmailAndPassword(String email,String password) {
		
//		String query = "select s from "
		
		
		return null;
	}
	
}
