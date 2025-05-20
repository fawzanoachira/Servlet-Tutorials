package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/login")
public class ServletBasics implements Servlet{

	@Override
	public void destroy() {
		System.out.println("Servelt Destroyed");
	}

	@Override
	public ServletConfig getServletConfig() {
				return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servelt Initialized");
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		String username = arg0.getParameter("username");
		String password = arg0.getParameter("password");
		
		PrintWriter writer = arg1.getWriter();
		writer.print("Hello "+username+"\nYour password is: "+password);
	}

}
