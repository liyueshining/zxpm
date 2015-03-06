package com.zxpm.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zxpm.dao.UserDAO;
import com.zxpm.entity.Users;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO{

	public void register(Users users) {		
		//注册新用户
		super.getHibernateTemplate().save(users);
	}

	public List search(final Users users) {
		//查找用户
		return super.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					
					public Object doInHibernate(Session session) throws HibernateException,
							SQLException {
						Criteria criteria = session.createCriteria(Users.class);
						if(users != null){
							criteria.add(Example.create(users));
						}
						return criteria.list();
					}
				});
	}

	//修改用户
	public void update(Users users) {
		super.getHibernateTemplate().update(users);
	}

	public Users getUsersById(int userId) {
		Users user = (Users)super.getHibernateTemplate().get(Users.class, userId);
		return user;
	}

}
