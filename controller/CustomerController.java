package com.jsp.ShoppingCart_Application.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.ShoppingCart_Application.dao.CartDao;
import com.jsp.ShoppingCart_Application.dao.CustomerDao;
import com.jsp.ShoppingCart_Application.dto.Cart;
import com.jsp.ShoppingCart_Application.dto.Customer;

@Controller  
public class CustomerController {
	
	@Autowired
	CustomerDao dao;
	
	@Autowired
	CartDao cdao;
	
	@RequestMapping("/addcustomer")
   public ModelAndView addproduct()
   {
		Customer product = new Customer();
		ModelAndView mav = new ModelAndView();
		mav.addObject("customerobj",product);
		mav.setViewName("customerjstlform");
		return mav;
   }
	
	@RequestMapping("/savecustomer")
	public ModelAndView addproduct(@ModelAttribute("customerobj") Customer customer)
	{
		Cart cart = new Cart();
		customer.setCart(cart);
		
		cdao.savecart(cart);
		
		dao.savecustomer(customer);
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","Added Done");
		mav.setViewName("customermenu");
		return mav;
	}
	
   @RequestMapping("/logincustomer")
  public ModelAndView login(ServletRequest req,HttpSession session)
  {
	   String email=req.getParameter("email");
	  String password=req.getParameter("password");
	  
	  Customer cus = dao.findcustomerByEmailAndPassword(email, password);
	  ModelAndView mav = new ModelAndView();
	  
	  
	  if(cus!= null)
	  {
		  session.setAttribute("customerinfo", cus);
		  mav.addObject("msg","login done");
		  mav.setViewName("customeroptions");
		  return mav;
	  }
	  else
	  {
		  mav.setViewName("logincustomer");
		  return mav;
	  }

  }

}
