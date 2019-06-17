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

import com.nanda.dto.ProductDTO;
import com.nanda.model.Product;
@Repository
public class ProductDAO implements ProductDTO {
	@Autowired
	private DataSource dataSource;
	public String getProductsQuery(){
		StringBuilder s=new StringBuilder();
		s.append("select i.ID id,i.rating rating,i.price price,i.description itemName ,i.product_id product_id,p.description productCategory from ITEM i,PRODUCT p where i.product_id=p.ID;");
		return s.toString();
	}
	@Override
	public List<Product> getProducts() {
		String sql = getProductsQuery();
		Connection conn = null;
		List<Product> product = new ArrayList<Product>();
		try {
			conn = dataSource.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql); 
			while(rs.next()){
				Product p=new Product();
				p.setId(rs.getInt("id"));
				p.setPrice(rs.getInt("price"));
				p.setProduct_id(rs.getInt("product_id"));
				p.setRating(rs.getInt("rating"));
				p.setDescription(rs.getString("itemName"));
				p.setProductCategory(rs.getString("productCategory"));
				product.add(p);
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
		return product;
		
	}

}
