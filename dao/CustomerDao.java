package com.jsp.ShoppingCart_Application.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.ShoppingCart_Application.dto.Customer;
import com.mysql.cj.Query;

@Repository
public class CustomerDao {
 
	 @Autowired
	 EntityManagerFactory emf;
	 
	 public void savecustomer(Customer customer)
	 {
		 EntityManager em = emf.createEntityManager();
		 EntityTransaction et = em.getTransaction();
		 
		 et.begin();
		 em.persist(customer);
		 et.commit();
	 }
	 
	 public Customer findcustomerById( int id) 
	 {
		 EntityManager em = emf.createEntityManager();
		return em.find(Customer.class, id);
				 
	 }
	 public void updatecustomer(Customer customer)
	 {
		 EntityManager em = emf.createEntityManager();
		 EntityTransaction et = em.getTransaction();
		 
		 et.begin();
		 em.merge(customer);
		 et.commit();
	 }
	 public void removecustomerById(int id)
	 {
		 EntityManager em = emf.createEntityManager();
		 EntityTransaction et = em.getTransaction();
		 Customer c= em.find(Customer.class, id);
		 et.begin();
		 em.remove(c);
		 et.commit();
	
	 }
	 public   Customer findcustomerByEmailAndPassword(String email,String password)
	 {
		 EntityManager em = emf.createEntityManager();
		javax.persistence.Query query =  em.createQuery("select c from Customer c where c.email=?1 and c.password=?2");
		query.setParameter(1,email);
		query.setParameter(2,password);
		try 
		{
			 return (Customer) query.getSingleResult();
		}catch (Exception e)
		{
			return null;
		}
		
	 }
	 
}
