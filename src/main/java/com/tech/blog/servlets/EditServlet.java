package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.UserInfo;
import com.tech.blog.helper.ConnectionProvider;

@MultipartConfig
public class EditServlet extends HttpServlet {
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw =response.getWriter();
		pw.println("<html>");
		pw.println("<head><title>My First Servlet</title></head>");
		pw.println("<body>");
		
//		Fetch all data
		String userName = request.getParameter("user_name");
		String userEmail = request.getParameter("user_eamil");
		String userpassword = request.getParameter("user_password");
		String userabout = request.getParameter("user_about");
		Part part = request.getPart("image");
		String imageName = part.getSubmittedFileName();
		
		//get the UserInfo(user) from the session
		HttpSession s = request.getSession();
		System.out.println("get http seesion");
		
		UserInfo user =(UserInfo)s.getAttribute("currentUser");
		System.out.println("get user");
		user.setName(userName);
//		user.setEmail(userEmail);
		user.setPassword(userpassword);
		user.setAbout(userabout);
		user.setProfile(imageName);
		System.out.println(" successfully  set property");
		
		//update database...
		UserDao ub = new UserDao(ConnectionProvider.getConnection());
		boolean ans = ub.updateduser(user);
		if(ans)
		{
			
			pw.println("updated to db");	
		}
		else {
			pw.println("not updated");
		}
		
		
		
		pw.println("</body>");
		pw.println("<html>");
		pw.close();
	}

}
