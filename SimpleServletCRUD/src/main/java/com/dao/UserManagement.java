package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.entity.User;

public interface UserManagement {
	public int save(User user) throws ClassNotFoundException, SQLException;

	public User fetch(String email, String password);

	public List<User> fetchAll();

	public boolean updateUser(User user);

	public boolean deleteUser(int userID);

}
