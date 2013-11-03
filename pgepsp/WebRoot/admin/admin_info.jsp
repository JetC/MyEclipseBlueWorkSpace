<%@ page language="java" import="java.util.*,org.apache.struts2.ServletActionContext" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
HttpServletRequest _request = ServletActionContext.getRequest();
String a=(String)_request.getAttribute("a_super");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin_info.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body><h2>
    管理员用户名:${a_username}<br/>
    管理员真实姓名:${a_name}<br/>
    管理员权限:<%if(a.equals("yes")){
    out.print("超级管理员权限");
    }
    else{
    out.print("普通管理员权限");
    } %></h2>
  </body>
</html>
