<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showchart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
body{
	display:block;
	text-align:center;
	margin:0 0 0 0;
}
#container{
	margin:0 auto 0 auto;
}
#title{
	margin:0 auto 0 auto;
	height:28px;
	color:gray;
	font-family: 方正喵呜体;
	font-size:28px;
	font-weight: bolder;
}
#nav{
	margin:10px 0 0 0;
	height:14px;
	background-color: #0066ff;
	padding: 8px 0px 8px 0px;
}
#nav ul{
	margin:0 auto 0 auto;
	height:14;
	width:528px;
	padding:0 0 0 0;
}
#nav ul li{
	float:left;
	list-style-type: none;
	margin-right:30px;
	margin-bottom:0;
	margin-left:0;
	margin-top:0;
	padding:0 0 0 0;
	font-family:幼圆;
	font-weight: bold;
}
#chart{
	margin:40px auto 0 auto;
	height:600px;
	padding:0 0 0 0;
}
li a{
	display:block;
	font-size: 14px;
	color: #ffffff;
	text-decoration: none;
	margin: 0 0 0 0;
	padding:0 0 0 0;
}
.framestyle{
	display:block;
	margin:0 auto;
	width:650;
	height:550;
}
</style>
<script type="text/javascript" src="/js/jquery-1.7.1.js"></script>
<script type="text/javascript">
</script>
 </head>
  
  <body>
  <div id="container">
  
  <div id="title">统计</div>
  <div id="nav">
  

  <ul>
  <li><a href="/pgepsp/analysis/tlcv" target="framecontent">浏览量统计(柱形图)</a></li>
  <li><a href="/pgepsp/analysis/tlv" target="framecontent">今日流量统计(折线图)</a></li>
  <li><a href="/pgepsp/analysis/tltv" target="framecontent">停留时间统计(柱形图)</a></li>
  </ul>
  
  </div>
  
  <div id="chart">
  	 <iframe id="framestyle" name="framecontent" width="600" height="1200" scrolling="no"
  	 frameborder="0" src=""></iframe>
  </div>
  
  
  </div>
  </body>
</html>
