package com.jsp.ShoppingCart_Application.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.ShoppingCart_Application.dto.Merchant;
import com.jsp.ShoppingCart_Application.dto.Product;


@Repository
public class ProductDao {
	
	@Autowired
	EntityManagerFactory emf;
	
	@Autowired
	MerchantDao mdao;
	
	public void saveproduct(Product product)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
				
		et.begin();
		em.persist(product);
		et.commit();
		      
	}
	public Product findproductById(int id)
	{
		EntityManager em = emf.createEntityManager();
		return em.find(Product.class, id);
	}
	public void updateproductById(Product product)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(product);
		et.commit();
	}
	public void removeproductById(int id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Product p = em.find(Product.class,id);
		
		et.begin();
		em.remove(p);
		et.commit();
	}
	

	public List<Product> findproductByBrand(String brand)
	{
		EntityManager em = emf.createEntityManager();
		Query query= em.createQuery("Select p from Product where p.brand=?1");
		query.setParameter(1, brand);
		
		List<Product> listproduct = query.getResultList();
		 
		return listproduct;
	}
	
	public List<Product> fetchallproduct()
	{
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select p from Product p");
		return q.getResultList();
		
	}
	
	public Merchant removeproductFromMErchant(int mid,int pid)
{
	Merchant m = mdao.findmerchantById(mid);
		List<Product> products = m.getProduct();		
		List<Product> productList = new ArrayList<Product>();
		
		for(Product p: products)
		{			if(p.getId()!= p.getId())
			{
				productList.add(p);			
				}
		}
	
	
	 m.setProduct(productList);
		return m;
		
	}
	
}


