package com.nanda.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nanda.model.Cart;
import com.nanda.model.Login;

@Controller
public class CartController {
	@RequestMapping("/afterLogin/addProduct")
	public @ResponseBody Map<String, Object> addProduct(@ModelAttribute Cart cart) {
		Map<String, Object> map=new HashMap<String, Object>();
		
		
		return map;
	}
}
