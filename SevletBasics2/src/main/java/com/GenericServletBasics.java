package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/login2")
public class GenericServletBasics extends GenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		String username = arg0.getParameter("username");
		String password = arg0.getParameter("password");
		
		System.out.println("Generic servlet started");
		
		PrintWriter writer = arg1.getWriter();
		writer.print("Hello "+username+"\nYour password is: "+password);
	}

}
