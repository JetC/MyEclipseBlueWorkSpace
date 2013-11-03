<%@ page language="java" import="java.util.*,org.apache.struts2.ServletActionContext" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
HttpServletRequest _request = ServletActionContext.getRequest();
String a=(String)_request.getAttribute("isSuper");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'info.jsp' starting page</title>
    
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
  <table><tr><td valign="top" width="400px">
    <h2>欢迎<s:property value="a_username"/>进入后台系统管理</h2>
    <h4>您的登陆时间为:${nowTime};<br/>
    您的登陆IP为:${ip};</h4></td>
    <td valign="top"><h2> 快捷操作</h2>
    <img src="admin/images/a.png"/><a href="hbsy/hbsy_index_add.action" target="down_frame">增加环保术语</a>
    <img src="admin/images/b.png"/><a href="hdjy/hdjy_index_add.action" target="down_frame">增加活动纪要</a>
    <img src="admin/images/b.png"/><a href="hyjy/hyjy_index_add.action" target="down_frame">增加会议纪要</a>
    <br/>
    <img src="admin/images/c.png"/><a href="qkdd/prform" target="down_frame">增加期刊导读</a>
    <img src="admin/images/d.png"/>增加图片影像
    </td></tr>
    
    <tr>
    <td width="400px" valign="top">
    <h2>管理员信息&nbsp;&gt;&gt;<a href="admin/admin_logout" target="_top">退出管理系统</a></h2>
    <h4><a href="admin/admin_info" target="down_frame">用户信息与权限浏览</a>

    <%if(a.equals("yes")){
    out.print("<br/><a href=\"admin/admin_add\" target=\"down_frame\">添加管理员</a>"+"&nbsp;删除管理员");
    } %>
    </h4>
    </td>
    
    <td valign="top">
    
    </td>
    </tr>
    </table>
   
  </body>
</html>
