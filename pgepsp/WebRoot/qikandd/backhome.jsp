<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'viewprlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
<!--
.research{
	display:block;
	width:600;
	height:30px;
	margin-top:20px;
}
.research ul li {
	list-style-type:none;
}
.research ul li form{
	margin:0 0 0 0;
	padding: 0 0 0 0;
}
#page ul li {
	list-style-type:none;
	float: left;
	margin-right: 20px;
}
#page{
	width:600;
	height:50px;

}
-->
</style>
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
<div>这是所有文章总览</div>
<div><a href="/pgepsp/qkdd/prform" target="down_frame">添加新的文章导读</a>
    &nbsp;&nbsp;&nbsp;&nbsp;<a href="/pgepsp/qkdd/pr">刷新页面</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/pgepsp/qkdd/pc" target="down_frame">管理种类</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/pgepsp/qkdd/po" target="down_frame">管理文章来源</a>
<div class="research">
<ul>
<li><form action="/pgepsp/qkdd/research">
 关键字搜索：<input type="text" name="key"/>
<input type="submit" value="提交" style="width:50px"/>
 </form>
 <li><form action="/pgepsp/qkdd/classresearch">
类别搜索：
 <select name="key">
 	<s:iterator value="pubClaList">
    <option value="<s:property value="pc_name"/>"><s:property value="pc_name"/></option>
    </s:iterator>
</select>
<input type="submit" value="提交" style="width:50px"/>
 </form>
 <li><form action="/pgepsp/qkdd/originresearch">
 来源搜索： 
 <select name="key">
 	<s:iterator value="pubOriList">
    <option value="<s:property value="po_name"/>"><s:property value="po_name"/></option>
    </s:iterator>
</select>
<input type="submit" value="提交" style="width:50px"/>
 </form>
 </ul>
</div>
<div>
  <table border="3" width="700">
  <tr><td>文章标题</td><td>类别</td><td>来源</td><td>浏览量</td><td>点击进入</td><td>删除操作</td><td>修改</td></tr>
  <s:iterator value="pubReaList">
  		<tr><td><s:property value="p_title"/></td>
  		<td><s:property value="p_type"/></td>
  		<td><s:property value="p_from"/></td>
  		<td><s:property value="p_count"/></td>
  		<td><a href="<s:url value="/qkdd/prxq">
  			<s:param name="id" value="id"/>
  		</s:url>" target="down_frame">点击查看详细</a></td>
  		<td><a href="<s:url value="/qkdd/delpr">
  			<s:param name="id" value="id"/>
  		</s:url>">删除</a></td>
  		  		<td><a href="<s:url value="/qkdd/updprform">
  			<s:param name="id" value="id"/>
  		</s:url>" target="down_frame">修改</a></td>
  		</tr>
  </s:iterator>
  </table>
  </div>
<br>
  <div style="display: inline;" id="page"><ul>
	<li><a href="<s:url value="/qkdd/pr"><s:param name="method" value="%{'first'}"/><s:param name="pager.currentPage" value="pager.currentPage"/></s:url>">第一页</a></li>
	<li><a href="<s:url value="/qkdd/pr"><s:param name="method" value="%{'back'}"/><s:param name="pager.currentPage" value="pager.currentPage"/></s:url>">上一页</a></li>
	<li><a href="<s:url value="/qkdd/pr"><s:param name="method" value="%{'next'}"/><s:param name="pager.currentPage" value="pager.currentPage"/></s:url>">下一页</a></li>
	<li><a href="<s:url value="/qkdd/pr"><s:param name="method" value="%{'last'}"/><s:param name="pager.currentPage" value="pager.currentPage"/></s:url>">尾页</a></li>
	<li>共<s:property value="pager.maxPages"/>页</li>
	<li>当前是第<s:property value="pager.currentPage"/>页</li>
	<li><form action="/pgepsp/qkdd/pr" method="post" id="gotoform">
	<s:hidden name="method" value="%{'jump'}"/>
	<input type="text" name="pager.currentPage" id="gotopage" style="width:20;" value=""/>
	<input type="button" value="go" onclick="javascript:toPage()"/></form></li></ul>
  </div>
 </div>
  
  <!--
  <div class="iframe">
  <iframe width="800" height="1000" name="framecontent" frameborder="0" src="/pgepsp/qkdd/prxq"></iframe>
  </div>
  -->
  </body>
</html>
