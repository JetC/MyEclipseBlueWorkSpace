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

		<title>My JSP 'head.jsp' starting page</title>

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
		<center>
			<table width="1024" border="0">
				<tr>
					<td width="287" rowspan="3">
						<img src="images/logo.gif" width="287" height="90">
					</td>
					<td width="289" height="61" rowspan="2">
						&nbsp;
					</td>
					<td width="434" align="right">
						<img src="images/gobackhome.png" width="16" height="14">
						返回首页
						<img src="images/fav.png" width="16" height="14">
						加入收藏
						<img src="images/contact.png" width="16" height="14">
						联系我们
					</td>
				</tr>
				<tr>
					<td height="38">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td colspan="2"
						style="background: url(images/menu.png) no-repeat; color: #FFF; font-size: 14px"
						valign="middle">
						<table width="726" height="33" border="0">
							<tr align="center" style="color: #FFF; font-size: 12px">
								<td width="60">
									首页
								</td>
								<td width="84">
									环保术语
								</td>
								<td width="88">
									会议纪要
								</td>
								<td width="115">
									文化活动纪要
								</td>
								<td width="158">
									电子报纸与期刊导读
								</td>
								<td width="96">
									图片影像
								</td>
								<td width="95">
									留言板
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<img src="images/banner.png" width="1024" height="242">



		</center>
	</body>
</html>
