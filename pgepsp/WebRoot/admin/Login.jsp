<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/admin.css">
	

  </head>
  
  <body><center>
  <!--  
<table class="admin_login_table" >
    <tr><td bgcolor="#006760" align="center" height="276px"><img src="admin/images/admin_logo.png"  width="434px" height="159px" border="0"></td></tr>
    <tr><td bgcolor="#015D57" height="43px" align="center"><div class="admin_login_word">国家电网环保信息管理后台系统</div></td></tr>
    </table>-->
    
    <div class="admin_login_div1" >
    <div class="admin_login_div1_1" ><img src="admin/images/admin_banner.png"  width="434px" height="159px" border="0"></div>    
    </div>
    <div class="admin_login_div2">
    <div class="admin_login_word">国家电网环保信息管理后台系统</div>
    </div>
    <div>
    <form action="admin/admin_login" method="post">
    <table><tr><td>用户名:</td><td><input type="text" name="a_username" width="100px"/></td><td>${user_check}</td></tr>
    <tr><td>密&nbsp;&nbsp;码:</td><td><input type="password" name="a_password" width="100px"/></td><td></td></tr>
    <tr><td colspan="2"  align="center"><input type="submit" value="登录" style="width: 90px;color:#FFFFFF;background-color: #212121;border-color: #212121;" /></td><td></td></tr></table>
    </form>
    </div></center>
  </body>
</html>
