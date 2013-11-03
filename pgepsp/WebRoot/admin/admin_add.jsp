<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form action="admin/admin_add_do" method="post">
  <table>
  <tr><td>新增管理员用户名:</td><td><input type="text"  width="90px" name="a_username"/></td></tr>
  <tr><td>新增管理员的实名:</td><td><input type="text"  width="90px" name="a_name"/></td></tr>
  <tr><td>新增管理员的密码:</td><td><input type="password"  width="90px" name="a_password"/></td></tr>
  <tr><td>新增管理员的权限:</td><td><input type="radio" name="a_super" value="yes"  >超级管理员<input type="radio" name="a_super" value="no" checked="checked"/>普通管理员</td></tr>
  <tr><td></td><td><input type="submit" value="确认添加管理员" ></td></tr>
  </table>
  </form>
  </body>
</html>
