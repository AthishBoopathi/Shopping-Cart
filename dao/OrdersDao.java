package com.jsp.ShoppingCart_Application.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.ShoppingCart_Application.dto.Orders;

@Repository
public class OrdersDao {
	@Autowired
	EntityManagerFactory emf;
	
	public void saveorders (Orders orders)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(orders);
		et.commit();
	}

	 public Orders ordersById(int id )
	 {
		 EntityManager em = emf.createEntityManager();
		return em.find(Orders.class,id);
	 }
	 public void updateordesById(Orders orders) 
	 {
		 EntityManager em = emf.createEntityManager();
		 EntityTransaction et = em.getTransaction();
		 
		 et.begin();
		 em.merge(orders);
		 et.commit();
	 }
	 public void removeordersById(int id)
	 {
		 EntityManager em = emf.createEntityManager();
		 EntityTransaction et = em.getTransaction();
		 Orders o = em.find(Orders.class, id);
		 
		 et.begin();
		 em.remove(o);
		 et.commit();
	 }
}
