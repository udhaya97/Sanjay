package com.hcl;

import java.lang.annotation.Annotation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class ServiceImpl implements Services {
	
	@Autowired
	Dao dao;

	@Override
	public void saveUser(User user) {
		System.out.println("Inside service");
		dao.saveUser(user);
	}

	@Override
	public List<User> listUser(User user) {
		return dao.listUser(user);
		
	}

	@Override
	public int deleteUserById(int id) {
		return dao.deleteUserById(id);
		
	}

	@Override
	public List<User> allUser() {
		
		return dao.allUser();
	}

	@Override
	public User editCustomer(int id) {
	
		return dao.editCustomer(id);
	}

	@Override
	public User updateCustomer(int id, User user) {
	
		return dao.updateCustomer(id,user);
		
	}



}
