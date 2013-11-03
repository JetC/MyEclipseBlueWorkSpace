<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'viewpc.jsp' starting page</title>
    
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
    这是分类总览 <br>
  <table border="3">
  <s:iterator value="pubClaList">
  		<tr>
  		<td><s:property value="pc_name"/></td>
  		<td><a href="<s:url value="/qkdd/updpcform">
 				<s:param name="id" value="id"/>
					</s:url>">更新</a></td>
  		<td><a href="<s:url value="/qkdd/delpc">
 				<s:param name="id" value="id"/>
					</s:url>">删除</a></td>
		</tr>
  </s:iterator>
  </table>
  <a href="/pgepsp/qkdd/pcform">添加新类别</a>
  </body>
</html>
