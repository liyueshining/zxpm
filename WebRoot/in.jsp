<%@page import="com.zxpm.entity.Users"%>
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
        <title>导航菜单</title>
  </head>
  
  <body>
    <%
      if(session.getAttribute("user") != null){ 
    %>
    <table align="center">
    	<tr>
    		<td width=''><font color="red">当前用户：
    		<%
    		    Users user = (Users)session.getAttribute("user");
    		%>
    		<%=user.getUserName() %></font>
    		</td>
        </tr>
        <tr>
        	<td width='100'><a href="/zxpm/upload.jsp">添加商品</a></td>
        </tr>
        <tr>
        	<td width='100'><a href="/zxpm/goods/toMyGoods">管理我的商品</a></td>
        </tr>
        <tr>
        	<td width='100'><a href="/zxpm/edit_pwd.jsp">[修改密码]</a></td>
        </tr>
        <tr>
        	<td width='100'><a href="/zxpm/user/loginout">[注销]</a></td>
        </tr>
    </table>
    <%
    }else{
    %>
    <form name="f1" action="/zxpm/user/login" method="post" onsubmit="">
    	<table align="center">
    		<tr>
    			<td colspan="2">用户名：</td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="text" name="users.userName" size="10" class="editbox" /></td>
    		</tr>
    		<tr>
    			<td colspan="2">密&nbsp;&nbsp;码：</td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="password" name="users.password" size="10" class="editbox" /></td>
    		</tr>
    		<tr>
    			<td>
    			    <input type="submit" value="登陆" class='btn'>
    			
    			    <input type="reset" value="重置" class='btn'>
    			</td>
    		</tr>
    		<tr>
    			<td><a href="/zxpm/reg.jsp">注册用户</a></td>
    		</tr>
    		<tr>
    			<td width='100'><a href="/zxpm/index.jsp">返回首页</a>
    	</table>
    </form>
    <%
    } 
    %>
  </body>
</html>
