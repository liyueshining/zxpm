<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
    <form action="user/changePwd" method="post">
    	<table id="advEdit" width="380" height="66">
    		<tr>
    			<td width="20%">用户名</td>
    			<td><input type="text" name="users.userName" value="${sessionScope.user.userName}" /></td>
    		</tr>
    		<tr>
    			<td>密码</td>
    			<td><input type="text" name="users.password" value="${sessionScope.user.password}" /></td>
    		</tr>
    		<tr>
    			<td></td>
    			<td><input type="submit" value="修改" class="btn"/></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
