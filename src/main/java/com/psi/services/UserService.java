package com.psi.services;

import java.util.List;

import com.psi.models.User;

public interface UserService
{
	public User saveOrUpdateUser(User user);
	
	public void deleteUser(String username);
	
	public User getUserByUsername(String username);
	
	public User getUserById(int id);
	
	public List<User> getAllUser();
	
	public User LoginUser(String username, String password);
}
