package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.blog.entities.Message;


public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw =response.getWriter();
		pw.println("<html>");
		pw.println("<head><title>Login Servlet</title></head>");
		pw.println("<body>");
		HttpSession s = request.getSession();
		s.removeAttribute("currentUser");
		Message m = new Message("Logout Successfully","Success","alert-success");
		s.setAttribute("msg", m);
	response.sendRedirect("login_page.jsp");
		pw.println("</body>");
		pw.println("<html>");
		pw.close();
	}

}
