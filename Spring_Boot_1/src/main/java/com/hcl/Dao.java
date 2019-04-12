package com.hcl;

import java.util.List;


import org.springframework.stereotype.Repository;



@Repository
public interface Dao {

	public void saveUser(User user);

	public List<User> listUser(User user);

	public int deleteUserById(int id);

	public List<User> allUser();

	public User editCustomer(int id);
	
	public User updateCustomer(int id, User customer);

}
