package com.nanda.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanda.dao.CartDAO;
import com.nanda.model.Cart;

@Service
public class CartService {
	@Autowired
	CartDAO cartDAO;
	public boolean addToCart(Cart cart){ 
		return cartDAO.addProduct(cart);
	}
	
	public List<Cart> listCart(String emailId) {
		return cartDAO.listCart(emailId);
	}
	
	public boolean checkOutProduct(String emailId){
		return cartDAO.checkOutProduct(emailId);
	}
}
