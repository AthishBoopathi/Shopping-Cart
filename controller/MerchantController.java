package com.jsp.ShoppingCart_Application.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.ShoppingCart_Application.dao.MerchantDao;
import com.jsp.ShoppingCart_Application.dto.Merchant;

@Controller
public class MerchantController 
{
	@Autowired
	MerchantDao dao;

	@RequestMapping("/addmerchant")
	 public ModelAndView addmerchant()
	 {
		Merchant m = new Merchant();
		
		ModelAndView mav = new  ModelAndView();
		mav.addObject("merchantobj",m);
		mav.setViewName("merchantform");
		return mav;
	 }
	
	@RequestMapping("/savemerchant")
	 public ModelAndView savemerchant (@ModelAttribute("merchantobj") Merchant m ) 
	{
		dao.savemerchant(m);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","Register Done");
		mav.setViewName("merchantloginform");
		return mav;
	}
	
	@RequestMapping("/validatemerchant")
	public ModelAndView merchantloginvalidation(ServletRequest req ,HttpSession session)
	{
	  String email = req.getParameter("email");
	  String password = req.getParameter("password");
	  
	  Merchant m = dao.findmerchantByemailAndpassword(email,password);
	  if(m !=null)
	  {
		  ModelAndView mav = new ModelAndView();
		  session.setAttribute("merchantinfo", m);
		  mav.setViewName("merchantoption");
		  return mav;
	  }
	  else
	  {
		  ModelAndView mav = new ModelAndView();
		  mav.addObject("msg","invalid data");
		  mav.setViewName("merchantloginform");
		  return mav;
	  }
	}
	
}



