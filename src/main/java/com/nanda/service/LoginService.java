package com.nanda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanda.dao.LoginDAO;
import com.nanda.model.Login;

@Service
public class LoginService {
	@Autowired
	LoginDAO loginDao;
	public boolean verify(Login login){
		System.out.println(login.getEmailId());
	    System.out.println(login.getPassword());
	    return loginDao.verifyLogin(login.getEmailId(), login.getPassword());
	} 
}
