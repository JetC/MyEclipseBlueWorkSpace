<%@ page language="java" contentType="text/html;charset=utf-8" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx"  uri="/struts-dojo-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <sx:head/>
    <base href="<%=basePath%>">
    
    <title>My JSP 'HbsyAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link rel="stylesheet" type="text/css" href="css/hbsy.css">
  </head>
  
<body>
<script language="javascript" src="/js/hbsy.js"></script>
<img src="images/hbsy.png"/>
<div class="hbsy_add_div1"><ul>
<%request.setCharacterEncoding("utf-8"); %>

<s:form action="hbsy_add"  target="_blank" onsubmit="return check_hbsyadd(this)"  method="post" enctype="multipart/form-data">
<s:token/>
<table width="799px">
<tr><td>术语名称:</td><td><input type="text" name="e_name"  value="" id="hbsy_e_name" size="78"/></td></tr>
<tr><td valign="top">术语摘要:</td><td><textarea name="e_abstract"  cols="60" rows="5"></textarea></td></tr>

<tr><td valign="top">术语详细说明:</td><td><textarea name="e_detail"  id="hbsy_e_detail"  cols="60" rows="20"></textarea></td></tr>
<tr><td>术语的分类:</td><td><input type="text"  name="e_type"  value="默认分类" id="hbsy_e_type" size="10"/></td></tr>
<tr><td><s:select list="%{str1}" label="分类选择" onchange="javascript:change_hbsy_type()" id="select_types"></s:select></td></tr>
<tr><td>术语配图:</td><td><input type="file" name="file"/></td></tr>
<tr><td align="left"><s:select list="{'jpg','bmp','gif','png'}"  name="p_extension" label="图片类型     "/></td></tr>
<tr><td>图片主题:</td><td><input type="text"  name="p_title"   value="" size="78"></td></tr>
<tr><td>图片描述:</td><td><input type="text"  name="p_describe"  value="" size="78"></td></tr>
<tr><td>图片涉及地点:</td><td><input type="text"  name="p_place"   value="" size="78"></td></tr>
<tr><td>图片分类:</td><td><input type="text"  name="p_type"   value="" size="78"></td></tr>
<tr><td>图片涉及人物:</td><td><input type="text"  name="Person"  value="" size="78"></td></tr>
<tr><td></td><td align="left"><input type="submit" value="提交" /></td></tr>
</table></s:form></ul></div>
  </body>
</html>
