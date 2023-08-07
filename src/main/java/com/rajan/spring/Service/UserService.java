package com.rajan.spring.Service;

import com.rajan.spring.Entities.User;

public interface UserService {
	public User addUser(User user);
	public User deletUser(Integer userId);
	public User editUserDetails(Integer userId, User user);
}
