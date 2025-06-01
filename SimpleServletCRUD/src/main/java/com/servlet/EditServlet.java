package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.UserManagementImplementation;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	UserManagementImplementation userDao = new UserManagementImplementation();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String state = req.getParameter("state");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head><title>Edit User</title></head>");
		out.println("<body>");
		out.println("<h1>Edit User</h1>");
		out.println("<form action='edit' method='post'>");
		out.println("User id: <input type='text' name='id' value='" + id + "'readonly><br>");
		out.println("Name: <input type='text' name='name' value='" + name + "'><br>");
		out.println("Email:<input type='text' name='email' value='" + email + "'><br>");
		out.println("State: <input type='text' name='state' value='" + state + "'><br>");
		out.println("<input type='submit' value='Update User'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String state = req.getParameter("state");

		User user = new User();
		user.setUserId(id);
		user.setName(name);
		user.setEmail(email);
		user.setState(state);

		boolean updateUser = userDao.updateUser(user);
		if (updateUser) {
			resp.sendRedirect("login.html");
		}
	}
}
