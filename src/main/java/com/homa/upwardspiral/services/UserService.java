package com.homa.upwardspiral.services;

import com.homa.upwardspiral.models.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
