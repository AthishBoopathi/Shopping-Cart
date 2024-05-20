package com.jsp.ShoppingCart_Application.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.ShoppingCart_Application.dto.Items;

@Repository
public class ItemsDao {
	@Autowired
	EntityManagerFactory emf;
	
	public void saveItems(Items items)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		
		et.begin();
		em.persist(items);
		et.commit();
	}
	
	public Items finditemsById(int id) 
	{
		EntityManager et = emf.createEntityManager();
				return et.find(Items.class, id);
	}
	public void updateitemsById(Items items)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(items);
		et.commit();
	}
	public void removeitemsById(int id )
	{
		EntityManager em =emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Items i = em.find(Items.class,id);
		et.begin();
		em.remove(i);
		et.commit();
	}

}
