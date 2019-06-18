package com.nanda.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nanda.model.Cart;
import com.nanda.service.CartService;

@Controller
public class CartController {
	@Autowired
	CartService cartService;
	@RequestMapping("/afterLogin/addProduct")
	public @ResponseBody Map<String, Object> addProduct(@ModelAttribute Cart cart,HttpServletRequest httpreq) {
		System.out.println(httpreq.getSession().getAttribute("emailId"));
		cart.setEmailId(httpreq.getSession().getAttribute("emailId").toString());
		System.out.println(cart.getEmailId());
		Map<String, Object> map=new HashMap<String, Object>();
		if(cartService.addToCart(cart)){
			map.put("errCd",0);
			map.put("errMsg","Item Added to Cart");
		}
		else{
			map.put("errCd",1);
			map.put("errMsg","Please Try After Sometime");
		}
		
		return map;
	}
	
	@RequestMapping("/cart")
	public ModelAndView afterLogin(HttpServletRequest httpreq,HttpServletResponse httpresp) {
		ModelAndView mv;
		if(httpreq.getSession().getAttribute("emailId").toString()!=null){
			 mv = new ModelAndView("cart");
		}
		else{
			mv = new ModelAndView("/");
		}
		return mv;
	}
	
	@RequestMapping("/afterLogin/viewCart")
	public @ResponseBody Map<String, Object> listCart(HttpServletRequest httpreq) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("result", cartService.listCart(httpreq.getSession().getAttribute("emailId").toString()));
		
		return map;
	}
	@RequestMapping("/afterLogin/checkOutCart")
	public @ResponseBody Map<String, Object> checkOutCart(HttpServletRequest httpreq) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("result",cartService.checkOutProduct((httpreq.getSession().getAttribute("emailId").toString())));
		return map;
	}
	
}
