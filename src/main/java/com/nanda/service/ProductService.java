package com.nanda.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanda.dao.ProductDAO;
import com.nanda.model.Product;

@Service
public class ProductService {
	@Autowired
	ProductDAO p;
	public Map<String,List<Product>> getProducts(){
		Map<String,List<Product>> productList=new HashMap<String,List<Product>>();
		productList.put("Result",p.getProducts() );
		return productList;
	}
}
