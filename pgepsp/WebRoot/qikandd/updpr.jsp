<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <sx:head/>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updpr.jsp' starting page</title>
    
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
     <s:form action="updpr" namespace="/qkdd" enctype="multipart/form-data">
     	<s:fielderror/>
    	<s:hidden name="id" value="%{pubRea.id}"/>
		<s:textfield label="标题" name="pubReaUp.p_title" value="%{pubRea.p_title}"></s:textfield>
		<s:textfield label="作者" name="pubReaUp.p_author" value="%{pubRea.p_author}"></s:textfield>
		<s:select list="%{str1}" name="pubReaUp.p_type" label="文章种类" value="%{pubRea.p_type}"></s:select>
		<s:select list="%{str2}" name="pubReaUp.p_from" label="文章来源" value="%{pubRea.p_from}"></s:select>
		<s:textarea label="导读内容" name="pubReaUp.p_preread" value="%{pubRea.p_preread}"></s:textarea>
		<s:textarea label="文章摘要" name="pubReaUp.p_detail" value="%{pubRea.p_detail}"></s:textarea>
		<s:textfield label="文章链接" name="pubReaUp.p_link" value="%{pubRea.p_link}"></s:textfield>
		<sx:datetimepicker label="文章创建日期" name="pubReaUp.p_originTime" displayFormat="yyyy/MM/dd" type="date" value="%{pubRea.p_originTime}"></sx:datetimepicker>
		<s:file name="file" label="上传图片"></s:file>
		<s:select label="图片扩展名" list="{'jpg','bmp','gif'}" name="upExtension"></s:select>
		<s:submit value="提交"/>
	</s:form>
  </body>
</html>
