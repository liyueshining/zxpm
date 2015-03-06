<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@page import="com.zxpm.entity.Users"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<title>在线商品拍卖网</title>
  </head>
  
  <body>
    	<form action="user/addUser" method="post">
    		<table id="advSearch" width="380" height="66">
    			<tr>
    				<td><s:textfield name="users.userName" label="用户名"/></td>
    			</tr>
    			<tr>
    				<td><s:textfield name="users.password" label="密码"/></td>
    			</tr>
    			<tr>
    				<td><s:textfield name="users.telephone" label="联系电话"/></td>
    			</tr>
    			<tr>
    				<td><s:textfield name="users.address" label="通讯地址"/></td>
    			</tr>
    			<tr>
    				<td><s:submit align="left" value="注册"/></td>
    			</tr>
    		</table>
    	
    	</form>
  </body>
</html>
