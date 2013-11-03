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
    
    <title>My JSP 'search.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="../css/hdjy.css">
	<link rel="stylesheet" type="text/css" href="../css/together.css">
  </head>
  
  <body><center>
  <jsp:include page="../head.jsp"/>
    <div id="hbsy">
<table class="hbsy_table1" >
<tr height="49px"><td colspan="4" valign="middle" style="background:url(hdjy/images/hdjy.png) no-repeat;  " align="right">您现在的位置:首页 &gt; 环保术语</td></tr>

<tr><td colspan="4">
<table>
<tr><td align="right" width="750px" valign="middle"><div id="middle_search"><ul><li><form action="hdjy/hdjy_search" method="post">请输入检索内容:<input type="text" name="keyword"/>
<select name="word" >
 <option selected="selected" value="a_title">活动纪要主题</option>
 <option value="a_type">活动纪要类型</option>
 <option value="other">活动纪要详细</option>
</select>
<input type="submit" value="检索"/></form></li></ul></div></td></tr>
</table>
</td></tr>

<tr><td colspan="4"><h1>文化活动纪要检索结果:共有${num}条结果</h1></td></tr>
<tr height="18px"><td></td><td style="border-bottom: 1px dotted #00FF00;">文化活动纪要主题</td><td align="center" style="border-bottom: 1px dotted #00FF00;">浏览量</td><td align="center" style="border-bottom: 1px dotted #00FF00;">创建时间</td>
</tr>
<s:iterator value="allList">
<tr height="18px" ><td width="50px" ></td>
					   <td width="500px" style="border-bottom: 1px dotted #00FF00;"><img src="hdjy/images/hdjy_head.png" width="20px" height="20px"><a href="<s:url value="/hdjy/hdjy_look.action">
              		   <s:param name="id" value="id"/>
           			   </s:url>"><s:property value="a_title"/></a>
           			
           			   </td>
           			   <td  width="100px" align="center" style="border-bottom: 1px dotted #00FF00;"><a href="<s:url value="hdjy/hdjy_look.action">
              		   <s:param name="id" value="id"/>
           			   </s:url>"><s:property value="a_count"/></a></td>
           			   <td width="150px" align="center" style="border-bottom: 1px dotted #00FF00;"><a href="<s:url value="hdjy/hdjy_look.action">
              		   <s:param name="id" value="id"/>
           			   </s:url>">[<s:property value="a_addtime"/>]</a></td></tr>
</s:iterator>

<tr><td></td><td colspan="3">
<table class="hbsy_table2">
<tr><td>共${num}条&nbsp;每页9条&nbsp;页次:<s:property value="pager.currentPage" />/<s:property value="pager.maxPages" /></td>
<td width="30px"></td>
<td bgcolor="#DCD9D4" ><a href="<s:url value="hdjy/hdjy_search"><s:param name="method" value="%{'first'}"/><s:param name="pager.currentPage" value="pager.currentPage"/><s:param name="word" value="word"/><s:param name="keyword" value="keyword"/></s:url>">首页</a></td>
<td bgcolor="#DCD9D4"><a href="<s:url value="hdjy/hdjy_search"><s:param name="method" value="%{'back'}"/><s:param name="pager.currentPage" value="pager.currentPage"/><s:param name="word" value="word"/><s:param name="keyword" value="keyword"/></s:url>">上一页</a></td>
<td bgcolor="#EBEBEA">&nbsp;<s:property value="pager.currentPage" />&nbsp;</td>
<td bgcolor="DCD9D4"><a href="<s:url value="hdjy/hbsy_search"><s:param name="method" value="%{'next'}"/><s:param name="pager.currentPage" value="pager.currentPage"/><s:param name="word" value="word"/><s:param name="keyword" value="keyword"/></s:url>">下一页</a></td>
<td align="left"><div class="bottom_table">
						<ul><li><form action="hdjy/hdjy_search" method="post">
						<s:hidden name="method" value="%{'jump'}" />
						<s:hidden name="word" value="word"/>
						<s:hidden name="keyword" value="keyword"/>
						跳转:<input type="text" name="pager.currentPage" style="width:25px;" /><input type="submit" value="Go"/></form></li></ul></div>
</td>
<td width="18px"></td>
<td bgcolor="#DCD9D4"><a href="<s:url value="hdjy/hdjy_search"><s:param name="method" value="%{'last'}"/><s:param name="pager.currentPage" value="pager.currentPage"/><s:param name="word" value="word"/><s:param name="keyword" value="keyword"/></s:url>">尾页</a></td>
</tr>
</table></td></tr>
</table>
</div>   <jsp:include page="../foot.jsp"/></center>
  </body>
</html>
