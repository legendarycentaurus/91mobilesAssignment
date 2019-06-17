package com.nanda.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nanda.model.Login;
import com.nanda.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService l;
	@RequestMapping(value = "/login/verify", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> addStudent(@ModelAttribute("userFormData")Login login,BindingResult result,HttpServletRequest httpreq) {
   /* model.addAttribute("name", login.getEmailId());
    model.addAttribute("age", login.getPassword());*/
	//LoginService l=new LoginService();
		Map<String, Object> map=new HashMap<String, Object>();
		
	if(l.verify(login)){
	System.out.println("login ");
	map.put("errCd",0);
	map.put("errMsg","");
	httpreq.getSession().getId();
	httpreq.getSession().setAttribute("emailId",login.getEmailId() );
	//map.put("errMsg","Invalid username/password");
	}
	else{
		System.out.println("failure");
		map.put("errCd",1);
		map.put("errMsg","Invalid username/password");
		//return Login;
	}
    return map;
    //return "result";
 }	
}
