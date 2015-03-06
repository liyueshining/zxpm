package com.zxpm.action;

import com.zxpm.entity.Users;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zxpm.biz.UserBiz;

public class UserAction extends ActionSupport implements RequestAware,SessionAware{

	//使用UserBiz接口声明属性userBiz,并添加set方法 用于依赖注入
	private UserBiz userBiz;
	public void setUserBiz(UserBiz userBiz){
		this.userBiz = userBiz;
	}
	
	
	Map<String, Object> request;
	Map<String, Object> session;
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	
	//定义Users类对象，用于封装表单参数
	private Users users;
	public Users getUsers(){
		return users;
	}	
	public void setUsers(Users users){
		this.users = users;
	}
	
	
	//注册
	public String addUser(){
		userBiz.register(users);
		return "success";
	}
	
	
	//登陆验证
	public String login(){
		Users u = userBiz.getUsers(users);
		if(u != null){
			System.out.println("用户名："+u.getUserName());
			session.put("user", u);
		}
		
		return "index";
	}
	
	//注销
	public String loginout(){
		if(session.get("user") != null){
			session.remove("user");
		}
		return "index";
	}
	
	//修改密码：
	public String changePwd(){
		Users user = (Users)session.get("user");
		user.setPassword(users.getPassword());
		session.put("user", user);
		userBiz.updateUsers(user);
		return "success";
	}
	
}
