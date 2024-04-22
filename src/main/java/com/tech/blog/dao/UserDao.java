package com.tech.blog.dao;
import java.sql.*;

import com.tech.blog.entities.UserInfo;
public class UserDao
{
	
	private Connection conn;
	
	
	public UserDao(Connection conn)
	{
		
		this.conn = conn;
	}

	//method to insert usert to data base:
	public boolean saveUser(UserInfo user)
	{
		boolean f=false;
		try {
			
			String query ="insert into USERINFO(name,email,password,gender,about) values(?,?,?,?,?)";
			 PreparedStatement ps =this.conn.prepareStatement(query);
			 ps.setString(1, user.getName());
			 ps.setString(2, user.getEmail());
			 ps.setString(3, user.getPassword());
			 ps.setString(4, user.getGender());
			 ps.setString(5, user.getAbout());
			 ps.executeUpdate();
			 f=true;
		}
			 
			 
		
		catch(Exception ex){
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		return f;
	}
	//get user by useremail and userpassword
	public UserInfo getUserByEmailAndPasswword(String email , String password)
	{
		UserInfo user = null;
		try {
			String query ="select * from userinfo where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				user = new UserInfo();
				//data fetch from db
				String name = rs.getString("name");
				//set user object
				user.setName(name);
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setAbout(rs.getString("about"));
				user.setDateTime(rs.getTimestamp("rgdate"));
				user.setProfile(rs.getString("profile"));
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return user;
		
	}
	public boolean updateduser(UserInfo user)
	{
		System.out.println(user);
		boolean b =false;
		try {
			String query ="update userinfo set name=?,password=?,gender=?,about=?,profile=? where email=?";
			PreparedStatement p = conn.prepareStatement(query);
			System.out.println("query perfect");
			p.setString(1, user.getName());
			//p.setString(2, user.getEmail());
			p.setString(2, user.getPassword());
			p.setString(3, user.getGender());
			p.setString(4, user.getAbout());
			p.setString(5, user.getProfile());
			p.setString(6, user.getEmail());
			p.executeUpdate();
		
			b = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return b;
	}
}
