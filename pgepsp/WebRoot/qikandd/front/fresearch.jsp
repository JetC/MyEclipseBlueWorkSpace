<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>期刊搜索</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/qkdd.css" rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript">
function toPage(){
var m=document.getElementById("gotopage").value;
	if(!isNaN(m)&&m>0&&m<=<s:property value="pager.maxPages"/>){
		document.getElementById("gotoform").submit();
	}
}
</script>

  </head>
  
<body>
	<center>
		<jsp:include page="/head.jsp" />
		<table width="1024" border="0">
			<tr>
				<td width="214" height="191px"
					style="background:url(images/qkdd_small.gif) no-repeat"
					valign="top">
				<br />
				<br />
				<br/>

					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img
					src="images/hbsy_head.png" width="20px" height="20px" />
					<a href="<s:url value="/qkdd/fclass"><s:param name="key" value="%{'国际环保'}"/></s:url>">国际环保</a> 
					<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img
					src="images/hbsy_head.png" width="20px" height="20px" />
					<a href="<s:url value="/qkdd/fclass"><s:param name="key" value="%{'节能环保'}"/></s:url>">节能环保</a>
					<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img
					src="images/hbsy_head.png" width="20px" height="20px" />
					<a href="<s:url value="/qkdd/fclass"><s:param name="key" value="%{'工程'}"/></s:url>">工程</a>
					<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img
					src="images/hbsy_head.png" width="20px" height="20px" />
					<a href="<s:url value="/qkdd/fclass"><s:param name="key" value="%{'热点'}"/></s:url>">热点</a>
					</td>


				<td width="800px" rowspan="3" valign="top" align="center">
					<!-- 右下区域800px         -->

					<div id="hbsy">
						<table class="hbsy_table1" width="750px" border="0">
							<tr height="49px">
								<td colspan="4" valign="middle"
									style="background:url(images/qkdd.gif) no-repeat;  "
									align="right">					
					<font style="font-size: 12px;">您现在的位置:</font>
					<a style="font-size: 12px;color: #0099ee" href="/pgepsp">首页</a>
					<font style="font-size: 12px;font-weight: bold;color: #aaaaaa">＞</font>
					 <a style="font-size: 12px;color: #0099ee" href="/pgepsp/qkdd/findex">电子报纸与期刊导读</a>
					 </td>
							</tr>
							<tr>
								<td colspan="4" valign="middle" align="right" height="23px">
									<div id="hbsy_search">
										<ul>
											<li><form action="/pgepsp/qkdd/fresearch" method="post" name="research">
 													<span style="font-size:14px;">请输入检索内容：</span><input type="text" name="key"/>
 													<input type="submit" value="检索"/>
												</form>
											</li>
										</ul>
									</div>
								</td>
							</tr>
							<tr><td colspan="5"><hr color="#006600"/></td></tr>
							 <s:iterator value="pubReaList">
								<tr>
								<td><span style="color:006600;font-weight:bold;font-size:14px;"><s:property value="p_title"/></span></td>
								<td align="right" colspan="3"><span style="color:006600;font-weight:bold;font-size:14px;">[<s:property value="p_from"/>][<s:property value="p_type"/>]
								</span>
								<!-- 时间：<s:property value="p_originTime"/> --></td>
								</tr>
								<tr>
								<td colspan="4" style="border-bottom: 1px dotted #00FF00; " valign="top">
								<span style="font-size:13px;">
								文章导读:
								<a href="<s:url value="/qkdd/fdetail">
				  						<s:param name="id" value="id"/>
 								 		</s:url>"><s:property value="p_preread"/></a>
 								 		</span></td>
								</tr>
							</s:iterator>
							<tr>
								<td colspan="4" align="right">
									<table class="hbsy_table2">
										<tr>
											<td>共<s:property value="pager.maxPages"/>页&nbsp;每页9条&nbsp;页次:<s:property value="pager.currentPage"/>/<s:property value="pager.maxPages" />
											</td>
											<td width="30px"></td>
											<td bgcolor="#DCD9D4"><a href="<s:url value="%{researchType}"><s:param name="key" value="%{key}"/><s:param name="method" value="%{'first'}"/><s:param name="pager.currentPage" value="pager.currentPage"/></s:url>">首页</a>
											</td>
											<td bgcolor="#DCD9D4"><a href="<s:url value="%{researchType}"><s:param name="key" value="%{key}"/><s:param name="method" value="%{'back'}"/><s:param name="pager.currentPage" value="pager.currentPage"/></s:url>">上一页</a>
											</td>
											<td bgcolor="#EBEBEA">&nbsp;<s:property
													value="pager.currentPage" />&nbsp;</td>
											<td bgcolor="DCD9D4"><a href="<s:url value="%{researchType}"><s:param name="key" value="%{key}"/><s:param name="method" value="%{'next'}"/><s:param name="pager.currentPage" value="pager.currentPage"/></s:url>">下一页</a>
											</td>
											<td align="left"><div class="hbsy_div1">
													<ul>
														<li>	
														<form action="<s:url value="%{researchType}"></s:url>" method="post" id="gotoform">
															<s:hidden name="method" value="%{'jump'}"/>
															<s:hidden name="key" value="%{key}"/>
															<input type="text" name="pager.currentPage" style="width:20;" value="" id="gotopage"/>
															<input type="button" value="go" onclick="toPage()"/>
														</form>
														</li>
													</ul>
												</div></td>
											<td width="24px"></td>
											<td bgcolor="#DCD9D4"><a href="<s:url value="%{researchType}"><s:param name="key" value="%{key}"/><s:param name="method" value="%{'last'}"/><s:param name="pager.currentPage" value="pager.currentPage"/></s:url>">尾页</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</div></td>
			</tr>
</table>
			<jsp:include page="/foot.jsp"/>
	</center>
</body>
</html>