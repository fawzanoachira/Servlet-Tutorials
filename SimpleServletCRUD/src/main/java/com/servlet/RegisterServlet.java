package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.dao.UserManagementImplementation;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	
	UserManagementImplementation u =new UserManagementImplementation();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String usertype = req.getParameter("usertype");
		String state = req.getParameter("state");
		
		User user = new User(name, email, password, usertype, state);
		int save = 0;
		
		try {
			save = u.save(user);
			if(save>0) {
				resp.sendRedirect("login.html");
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
