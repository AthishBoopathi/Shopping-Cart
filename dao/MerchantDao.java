package com.jsp.ShoppingCart_Application.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.ShoppingCart_Application.dto.Customer;
import com.jsp.ShoppingCart_Application.dto.Merchant;

@Repository
public class MerchantDao {
	@Autowired
	EntityManagerFactory emf;
	
	public void savemerchant(Merchant merchant)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(merchant);
		et.commit();
	}
	
	public Merchant findmerchantById(int id)
	{
		EntityManager em = emf.createEntityManager();
		return em.find(Merchant.class, id);
	}
	public void updatemerchantById(Merchant merchant)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(merchant);
		et.commit();
	}
	public void removemerchantById(int id ) 
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Merchant m = em.find(Merchant.class,id);
		
		et.begin();
		em.remove(m);
		et.begin();
	}
	public Merchant findmerchantByemailAndpassword(String email,String password)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");
		((javax.persistence.Query) query).setParameter(1,email);
		((javax.persistence.Query) query).setParameter(2,password);
		try 
		{
			 return (Merchant) ((javax.persistence.Query) query).getSingleResult();
		}catch (Exception e)
		{
			return null;
		}
	
	}
	

}
