package com.nanda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nanda.dto.OrderDTO;
import com.nanda.model.Cart;
import com.nanda.model.Order;
import com.nanda.model.Product;
@Repository
public class OrderDAO implements OrderDTO {

	@Autowired
	private DataSource dataSource;
	public String getmyOrdersQuery(){
		StringBuilder s=new StringBuilder();
		s.append("SELECT EMAIL_ID,PRODUCT_CATEGORY,ITEM_DESCRIPTION,PRICE FROM ORDERS WHERE EMAIL_id=?; "); 
		return s.toString();
	}
	
	@Override
	public List<Order> myOrders(String emailId) {
		String sql = getmyOrdersQuery();
		Connection conn = null;
		List<Order> orderList = new ArrayList<Order>();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emailId);
			ResultSet rs=ps.executeQuery(); 
			while(rs.next()){
				Order o=new Order();
				o.setEmailId(rs.getString("EMAIL_ID"));
				o.setItemDescription(rs.getString("ITEM_DESCRIPTION"));
				o.setPrice(rs.getInt("PRICE"));
				o.setProductCategory(rs.getString("PRODUCT_CATEGORY"));
				orderList.add(o);
			}
			
		} catch (Exception e) {
			System.out.println(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return orderList;
		

	}

}
