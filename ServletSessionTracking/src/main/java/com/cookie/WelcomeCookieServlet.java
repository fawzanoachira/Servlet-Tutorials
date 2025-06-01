package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/welcomecookie")
public class WelcomeCookieServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");

		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		Cookie cookie = new Cookie("name", name);
		resp.addCookie(cookie);

		writer.print("Hi " + name);
		writer.print("<br> <a href='SecondPageWithCookie'>Go</a>");
	}
}
