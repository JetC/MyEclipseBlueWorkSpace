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
    
    <title>My JSP 'HbsyManage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <style type="text/css">
  .page ul li {
	float: left;
	margin-right: 20px;
}

.page {
	float: center;
}
  
  
  </style>
  </head>

  <body>
  <img src="hbsy/images/hbsy.png">
   <table border="0">
  <tr><td>序号</td><td>术语名称</td><td>浏览量</td><td>术语类型</td><td>操作</td><td>操作</td></tr>
	<s:iterator value="allList">
  	<tr><td><a href="<s:url value="/hbsy/hbsy_look.action">
              		   <s:param name="id" value="id"/>
           			   </s:url>" target="_blank"><s:property value="id"/></a></td>
    <td><a href="<s:url value="/hbsy/hbsy_look.action">
              		   <s:param name="id" value="id"/>
           			   </s:url>" target="_blank"><s:property value="e_name"/></a></td>
    <td><s:property value="e_count"/></td>
    <td><s:property value="e_type"/></td>  
    <td><a href="<s:url value="/hbsy/hbsy_update.action">
              		   <s:param name="id" value="id"/>
           			   </s:url>" target="down_frame">
    更新</a></td>
    <td><a href="<s:url value="/hbsy/hbsy_delete.action">
              		   <s:param name="id" value="id"/>
           			   </s:url>">
    删除</a></td></tr></s:iterator>
<tr><td colspan="6">		
<div style="display: inline;" class="page">
			<ul>
				<li><a
					href="<s:url value="/hbsy/hbsy_index_manage"><s:param name="method" value="%{'first'}"/><s:param name="pager.currentPage" value="pager.currentPage"/></s:url>">首页</a>
				</li>
				<li><a
					href="<s:url value="/hbsy/hbsy_index_manage"><s:param name="method" value="%{'back'}"/><s:param name="pager.currentPage" value="pager.currentPage"/></s:url>">上一页</a>
				</li>
				<li><a
					href="<s:url value="/hbsy/hbsy_index_manage"><s:param name="method" value="%{'next'}"/><s:param name="pager.currentPage" value="pager.currentPage"/></s:url>">下一页</a>
				</li>
				<li><a
					href="<s:url value="/hbsy/hbsy_index_manage"><s:param name="method" value="%{'last'}"/><s:param name="pager.currentPage" value="pager.currentPage"/></s:url>">尾页</a>
				</li>
				<li>共<s:property value="pager.maxPages" />页</li>
				<li>当前是第<s:property value="pager.currentPage" />页</li>
				<li><form action="hbsy/hbsy_index_manage" method="post">
						<s:hidden name="method" value="%{'jump'}" />
						<table><tr>
						<td><input type="text" name="pager.currentPage" style="width=20;"
							value="" /></td><td><input type="submit" value="Go" /></td></tr></table>
					</form>
				</li>
			</ul>
		</div></td></tr></table>
  </body>
</html>
