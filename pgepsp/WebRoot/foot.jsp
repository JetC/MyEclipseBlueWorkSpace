<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'foot.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/together.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body><center>
  <table width="1024" border="0">
  <tr>
    <td height="72" style="background:url(images/bottom.gif) no-repeat; color:#FFF;font-size: 12px;" align="center">
    <div style="margin-bottom: 10px;">
    <a href="/pgepsp" style="color: #ffffff;">首页</a> |
    <a href="hbsy/hbsy_index_look.action" style="color: #ffffff;">环保术语</a> | 
    <a href="hyjy/hyjy_index_look.action" style="color: #ffffff;">会议纪要</a> |
    <a href="hdjy/hdjy_index_look.action" style="color: #ffffff;">文化活动纪要</a> |  
    <a href="/pgepsp/qkdd/findex" style="color: #ffffff;">电子报纸与期刊导读</a> | 
    <a href="/pgepsp/picture/listPicture.jsp" style="color: #ffffff;">图片影像</a> | 
    <a href="/pgepsp/message/message.jsp" style="color: #ffffff;">留言板</a></div></td>
  </tr>
</table>
   <div class="foot">
    		State Grid Corporation of China(SGCC) Copyright ©2003-2013 All rights reserved
    </div></center>
  </body>
</html>
