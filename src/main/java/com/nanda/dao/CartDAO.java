package com.nanda.dao;

import java.util.ArrayList;
import java.util.List;

import com.nanda.dto.CartDTO;
import com.nanda.model.Cart;

public class CartDAO implements CartDTO {

	@Override
	public boolean addProduct(Cart cart) {
		
		return false;
	}

	@Override
	public List<Cart> listCart(String emailId) {
		List<Cart> c=new ArrayList<Cart>();
		
		return c;
	}

}
