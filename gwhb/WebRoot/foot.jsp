<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

	<body>
		<center>
			<table width="1024" border="0">
				<tr>
					<td height="72"
						style="background: url(images/bottom.png) no-repeat; color: #FFF"
						align="center">
						首页 | 环保术语 | 会议纪要 | 电子报纸与期刊导读 | 图片影像 | 留言板
					</td>
				</tr>
			</table>
			<div class="foot">
				<pre>State Grid Corporation of China(SGCC) Copyright ©2003-2013 All rights reserved</pre>
			</div>
		</center>
	</body>
</html>
