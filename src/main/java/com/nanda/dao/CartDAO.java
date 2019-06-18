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

import com.nanda.dto.CartDTO;
import com.nanda.model.Cart;
import com.nanda.model.Product;
@Repository
public class CartDAO implements CartDTO {
	@Autowired
	private DataSource dataSource;
	public String addToCartquery(){
		StringBuilder s=new StringBuilder();
		s.append("Insert into CART (email_id,product_id,product_category,item_id,item_description,price) values(?,?,?,?,?,?)");
		return s.toString();
	}
	@Override
	public boolean addProduct(Cart cart) {
		String sql = addToCartquery();
		Connection conn = null;
		int rowInserted=0;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cart.getEmailId());
			ps.setInt(2, cart.getProductId());
			ps.setString(3, cart.getProductCategory());
			ps.setInt(4, cart.getItemId());
			ps.setString(5, cart.getItemdesc());
			ps.setInt(6, cart.getPrice());
			rowInserted=ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			System.out.println(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return rowInserted>0?true:false;
	}

	
	public String getCartDetails(){
		StringBuilder s=new StringBuilder();
			s.append("select id,email_id,product_id,product_category,item_id,item_description,price from CART where email_id=? ");
		return s.toString();
	}
	@Override
	public List<Cart> listCart(String emailId) {
		String sql = getCartDetails();
		Connection conn = null;
		List<Cart> cart= new ArrayList<Cart>();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emailId);
			ResultSet rs=ps.executeQuery(); 
			while(rs.next()){
				Cart c=new Cart();
				c.setCartId(rs.getInt("id"));
				c.setEmailId(rs.getString("email_id"));
				c.setItemdesc(rs.getString("item_description"));
				c.setItemId(rs.getInt("item_id"));
				c.setPrice(rs.getInt("price"));
				c.setProductCategory(rs.getString("product_category"));
				c.setProductId(rs.getInt("product_id"));
				cart.add(c);
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

		return cart;
	}
	public String checkOutCartQuery(){
		StringBuilder s=new StringBuilder();
		s.append("INSERT INTO ORDERS(EMAIL_ID,PRODUCT_CATEGORY,ITEM_DESCRIPTION,PRICE) "); 
s.append("SELECT EMAIL_id,PRODUCT_CATEGORY,ITEM_DESCRIPTION,PRICE FROM CART  WHERE EMAIL_id=?; ");
		return s.toString();
	}
	public String deletFromCartQuery(){
		StringBuilder s=new StringBuilder();
		s.append("DELETE FROM CART  WHERE EMAIL_id=?; ");
		return s.toString();
	}
	@Override
	public boolean checkOutProduct(String emailId) {
		String sql = checkOutCartQuery();
		Connection conn = null;
		int rowInserted=0,rowDeleted=0;
		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emailId);
			rowInserted=ps.executeUpdate();
			ps.close();
			
			sql = deletFromCartQuery();
			PreparedStatement ps1 = conn.prepareStatement(sql);
			ps1.setString(1, emailId);
			rowDeleted=ps1.executeUpdate();
			ps1.close();
			
			
			if(rowInserted>0 && rowDeleted>0){
				 conn.commit();
			}
			else{
				 conn.rollback();
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
		return rowInserted>0?true:false;
	}

}
