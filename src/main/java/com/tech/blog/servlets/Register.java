package com.tech.blog.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.UserInfo;
import com.tech.blog.helper.ConnectionProvider;


 
@MultipartConfig
public class Register extends HttpServlet {
	protected void doPost(HttpServletRequest request , HttpServletResponse response)throws ServletException , IOException
	{
		
			PrintWriter out = response.getWriter();
			
//			fetch all form data
			String check = request.getParameter("check");
			if(check==null)
			{
				out.println("box not checked");
			}else
			{
				
				String name = request.getParameter("user_name");
				String email = request.getParameter("user_email");
				String password = request.getParameter("user_password");
				String gender = request.getParameter("gender");
				String about = request.getParameter("about");
				//create user object ad set all data to that obj
				UserInfo user = new UserInfo(name, email, password, gender, about);
				
				
				
				//create UserDao object
				UserDao dao = new UserDao(ConnectionProvider.getConnection());
				
				if(dao.saveUser(user))
				{
					out.println("done");
				}
				else {
					out.println("Error");
				}
				
				
			}
			
			
		
	}

}
