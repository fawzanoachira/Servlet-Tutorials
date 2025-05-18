package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/display")
public class Display extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Now here");
		
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String age = req.getParameter("age");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		PrintWriter writer = resp.getWriter();
		writer.print("<p>"+fname+"</p>");
		writer.print("<p>"+lname+"</p>");
		writer.print("<p>"+age+"</p>");
		writer.print("<p>"+email+"</p>");
		writer.print("<p>"+password+"</p>");
	}
}
