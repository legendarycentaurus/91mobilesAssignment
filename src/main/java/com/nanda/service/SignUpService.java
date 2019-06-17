package com.nanda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanda.dao.SignUpDAO;
import com.nanda.model.SignUp;
@Service
public class SignUpService {
	@Autowired
	SignUpDAO signUpDao;
	
	public boolean save(SignUp signup){
		
		return signUpDao.save(signup);
	}
}
