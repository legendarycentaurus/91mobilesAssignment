package com.nanda.dto;
import java.util.List;

import com.nanda.model.Order;

public interface OrderDTO {

	public List<Order> myOrders(String emailId);
}
