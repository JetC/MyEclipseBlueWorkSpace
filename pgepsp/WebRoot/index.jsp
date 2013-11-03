<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%response.sendRedirect("/pgepsp/index");%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
var enterTime;
var xmlHttp;
function createXMLHttpRequest(){
	if(window.ActiveXObject){
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	else if(window.XMLHttpRequest){
	xmlHttp = new XMLHttpRequest();
	}
}
function postTime(){
	enterTime=new Date();
	createXMLHttpRequest();
	enterTime=enterTime.getTime();
	xmlHttp.open("POST","/pgepsp/analysis/addind",true);
	xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlHttp.send("enterTime="+enterTime);
}
</script>

  </head>
  
  <body onload="postTime()">
  <center>
  <jsp:include page="head.jsp"/>
  <h3>
  <a href="admin/admin_login_index.action">管理员登陆界面</a><br/>
  </h3>
  <jsp:include page="foot.jsp"/>
  </center>
  </body>
</html>
