package com.jsp.ShoppingCart_Application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.ShoppingCart_Application.dao.CartDao;
import com.jsp.ShoppingCart_Application.dao.CustomerDao;
import com.jsp.ShoppingCart_Application.dao.ItemsDao;
import com.jsp.ShoppingCart_Application.dao.ProductDao;
import com.jsp.ShoppingCart_Application.dto.Cart;
import com.jsp.ShoppingCart_Application.dto.Customer;
import com.jsp.ShoppingCart_Application.dto.Items;
import com.jsp.ShoppingCart_Application.dto.Product;

@Controller
public class ItemsController {
	
	@Autowired
	ProductDao pdao;
	
	@Autowired
	ItemsDao idao;
	
	@Autowired
	CartDao cdao;
	
	@Autowired
	CustomerDao cusdao;
	
	
	@RequestMapping("/additemtocart")
	public ModelAndView addItem(@RequestParam("id") int pid) 
	{
		Product p = pdao.findproductById(pid);
		 
		Items i = new Items();
		i.setBrand(p.getBrand());
		i.setCategory(p.getCategory());
		i.setPrice(p.getPrice());
		i.setPid(pid);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemobj",i);
		mav.setViewName("itemform");
		
		return mav;
	
	}
	@RequestMapping("/saveitemtocart")
	public ModelAndView addItemtocart(@ModelAttribute("itemobj") Items i , HttpSession session)
	{
		
		Customer cus = (Customer) session.getAttribute("customerinfo");
		
		Cart cart =  cus.getCart();
		List<Items> listitems =  cart.getItems();
		i.setPrice(i.getPrice()*i.getQuantity());
		cart.setName(cus.getName());
		
		if(listitems.size()>0)
		{
			listitems.add(i);
			cart.setItems(listitems);
			cart.setTotalprice(cart.getTotalprice()+i.getPrice());
			
			
		}else 
		{
			List<Items> item1 = new ArrayList<Items>();
			item1.add(i);
			
			cart.setTotalprice(i.getPrice());
			cart.setItems(item1);
		}
		idao.saveItems(i);
		cdao.Updatecart(cart);
		cusdao.updatecustomer(cus);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","item added successfully");
		mav.setViewName("redirect://fetchallproducts");
		
		return mav;
	}
}

