package com.hiddenform;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/welcomehiddenform")
public class WelcomeServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");

		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();

		writer.print("Hi " + name);
		writer.print("<form action='hfservlet'>");
		writer.print("<input type='hidden' name='name' value='"+name+"'>");
		writer.print("<br> <input type='submit' value='Go'>");
	}
}
