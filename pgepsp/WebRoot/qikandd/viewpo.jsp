<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'viewpo.jsp' starting page</title>
    
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
    这是来源总览 <br>
 <table border="3">
  <s:iterator value="pubOriList">
  		<tr>
  		<td><s:property value="po_name"/></td>
  		<td><a href="<s:url value="/qkdd/updpoform">
 				<s:param name="id" value="id"/>
					</s:url>">更新</a></td>
  		<td><a href="<s:url value="/qkdd/delpo">
 				<s:param name="id" value="id"/>
					</s:url>">删除</a></td>
  		</tr>
  </s:iterator>
  </table>
  <a href="/pgepsp/qkdd/poform">添加新来源</a>
  </body>
</html>
