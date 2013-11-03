<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'viewprdetail.jsp' starting page</title>
    
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
  <a href="<s:url value="/qkdd/updprform">
  			<s:param name="id" value="pubRea.id"/>
  		</s:url>">编辑</a>
  <table border="1">
  <tr><td colspan="6" align="center"><span><s:property value="pubRea.p_title"/></span></td></tr>
  <tr><td>来自:</td><td><s:property value="pubRea.p_from"/>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  	<td>文章发表时间:</td><td><s:property value="time"/>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  	<td>点击量：</td><td><s:property value="pubRea.p_count"/></td>
  	</tr>
  <tr><td>作者:</td><td colspan="5"><s:property value="pubRea.p_author"/></td></tr>
  <tr><td>导读:</td><td colspan="5"><s:property value="viewPreread" escapeHtml="false"/></td></tr>
  <tr><td colspan="6"><s:property value="viewDetail" escapeHtml="false"/></td></tr>
  <tr><td colspan="6"><a href="<s:property value="pubRea.p_link" />">点击查看完整原文</a></td></tr>
  </table>
  </body>
</html>
