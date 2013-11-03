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
	
	<link rel="stylesheet" type="text/css" href="../css/hdjy.css">
  </head>
  
<body>
<script language="javascript" src="js/hdjy.js"></script>
<img src="images/hdjy.png" width="791px" height="49px"/>
<div class="hbsy_add_div1"><ul>
<s:form action="hdjy_add"  target="_blank" onsubmit="return check_hdjyadd(this)"  method="post" enctype="multipart/form-data">
<s:token/>
<table>
<tr><td>活动主题:</td><td><input type="text" name="a_title"  value="" id="hdjy_a_title" size="78"/></td></tr>
<tr><td valign="top">活动摘要:</td><td><textarea name="a_abstract"  cols="60" rows="5"></textarea></td></tr>

<tr><td valign="top">活动详细说明:</td><td><textarea name="a_detail"  id="hdjy_a_detail" cols="60" rows="20"></textarea></td></tr>
<tr><td>活动的分类:</td><td><input type="text"  name="a_type"  value="默认分类" id="hdjy_a_type"/></td></tr>
<tr><td><s:select list="%{str1}" label="分类选择" onchange="javascript:change_hdjy_type()" id="select_types"></s:select></td></tr>
<tr><td>活动配图:</td><td><input type="file" name="file"/></td></tr>
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
