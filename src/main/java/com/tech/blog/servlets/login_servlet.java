package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.UserInfo;
import com.tech.blog.helper.ConnectionProvider;


public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw =response.getWriter();
		pw.println("<html>");
		pw.println("<head><title>Login Servlet</title></head>");
		pw.println("<body>");
		//login
		//fetch user name and password from request
		String userEmail = request.getParameter("email");
		String userPassword = request.getParameter("password");
		UserDao dao= new UserDao(ConnectionProvider.getConnection());
		UserInfo u = dao.getUserByEmailAndPasswword(userEmail, userPassword);
		if(u==null)
		{
			//login Error...............
			
			//pw.println("invlid Details ... try agian");
			Message msg = new Message("Invalid Details ! try with another", "error", "alert-danger");
			HttpSession s=request.getSession() ;
			s.setAttribute("msg", msg);
			response.sendRedirect("login_page.jsp");
		}
		else {
			//login success
			HttpSession  s = request.getSession();
			s.setAttribute("currentUser", u);
			response.sendRedirect("profile.jsp");
		}
		 
		pw.println("</body>");
		pw.println("<html>");
		pw.close();
	}

}
