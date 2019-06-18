package com.nanda.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.nanda.model.Order;
import com.nanda.service.CartService;
import com.nanda.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private OrderService  oService;
	@RequestMapping("/afterLogin/viewOrder")
	public @ResponseBody Map<String, Object> listOrders(HttpServletRequest httpreq) {
		System.out.println(httpreq.getSession().getAttribute("emailId"));
		Map<String, Object> map=new HashMap<String, Object>();
		List<Order>  orderList=new ArrayList<Order>();
		orderList=oService.getMyOrders(httpreq.getSession().getAttribute("emailId").toString());
		if(orderList.size()>0){
			map.put("result", orderList);
		}
		else{
			map.put("result", orderList);
		}
		return map;
	}
	
	
	@RequestMapping("/myOrders")
	public ModelAndView afterLogin(HttpServletRequest httpreq,HttpServletResponse httpresp) {
		ModelAndView mv;
		if(httpreq.getSession().getAttribute("emailId").toString()!=null){
			 mv = new ModelAndView("orders");
		}
		else{
			mv = new ModelAndView("/");
		}
		return mv;
	}

}
