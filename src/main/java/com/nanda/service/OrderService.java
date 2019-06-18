package com.nanda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanda.dao.OrderDAO;
import com.nanda.model.Order;

@Service
public class OrderService {
@Autowired
	private OrderDAO orderDao;

	public List<Order> getMyOrders(String emailId){
		return orderDao.myOrders(emailId);
	}
}
