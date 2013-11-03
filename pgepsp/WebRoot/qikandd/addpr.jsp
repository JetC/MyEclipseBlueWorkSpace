<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<sx:head extraLocales="zh"/>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addpr.jsp' starting page</title>
    
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
    addpr <br>
<!-- 文章的添加和一张图片或无图 -->
	<s:form namespace="/qkdd" action="addpr" method="post" enctype="multipart/form-data">
		<s:fielderror/>
		<s:textfield label="标题" name="pubRea.p_title"></s:textfield>
		<s:textfield label="作者" name="pubRea.p_author"></s:textfield>
		<s:select list="%{str1}" name="pubRea.p_type" label="文章种类"></s:select>
		<s:select list="%{str2}" name="pubRea.p_from" label="文章来源"></s:select>
		<s:textarea label="导读内容" name="pubRea.p_preread"></s:textarea>
		<s:textarea label="文章摘要" name="pubRea.p_detail"></s:textarea>
		<s:textfield label="文章链接" name="pubRea.p_link"></s:textfield>
		<sx:datetimepicker label="文章创建日期" name="pubRea.p_originTime" displayFormat="yyyy/MM/dd" type="date" language="zh"></sx:datetimepicker>
		<s:file name="file" label="上传图片"></s:file>
		<s:select label="图片扩展名" list="{'jpg','bmp','gif'}" name="pic.p_extension"></s:select>
		<s:submit value="提交"/>
	</s:form>

  </body>
</html>
