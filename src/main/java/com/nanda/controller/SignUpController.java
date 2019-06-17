package com.nanda.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nanda.model.SignUp;
import com.nanda.service.SignUpService;

@Controller
public class SignUpController {
	@Autowired
	SignUpService s;
	@RequestMapping(value = "/signup/save", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> save(@ModelAttribute("signup")SignUp signup,BindingResult result,Model model) {
		Map<String, Object> map=new HashMap<String, Object>();
		
	if(s.save(signup)){
	System.out.println("signup ");	
	map.put("errCd", 2);
	map.put("errMsg", "Login into emailId to verify");
	}
	else{
		System.out.println("failure");
		map.put("errCd", 1);
		map.put("errMsg", "Please fill all the details");
	}
    return map;
    //return "result";
 }
}
