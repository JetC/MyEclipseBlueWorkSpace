<%@ page import="com.gwhb.model.*"%>
<%@ page language="java" import="java.util.*,javax.servlet.http.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Message message = (Message) request.getAttribute("message");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>显示留言</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="css/hbsy.css" rel="stylesheet" type="text/css" />
	</head>

	<body onload="getEnterTime()" onunload="getLookingTime()">

		<script language="javascript" src="js/hbsy.js"></script>
		<center>
			<jsp:include page="../head.jsp" />
			<table width="1024" border="0">
				<tr>
					<td width="214" height="191"
						style="background: url(images/hbsy_small.png) no-repeat"
						valign="top">
						<br />
						<br />
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;浏览量最多:
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="images/hbsy_head.png" width="20px" height="20px" />
						<a
							href="<s:url value="hbsy_look.action">
              		   <s:param name="id" value="numRankId[0]"/>
           			   </s:url>"><s:property
								value="numRank[0]" /> </a>
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="images/hbsy_head.png" width="20px" height="20px" />
						<a
							href="<s:url value="hbsy_look.action">
              		   <s:param name="id" value="numRankId[1]"/>
           			   </s:url>"><s:property
								value="numRank[1]" /> </a>
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="images/hbsy_head.png" width="20px" height="20px" />
						<a
							href="<s:url value="hbsy_look.action">
              		   <s:param name="id" value="numRankId[2]"/>
           			   </s:url>"><s:property
								value="numRank[2]" /> </a>
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="images/hbsy_head.png" width="20px" height="20px" />
						<a
							href="<s:url value="hbsy_look.action">
              		   <s:param name="id" value="numRankId[3]"/>
           			   </s:url>"><s:property
								value="numRank[3]" /> </a>
					</td>


					<td width="800" rowspan="3" valign="top" align="center">
						<!-- 右下区域800px         -->
						<div style="margin-bottom: 0;">
							<table width="750px">
								<tr height="49px">
									<td valign="middle"
										style="background: url(images/hbsy.png) no-repeat"
										align="right">
										您现在的位置:首页&gt; 留言
									</td>
								</tr>
								<tr>
									<td bgcolor="#F7F7F7" align="center">
										内容：<%=message.getContent()%>
										&nbsp;时间：<%=message.getTime()%>
									</td>
								</tr>
								<%
									if (message.getReply() != null) {
								%>
								<tr>
									<td width="750" valign="top">
										回复内容：<%=message.getReply()%>
										&nbsp;回复时间：<%=message.getReplytime()%>
										&nbsp;回复人：<%=message.getReplyer()%>
									</td>
								</tr>
								<%
									} else {
								%>
								<tr>
									<td width="750" valign="top">
										<form action="message/messageUpdateAction.action" method="post">
											<input type="hidden" name="id" value="<%=message.getId()%>">
											<p>
												回复：
												<input type="text" name="reply">
											</p>
											<p>
												<input type="submit" value="提交">
											</p>
										</form>
									</td>
								</tr>
								<%
									}
								%>

							</table>
						</div>


					</td>
				</tr>
				<tr>
					<td height="253"
						style="background: url(images/zyhyjy.gif) no-repeat" valign="top">
						<br />
						<br />
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="images/hbsy_head.png" width="20px" height="20px" />
						测试数据1
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="images/hbsy_head.png" width="20px" height="20px" />
						测试数据2
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="images/hbsy_head.png" width="20px" height="20px" />
						测试数据3
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="images/hbsy_head.png" width="20px" height="20px" />
						测试数据4
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="images/hbsy_head.png" width="20px" height="20px" />
						测试数据5
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="images/hbsy_head.png" width="20px" height="20px" />
						测试数据6
						<br />


					</td>
				</tr>
				<tr>
					<td height="21">
						&nbsp;
					</td>
				</tr>
			</table>
			<jsp:include page="../foot.jsp" />
		</center>
	</body>
</html>
