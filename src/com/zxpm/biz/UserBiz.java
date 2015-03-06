package com.zxpm.biz;

import java.util.List;

import com.zxpm.entity.Users;


public interface UserBiz {

	//注册用户
	public void register(Users users);
	
	//根据条件查找用户
	public Users getUsers(Users users);
	
	//修改用户
	public void updateUsers(Users users);
	
	//根据编号 获取user对象
	public Users getUsersById(int userId);
}
