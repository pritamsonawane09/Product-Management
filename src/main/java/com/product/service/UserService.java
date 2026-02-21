package com.product.service;

import com.product.entity.User;

public interface UserService {
	User save(User user);

	User findByUsername(String username);
}
