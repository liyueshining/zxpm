package com.zxpm.biz.impl;


import java.util.Iterator;
import java.util.List;

import com.zxpm.biz.UserBiz;
import com.zxpm.dao.UserDAO;
import com.zxpm.entity.Users;

public class UserBizImpl implements UserBiz{

	//使用 UserDAO接口声明对象userDAO，并添加set方法用于依赖注入
	private  UserDAO userDAO;
	public void setUserDAO(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	
	public void register(Users users) {
		userDAO.register(users);	
	}

	//根据条件查询用户
	public Users getUsers(Users users) {
		Users user = null;
		List list = userDAO.search(users);
		Iterator iter = list.iterator();
		if(iter.hasNext()){
			user = (Users)iter.next();
		}
		return user;
	}

	public void updateUsers(Users users) {
		userDAO.update(users);
	}

	public Users getUsersById(int userId) {
		Users user = userDAO.getUsersById(userId);
		return user;
	}

}
