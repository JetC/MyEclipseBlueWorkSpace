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
	
	<link rel="" type="text/css" href="css/hbsy.css">
  </head>
  
  <body>
    <div id="hbsy">
<table class="hbsy_table1" >
<tr height="49px"><td colspan="4" valign="middle" style="background:url(images/hbsy.png) no-repeat;  " align="right">您现在的位置:首页 &gt; 环保术语</td></tr>

<tr><td colspan="4">
<table>
<tr><td><s:form><s:textfield name="e_name"></s:textfield></s:form></td></tr>
</table>
</td></tr>

<tr><td colspan="4"><h1>环保术语检索结果:共有${num}条结果</h1></td></tr>
<tr height="18px"><td></td><td style="border-bottom: 1px dotted #00FF00;">环保术语名称</td><td align="center" style="border-bottom: 1px dotted #00FF00;">浏览量</td><td align="center" style="border-bottom: 1px dotted #00FF00;">创建时间</td>
</tr>
<s:iterator value="allList">
<tr height="18px" ><td width="50px" ></td>
					   <td width="500px" style="border-bottom: 1px dotted #00FF00;"><img src="images/hbsy_head.png" width="20px" height="20px"><a href="<s:url value="hbsy_look.action">
              		   <s:param name="id" value="id"/>
           			   </s:url>"><s:property value="e_name"/></a>
           			
           			   </td>
           			   <td  width="100px" align="center" style="border-bottom: 1px dotted #00FF00;"><a href="<s:url value="hbsy_look.action">
              		   <s:param name="id" value="id"/>
           			   </s:url>"><s:property value="e_count"/></a></td>
           			   <td width="150px" align="center" style="border-bottom: 1px dotted #00FF00;"><a href="<s:url value="hbsy_look.action">
              		   <s:param name="id" value="id"/>
           			   </s:url>">[<s:property value="e_addtime"/>]</a></td></tr>
</s:iterator>

<tr><td></td><td colspan="3">
<table class="hbsy_table2">
<tr><td>共${num}条&nbsp;每页9条&nbsp;页次:<s:property value="pager.currentPage" />/<s:property value="pager.maxPages" /></td>
<td width="30px"></td>
<td bgcolor="#DCD9D4" ><a href="<s:url value="hbsy_index_look"><s:param name="method" value="%{'first'}"/><s:param name="pager.currentPage" value="pager.currentPage"/></s:url>">首页</a></td>
<td bgcolor="#DCD9D4"><a href="<s:url value="hbsy_index_look"><s:param name="method" value="%{'back'}"/><s:param name="pager.currentPage" value="pager.currentPage"/></s:url>">上一页</a></td>
<td bgcolor="#EBEBEA">&nbsp;<s:property value="pager.currentPage" />&nbsp;</td>
<td bgcolor="DCD9D4"><a href="<s:url value="hbsy_index_look"><s:param name="method" value="%{'next'}"/><s:param name="pager.currentPage" value="pager.currentPage"/></s:url>">下一页</a></td>
<td align="left"><div class="hbsy_div1">
						<ul><li><form action="hbsy_index_look" method="post">
						<s:hidden name="method" value="%{'jump'}" />
						跳转:<input type="text" name="pager.currentPage" style="width:25px;" /><input type="submit" value="Go"/></form></li></ul></div>
</td>
<td width="18px"></td>
<td bgcolor="#DCD9D4"><a href="<s:url value="hbsy_index_look"><s:param name="method" value="%{'last'}"/><s:param name="pager.currentPage" value="pager.currentPage"/></s:url>">尾页</a></td>
</tr>
</table></td></tr>
</table>
</div>   
  </body>
</html>
