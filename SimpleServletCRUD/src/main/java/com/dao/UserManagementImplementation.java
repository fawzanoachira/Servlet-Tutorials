package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.entity.User;

public class UserManagementImplementation implements UserManagement {

	public static String jdbcUrl = "jdbc:mysql://localhost:3306/servletcrud";
	public static String jdbcUsername = "root";
	public static String jdbcPassword = "hay123";

	@Override
	public int save(User user) throws ClassNotFoundException, SQLException {
		int status = 0;
		Connection conn;

		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
		PreparedStatement statement1 = conn.prepareStatement("INSERT INTO user (name, state) values (?,?)");
		statement1.setString(1, user.getName());
		statement1.setString(2, user.getState());
		statement1.executeUpdate();
		
		PreparedStatement statement2 = conn.prepareStatement("select last_insert_id() from user");
		ResultSet result = statement2.executeQuery();
		while (result.next()) {
			user.setUserId(result.getInt(1));
		}

		PreparedStatement statement3 = conn
				.prepareStatement("INSERT INTO login (email, password, usertype, id) values (?,?,?,?)");
		statement3.setString(1, user.getEmail());
		statement3.setString(2, user.getPassword());
		statement3.setString(3, user.getUsertype());
		statement3.setInt(4, user.getUserId());
		
		status = statement3.executeUpdate();
		return status;

	}

	@Override
	public User fetch(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> fetchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int userID) {
		// TODO Auto-generated method stub
		return false;
	}

}
