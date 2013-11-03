<%@ page import="com.gwhb.model.*"%>
<%@ page import="java.util.*"%>
<%@ page language="java"
	import="java.util.*,org.apache.struts2.ServletActionContext"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	Integer pageNum = (Integer) request.getAttribute("pageNum");
	String keyword = (String) request.getAttribute("keyword");
	Integer count = (Integer) request.getAttribute("count");
	if (pageNum == null || count == null) {
		response.sendRedirect("messageListAction.action?pageNum=0");
		return;
	}
	if (keyword == null) {
		keyword = "";
	}
	if (pageNum < 0) {
		pageNum = 0;
	} else if (pageNum > (count - 1) / 10) {
		pageNum = (count - 1) / 10;
	}
	List<Message> messages = (List<Message>) request
			.getAttribute("messages");
%>
<%
	HttpServletRequest _request = ServletActionContext.getRequest();
	String isFirstPage = (String) _request.getAttribute("isFirst");
	int a = 3;
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

	<body>
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
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;浏览量最多:
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="images/hbsy_head.png" width="20px" height="20px" />
						<a
							href="<s:url value="hbsy_look.action">
              		   <s:param name="id" value="numRankId[0]"/>
           			   </s:url>"><s:property
								value="numRank[0]" /> </a>
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="images/hbsy_head.png" width="20px" height="20px" />
						<a
							href="<s:url value="hbsy_look.action">
              		   <s:param name="id" value="numRankId[1]"/>
           			   </s:url>"><s:property
								value="numRank[1]" /> </a>
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="images/hbsy_head.png" width="20px" height="20px" />
						<a
							href="<s:url value="hbsy_look.action">
              		   <s:param name="id" value="numRankId[2]"/>
           			   </s:url>"><s:property
								value="numRank[2]" /> </a>
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="images/hbsy_head.png" width="20px" height="20px" />
						<a
							href="<s:url value="hbsy_look.action">
              		   <s:param name="id" value="numRankId[3]"/>
           			   </s:url>"><s:property
								value="numRank[3]" /> </a>
					</td>


					<td width="800" rowspan="3" valign="top">
						<!-- 右下区域800px         -->

						<div id="hbsy">
							<table class="hbsy_table1" width="800px">
								<tr height="49px">
									<td colspan="4" valign="middle"
										style="background: url(images/hbsy.png) no-repeat;"
										align="right">
										您现在的位置:首页 &gt; 留言
									</td>
								</tr>
								<tr>
									<td colspan="4" valign="middle" align="right">
										<div id="hbsy_search">
											<ul>
												<li>
													<form action="message/messageListAction.action"
														method="get">
														<input type="hidden" name="pageNum" value="0" />
														请输入检索内容:
														<input type="text" name="keyword" />
														<input type="submit" value="检索" />
													</form>
												</li>
											</ul>
										</div>
									</td>
								</tr>
								<tr height="18px">
									<td></td>
									<td style="border-bottom: 1px dotted #00FF00;">
										内容
									</td>
									<td align="center" style="border-bottom: 1px dotted #00FF00;">
										时间
									</td>
									<td align="center" style="border-bottom: 1px dotted #00FF00;">
										有无回复
									</td>
								</tr>

								<%
									for (Message message : messages) {
								%>
								<tr height="18px">
									<td width="50px"></td>
									<td width="500px" style="border-bottom: 1px dotted #00FF00;">
										<img src="images/hbsy_head.png" width="20px" height="20px">
										<a
											href="message/messageShowAction.action?id=<%=message.getId()%>">内容：<%=message.getContent()%>
										</a>
									</td>
									<td width="100px" align="center"
										style="border-bottom: 1px dotted #00FF00;">
										时间：<%=message.getTime()%>
									</td>
									<td width="150px" align="center"
										style="border-bottom: 1px dotted #00FF00;">
										<%
											if (message.getReply() == null) {
													out.println("暂无回复");
												} else {
													out.println("已有回复");
										%>
									</td>
								</tr>
								<tr height="18px">
									<td width="50px"></td>
									<td width="500px" style="border-bottom: 1px dotted #00FF00;">
										<img src="images/hbsy_head.png" width="20px" height="20px">
										回复内容：<%=message.getReply()%>
									</td>
									<td width="100px" align="center"
										style="border-bottom: 1px dotted #00FF00;">
										回复时间：<%=message.getReplytime()%>
									</td>
									<td width="150px" align="center"
										style="border-bottom: 1px dotted #00FF00;">
										回复人：<%=message.getReplyer()%>
										<%
											}
										%>
									</td>
								</tr>
								<%
									}
									out
											.println("<a href=\"message/messageListAction.action?pageNum=0&keyword="
													+ keyword + "&count=" + count + "\">首页</a>");
									if (pageNum > 0) {
										out
												.println("<a href=\"message/messageListAction.action?pageNum="
														+ (pageNum - 1)
														+ "&keyword="
														+ keyword
														+ "&count=" + count + "\">上一页</a>");
									}
									if (pageNum < (count - 1) / 10) {
										out
												.println("<a href=\"message/messageListAction.action?pageNum="
														+ (pageNum + 1)
														+ "&keyword="
														+ keyword
														+ "&count=" + count + "\">下一页</a>");
									}
									out.println("<a href=\"message/messageListAction.action?pageNum="
											+ (count - 1) / 10 + "&keyword=" + keyword + "&count="
											+ count + "\">尾页</a>");
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
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="images/hbsy_head.png" width="20px" height="20px" />
						测试数据1
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="images/hbsy_head.png" width="20px" height="20px" />
						测试数据2
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="images/hbsy_head.png" width="20px" height="20px" />
						测试数据3
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="images/hbsy_head.png" width="20px" height="20px" />
						测试数据4
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="images/hbsy_head.png" width="20px" height="20px" />
						测试数据5
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="images/hbsy_head.png" width="20px" height="20px" />
						测试数据6
						<br />
					</td>
				</tr>
			</table>
			<jsp:include page="../foot.jsp" />
		</center>
	</body>
</html>
