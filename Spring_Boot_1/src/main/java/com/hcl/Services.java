package com.hcl;

import java.util.List;



@org.springframework.stereotype.Service
public interface Services {
	public void saveUser(User user);

	public List<User> listUser(User user);

	public int deleteUserById(int id2);

	public List<User> allUser();

	public User editCustomer(int id);

	public User updateCustomer(int id, User user);
}
