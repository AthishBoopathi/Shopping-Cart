package com.jsp.ShoppingCart_Application.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.ShoppingCart_Application.dao.CartDao;
import com.jsp.ShoppingCart_Application.dao.CustomerDao;
import com.jsp.ShoppingCart_Application.dao.OrdersDao;
import com.jsp.ShoppingCart_Application.dao.ProductDao;
import com.jsp.ShoppingCart_Application.dto.Orders;

@Controller
public class OrdersController {
	@Autowired
	OrdersDao dao;
	
	@Autowired
	CustomerDao cdao;
	
	@Autowired
	ProductDao pdao;
	
	@Autowired
	CartDao cartdao;
	@RequestMapping("/itemslistobj")
	public ModelAndView addOrder() 
	{
		Orders o = new Orders();
		ModelAndView mav = new ModelAndView();
		mav.addObject("orderobj",o);
		mav.setViewName("Ordersform");
		return mav;
	}
	
	public ModelAndView saveOrder(@ModelAttribute("orderobj")Orders o, HttpSession session)
	{
		return null;
		
	}
	
	

}
