package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.dao.UserManagementImplementation;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	UserManagementImplementation userDao = new UserManagementImplementation();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		User user = userDao.fetch(email, password);

		if (user != null) {
			if ("admin".equals(user.getUsertype())) {
				List<User> userList = userDao.fetchAll();
				PrintWriter writer = resp.getWriter();

				writer.println("<table border='1'>");
				writer.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>State</th><th>Actions</th></tr>");

				for (User adminUsers : userList) {
					writer.println("<tr>");
					writer.println("<td>" + adminUsers.getUserId() + "</td>");
					writer.println("<td>" + adminUsers.getName() + "</td>");
					writer.println("<td>" + adminUsers.getEmail() + "</td>");
					writer.println("<td>" + adminUsers.getState() + "</td>");
					writer.println("<td><a href='EditServlet?id=" + adminUsers.getUserId() + "?name="
							+ adminUsers.getName() + "?email=" + adminUsers.getEmail() + "?state="
							+ adminUsers.getState() + "'>Edit</a> <a href='DeleteServlet?id=" + adminUsers.getUserId()
							+ "'>Delete</a></td>");
				}
				writer.println("</table>");
			} else {
				PrintWriter writer = resp.getWriter();
				writer.println("<table border='1'>");
				writer.println("<tr><th>Name</th><th>Email</th><th>State</th></tr>");
				writer.println("<tr>");
				writer.println("<td>" + user.getName() + "</td>");
				writer.println("<td>" + user.getEmail() + "</td>");
				writer.println("<td>" + user.getState() + "</td>");
				writer.println("</td>");
				writer.println("</table>");
			}
		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("User Not Found");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
