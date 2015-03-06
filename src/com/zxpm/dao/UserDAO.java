package com.zxpm.dao;


import java.util.List;

import com.zxpm.entity.Users;


public interface UserDAO {

	//注册用户
	public void register(Users users);
	
	//查找用户
	public List search(Users users);
	
	//修改用户
	public void update(Users users);
	
	//根据编号获取user对象
	public Users getUsersById(int userId);
}
