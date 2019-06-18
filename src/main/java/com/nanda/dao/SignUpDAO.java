package com.nanda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nanda.dto.SignUpDTO;
import com.nanda.model.SignUp;
@Repository
public class SignUpDAO implements SignUpDTO {
@Autowired
private DataSource dataSource;
public String insertQuery(){
	StringBuilder s=new StringBuilder();
	s.append("INSERT INTO USERS(email_id,first_name,last_name,password) values (?,?,?,?)");
	return s.toString();
}
	@Override
	public boolean save(SignUp signup) {
		String sql = insertQuery();
		Connection conn = null;
		int rowInserted=0;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, signup.getEmailId());
			ps.setString(2, signup.getFirstName());
			ps.setString(3, signup.getLastName());
			ps.setString(4, signup.getPassword());
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
}
