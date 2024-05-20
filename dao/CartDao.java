package com.jsp.ShoppingCart_Application.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.ShoppingCart_Application.dto.Cart;
import com.mysql.cj.Query;

import antlr.collections.List;

@Repository
public class CartDao {
	
	@Autowired
	 private EntityManagerFactory emf;
	
	
	public void savecart(Cart cart)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		et.begin();
		em.persist(cart);
		et.commit();
	}
	public Cart findcartById(int id) 
	{
		EntityManager em = emf.createEntityManager();
//		Cart c = em.find(Cart.class, id);
		return em.find(Cart.class, id);
		
	}
	
	 public void Updatecart(Cart cart)
	   {
		   EntityManager em = emf.createEntityManager();
		   EntityTransaction et = em.getTransaction();
		
		   et.begin();
		   em.merge(cart);
		   et.commit();
		  
	   }
		
   public void removecartById(int id)
 {
	 EntityManager em = emf.createEntityManager();
	 EntityTransaction et = em.getTransaction();
	 Cart c =em.find(Cart.class,id);
	 
	 et.begin();
	 em.persist(c);
	 et.commit();

 }
  
  
	

}
