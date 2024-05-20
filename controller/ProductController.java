package com.jsp.ShoppingCart_Application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.ShoppingCart_Application.dao.MerchantDao;
import com.jsp.ShoppingCart_Application.dao.ProductDao;
import com.jsp.ShoppingCart_Application.dto.Merchant;
import com.jsp.ShoppingCart_Application.dto.Product;

@Controller
public class ProductController {
	
	@Autowired
	ProductDao dao;
	@Autowired
	MerchantDao mdao;
	
	
	@RequestMapping("/addproduct")
	public ModelAndView addproduct()
	{
		Product product = new Product();
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("productobj" ,product);
		mav.setViewName("addproductjstlform");
		return mav;
		
	}
	@RequestMapping("/saveproduct")
	public ModelAndView saveproduct(@ModelAttribute("productobj") Product product,HttpSession session)
	{
	Merchant m =	(Merchant) session.getAttribute("merchantinfo");
	
	List<Product> products = m.getProduct();
	
	if(products.size()>0)
	{
		products.add(product);
		m.setProduct(products);
	}
	else
	{
		List<Product> products1= new ArrayList<Product>();
		products1.add(product);
		m.setProduct(products1);
	}
		dao.saveproduct(product);
		mdao.updatemerchantById(m);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","product add done");
		mav.setViewName("merchantoption");
		return mav;
	}
	
	@RequestMapping("/viewallproducts") 
	public ModelAndView viewallproduct(HttpSession session)
	{
		Merchant m = (Merchant)session.getAttribute("merchantinfo");
		Merchant merchant = mdao.findmerchantById(m.getId());
		List<Product> products = merchant.getProduct();
		
	
	   List<Product> product = dao.fetchallproduct();
	  
	   ModelAndView mav = new ModelAndView();
	   mav.addObject("allproduct",products);
	   mav.setViewName("listofproducts");
	   return mav;
	}
	@RequestMapping("/fetchallproducts")
	public ModelAndView fetchAllProductstoCustomer()
	{
		 List<Product>  listproducts =   dao.fetchallproduct();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("fetchallproducts", listproducts);
		mav.setViewName("displayallproducts");
		
		return mav;
		
	}
	@RequestMapping("/delete")
   public ModelAndView removeProduct(@RequestParam("id") int pid,HttpSession session) 
	{
		 Merchant m = (Merchant) session.getAttribute("merchantinfo");
		  Merchant merchant=dao.removeproductFromMErchant(m.getId(), pid);
		  dao.removeproductById(pid);
		   ModelAndView mav = new ModelAndView();
		   mav.setViewName("redirect://listofproducts");
		return mav;
	}
	
	@RequestMapping("/displayproducts")
	public ModelAndView displayProducts() 
	{
		List<Product> products = dao.fetchallproduct();
		ModelAndView mav = new ModelAndView();
		mav.addObject("productslist", products);
		mav.setViewName("listofproducts");
		return mav;

}
}
