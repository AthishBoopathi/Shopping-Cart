package com.jsp.ShoppingCart_Application.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.ShoppingCart_Application.dao.CartDao;
import com.jsp.ShoppingCart_Application.dao.CustomerDao;
import com.jsp.ShoppingCart_Application.dto.Cart;
import com.jsp.ShoppingCart_Application.dto.Customer;
import com.jsp.ShoppingCart_Application.dto.Items;

@Controller
public class CartController {
	
@Autowired
CartDao cdao;

@Autowired
CustomerDao c1dao;


@RequestMapping("/fetchallitemscart")
public ModelAndView fetchallitemtocart(HttpSession session)
{
	Customer cus = 	(Customer) session.getAttribute("customerinfo");
	Cart cart = cus.getCart();
	List<Items> listitems = cart.getItems();
	
	ModelAndView mav = new ModelAndView();
	mav.addObject("itemslistobj",listitems);
	mav.addObject("totalprice",cart.getTotalprice());
	mav.setViewName("viewcart");
	
	return mav;
	
	 
	 
}


}
