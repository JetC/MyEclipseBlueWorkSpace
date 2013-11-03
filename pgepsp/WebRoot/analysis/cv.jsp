<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cv.jsp' starting page</title>
    
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
    <img src="analysis/toplookingcount" width="500" height="400"/>
    <table border="1">
    <tr><td>文章id</td><td>点击量</td><td>栏目</td><td>标题</td></tr>
    <tr><td><s:property value="data[0][0]"/></td><td><s:property value="data[1][0]"/></td><td><s:property value="data[2][0]"/></td><td><s:property value="data[3][0]"/></td></tr>
    <tr><td><s:property value="data[0][1]"/></td><td><s:property value="data[1][1]"/></td><td><s:property value="data[2][1]"/></td><td><s:property value="data[3][1]"/></td></tr>
    <tr><td><s:property value="data[0][2]"/></td><td><s:property value="data[1][2]"/></td><td><s:property value="data[2][2]"/></td><td><s:property value="data[3][2]"/></td></tr>
    <tr><td><s:property value="data[0][3]"/></td><td><s:property value="data[1][3]"/></td><td><s:property value="data[2][3]"/></td><td><s:property value="data[3][3]"/></td></tr>
    <tr><td><s:property value="data[0][4]"/></td><td><s:property value="data[1][4]"/></td><td><s:property value="data[2][4]"/></td><td><s:property value="data[3][4]"/></td></tr>
    <tr><td><s:property value="data[0][5]"/></td><td><s:property value="data[1][5]"/></td><td><s:property value="data[2][5]"/></td><td><s:property value="data[3][5]"/></td></tr>
    <tr><td><s:property value="data[0][6]"/></td><td><s:property value="data[1][6]"/></td><td><s:property value="data[2][6]"/></td><td><s:property value="data[3][6]"/></td></tr>
    <tr><td><s:property value="data[0][7]"/></td><td><s:property value="data[1][7]"/></td><td><s:property value="data[2][7]"/></td><td><s:property value="data[3][7]"/></td></tr>
    <tr><td><s:property value="data[0][8]"/></td><td><s:property value="data[1][8]"/></td><td><s:property value="data[2][8]"/></td><td><s:property value="data[3][8]"/></td></tr>
    <tr><td><s:property value="data[0][9]"/></td><td><s:property value="data[1][9]"/></td><td><s:property value="data[2][9]"/></td><td><s:property value="data[3][9]"/></td></tr>
    </table>
  </body>
</html>
