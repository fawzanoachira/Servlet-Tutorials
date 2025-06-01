package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.UserManagementImplementation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	UserManagementImplementation userDao = new UserManagementImplementation();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();

		writer.println("<html>");
		writer.println("<head><title>Delete User</title></head>");
		writer.println("<body>");
		writer.println("<form action='delete' method='post'>");
		writer.println("<label>Are you sure you want to delete this record with id " + id + " ?</label>");
		writer.println("User id: <input type='text' name='id' value='" + id + "'readonly><br>");
		writer.println("<input type='submit' value='Delete User'>");
		writer.println("</form>");
		writer.println("</head></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		boolean deleteUser = userDao.deleteUser(id);
		if (deleteUser) {
			resp.sendRedirect("login.html");
		} else {
			resp.getWriter().print("User deletion not succesfull");
		}
	}
}
