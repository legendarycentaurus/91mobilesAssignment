package com.nanda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nanda.dto.LoginDTO;
import com.nanda.utils.MailApi;
//import com.nanda.utils.MailMail;
@Repository
public class LoginDAO implements LoginDTO {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private MailApi m;
	@Autowired
	//private MailMail mailService;
	public String verifyLoginQuery(){
		StringBuilder s=new StringBuilder();
		s.append("select email_id,first_name,id from USERS where email_id=? and password=? and verified=0");
		return s.toString();
	}
	@Override
	public boolean verifyLogin(String emailId, String password) {
		String sql = verifyLoginQuery();
		Connection conn = null;
		boolean validLogin=false;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emailId);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				//m.crunchifyReadyToSendEmail("91mobilesnanda@gmail.com", "91mobilesnanda@gmail.com", "Test", "SuccesfulLogin");
				System.out.println("valid Login");
				validLogin=true;
				//mailService.sendMail("91mobilesnanda@gmail.com", "91mobilesnanda@gmail.com", "Hai nada", "Test");
			}
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
		return validLogin;
	}

}
