package com.hcl;

import java.util.Iterator;


import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;





@Repository
public class DaoImpl implements Dao {
	@Autowired
	SessionFactory factory;

	public void saveUser(User user) {
		factory.getCurrentSession().save(user);
	}

	@Override
	public List<User> listUser(User user) {
		List<User> ls = this.factory.getCurrentSession().createQuery("from User").list();
		return ls;
	}

	@Override
	public int deleteUserById(int id) {
		Session session = this.factory.getCurrentSession();
		return session.createSQLQuery("delete from employee where id = ?").addEntity(User.class)
				.setParameter(0, id).executeUpdate();
	}

	@Override
	public List<User> allUser() {
	
		return this.factory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public User editCustomer(int id) {
		
		SQLQuery query = this.factory.getCurrentSession().createSQLQuery("select * from employee where id=?")
				.addEntity(User.class);
		query.setParameter(0, id);
		List<User> ls = query.list();
		User customer = null;
		Iterator itr = ls.iterator();
		while (itr.hasNext()) {
			customer = (User) itr.next();
		}
		return customer;
	}

	@Override
	public User updateCustomer(int id, User user) {
		System.out.println("Id DAO " + id);
		SQLQuery query=this.factory.getCurrentSession().createSQLQuery("update employee set userName=?,city=?,mobile=? where id=?").addEntity(User.class);
        query.setParameter(0,user.getUserName());
        query.setParameter(1,user.getCity());
        query.setParameter(2,user.getMobile());
        
        query.setParameter(3,id);
        
        query.executeUpdate();

		return null;
	}

}
