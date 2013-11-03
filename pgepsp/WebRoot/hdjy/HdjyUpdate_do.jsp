<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'HbsyLook.jsp' starting page</title>
<base href="<%=basePath%>">
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
  <img src="images/hdjy.png">
    <s:form action="/hdjy/hdjy_update_do" target="_blank" method="post" enctype="multipart/form-data">
    <s:hidden name="id" value="%{h.id}"></s:hidden>
	<table>
<tr><td>活动主题:</td><td><input type="text" name="a_title"  value="" id="hdjy_a_name" size="78"/></td></tr>
<tr><td valign="top">活动摘要:</td><td><textarea name="a_abstract"  cols="60" rows="5"></textarea></td></tr>
<tr><td valign="top">活动详细说明:</td><td><textarea name="a_detail"  id="hdjy_a_detail"  cols="60" rows="20"></textarea></td></tr>
<tr><td>活动的分类:</td><td><input type="text"  name="a_type"  value="" id="hdjy_e_type"/></td></tr>
<tr><td>活动配图:</td><td><input type="file" name="file"/></td></tr>
<tr><td align="left"><s:select list="{'jpg','bmp','gif','png'}"  name="p_extension" label="图片类型     "/></td></tr>
<tr><td>图片主题:</td><td><input type="text"  name="p_title"   value=""  size="78"></td></tr>
<tr><td>图片描述:</td><td><input type="text"  name="p_describe"  value=""  size="78"></td></tr>
<tr><td>图片涉及地点:</td><td><input type="text"  name="p_place"   value=""  size="78"></td></tr>
<tr><td>图片分类:</td><td><input type="text"  name="p_type"   value=""  size="78"></td></tr>
<tr><td>图片涉及人物:</td><td><input type="text"  name="Person"  value=""  size="78"></td></tr>
<tr><td><s:submit value="更新" /></td></tr>
</table>
		</s:form>
  </body>
</html>
