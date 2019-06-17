package com.nanda.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nanda.model.Product;
import com.nanda.service.ProductService;

@Controller
public class IndexPageController {
	@Autowired
	ProductService pService;
	@RequestMapping("/afterLogin")
	public ModelAndView afterLogin(HttpServletRequest httpreq,HttpServletResponse httpresp) {
		System.out.println("after login in controller");
		ModelAndView mv;
		System.out.println(httpreq.getSession().getId());
		if(httpreq.getSession().getAttribute("emailId").toString()!=null){
			 mv = new ModelAndView("afterLogin");
		}
		else{
			mv = new ModelAndView("/");
		}
		System.out.println(httpreq.getSession().getAttribute("emailId"));
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest httpreq,HttpServletResponse httpresp) {
		System.out.println("after login in controller");
		ModelAndView mv= new ModelAndView("/index");
		System.out.println(httpreq.getSession().getId());
		httpreq.getSession().removeAttribute("emailId");
		httpreq.getSession().invalidate();
		System.out.println("SessionInvalidated");
		return mv;
	}
	
	@RequestMapping("/home")
	public ModelAndView showItems() {
		System.out.println("in controller");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("name", "Nanda");
		mv.addObject("message", "91 Mobiles");
		return mv;
	}
	
	@RequestMapping("/home/getProducts")
	public @ResponseBody Map<String, List<Product>> getItems() {
		System.out.println("in /home/getProducts controller");
		//Map<String, Object> map=new HashMap<String, Object>();
		
		return pService.getProducts();
	}
	@RequestMapping("/login")
	public ModelAndView login() {
		System.out.println("in controller");
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	@RequestMapping("/signup")
	public ModelAndView signup() {
		System.out.println("in signup controller");
		ModelAndView mv = new ModelAndView("signup");
		return mv;
	}
	
}
