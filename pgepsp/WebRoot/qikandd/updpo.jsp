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
    
    <title>My JSP 'updpo.jsp' starting page</title>
    
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
    <br>updatepo <br><a href="/pgepsp/qkdd/po">返回上一页</a>
    <s:form action="updpo" namespace="/qkdd">
    	<s:hidden name="id" value="%{pubOri.id}"/>
    	输入杂志来源：<s:textfield name="c_po_name" value="%{pubOri.po_name}"></s:textfield>
    	<s:submit value="提交"></s:submit>
    </s:form>
  </body>
</html>
