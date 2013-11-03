<%@ page language="java" import="java.util.*,org.apache.struts2.ServletActionContext
" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
HttpServletRequest _request = ServletActionContext.getRequest();
String isFirstPage=(String)_request.getAttribute("isFirst");
int a=3;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Hbsy2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="../css/hdjy.css" rel="stylesheet" type="text/css" />
    <link href="../css/together.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body><center>
   <jsp:include page="../head.jsp"/>
    <table width="1024" border="0">
      <tr>
        <td width="214" height="191" style="background:url(hdjy/images/hdjy_small.png) no-repeat" valign="top">
        <br/><br/><br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;浏览量最多:<br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <img src="hdjy/images/hdjy_head.png"  width="20px" height="20px"/>
        <a href="<s:url value="/hdjy/hdjy_look.action">
              		   <s:param name="id" value="numRankId[0]"/>
           			   </s:url>" ><s:property value="numRank[0]"/></a><br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <img src="hdjy/images/hdjy_head.png"  width="20px" height="20px"/>
        <a href="<s:url value="/hdjy/hdjy_look.action">
              		   <s:param name="id" value="numRankId[1]"/>
           			   </s:url>" ><s:property value="numRank[1]"/></a><br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <img src="hdjy/images/hdjy_head.png"  width="20px" height="20px"/>
        <a href="<s:url value="/hdjy/hdjy_look.action">
              		   <s:param name="id" value="numRankId[2]"/>
           			   </s:url>" ><s:property value="numRank[2]"/></a><br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <img src="hdjy/images/hdjy_head.png"  width="20px" height="20px"/>
        <a href="<s:url value="/hdjy/hdjy_look.action">
              		   <s:param name="id" value="numRankId[3]"/>
           			   </s:url>" ><s:property value="numRank[3]"/></a>
        </td>


<td width="800" rowspan="3" valign="top" align="center">
<!-- 右下区域800px         -->
        
        <div id="hdjy">
<table class="hdjy_table1" width="800px">
<tr height="49px"><td colspan="4" valign="middle" style="background:url(hdjy/images/hdjy.png) no-repeat;  " align="right">您现在的位置:首页 &gt; 文化活动纪要</td></tr>
<tr><td colspan="4" valign="middle" align="right">
<div id="middle_search"><ul><li><form action="hdjy/hdjy_search" method="post">请输入检索内容:<input type="text" name="keyword"/>
<select name="word" >
 <option selected="selected" value="a_title">活动纪要主题</option>
 <option value="a_type">活动纪要类型</option>
 <option value="other">活动纪要详细</option>
</select>
<input type="submit" value="检索"/></form></li></ul></div></td></tr>
<tr height="18px"><td></td><td style="border-bottom: 1px dotted #00FF00;">文化活动纪要</td><td align="center" style="border-bottom: 1px dotted #00FF00;">浏览量</td><td align="center" style="border-bottom: 1px dotted #00FF00;">创建时间</td>
</tr>
<s:iterator value="allList">
<tr height="18px" ><td width="50px" ></td>
					   <td width="500px" style="border-bottom: 1px dotted #00FF00;"><img src="hdjy/images/hdjy_head.png" width="20px" height="20px"><a href="<s:url value="/hdjy/hdjy_look.action">
              		   <s:param name="id" value="id"/>
           			   </s:url>" ><s:property value="a_title"/></a>
           			   <%if(a>0&&isFirstPage.equals("1")){
           			   a--;
           			   out.print("<img src=\"images/new.gif\"/>");
           			   }
           			   else{
           			   }
           			    %>
           			   </td>
           			   <td  width="100px" align="center" style="border-bottom: 1px dotted #00FF00;"><a href="<s:url value="/hdjy/hdjy_look.action">
              		   <s:param name="id" value="id"/>
           			   </s:url>"><s:property value="a_count"/></a></td>
           			   <td width="150px" align="center" style="border-bottom: 1px dotted #00FF00;"><a href="<s:url value="/hdjy/hdjy_look.action">
              		   <s:param name="id" value="id"/>
           			   </s:url>">[<s:property value="a_addtime"/>]</a></td></tr>
</s:iterator>

<tr><td></td><td colspan="3">
<table class="hdjy_table2">
<tr><td>共${num}条&nbsp;每页9条&nbsp;页次:<s:property value="pager.currentPage" />/<s:property value="pager.maxPages" /></td>
<td width="30px"></td>
<td bgcolor="#DCD9D4" ><a href="<s:url value="/hdjy/hdjy_index_look"><s:param name="method" value="%{'first'}"/><s:param name="pager.currentPage" value="pager.currentPage"/></s:url>">首页</a></td>
<td bgcolor="#DCD9D4"><a href="<s:url value="/hdjy/hdjy_index_look"><s:param name="method" value="%{'back'}"/><s:param name="pager.currentPage" value="pager.currentPage"/></s:url>">上一页</a></td>
<td bgcolor="#EBEBEA">&nbsp;<s:property value="pager.currentPage" />&nbsp;</td>
<td bgcolor="DCD9D4"><a href="<s:url value="/hdjy/hdjy_index_look"><s:param name="method" value="%{'next'}"/><s:param name="pager.currentPage" value="pager.currentPage"/></s:url>">下一页</a></td>
<td align="left"><div class="bottom_table">
						<ul><li><form action="/hdjy/hdjy_index_look" method="post">
						<s:hidden name="method" value="%{'jump'}" />
						跳转:<input type="text" name="pager.currentPage" style="width:30px;" /><input type="submit" value="Go"/></form></li></ul></div>
</td>
<td width="24px"></td>
<td bgcolor="#DCD9D4"><a href="<s:url value="/hdjy/hdjy_index_look"><s:param name="method" value="%{'last'}"/><s:param name="pager.currentPage" value="pager.currentPage"/></s:url>">尾页</a></td>
</tr>
</table></td></tr>
</table>
</div>   
      



</td>
      </tr>
      <tr>
        <td height="253"  style="background:url(hdjy/images/zyhyjy.png) no-repeat" valign="top">
		<br/><br/><br/><br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="hdjy/images/hdjy_head.png"  width="20px" height="20px"/>测试数据1<br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="hdjy/images/hdjy_head.png"  width="20px" height="20px"/>测试数据2<br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="hdjy/images/hdjy_head.png"  width="20px" height="20px"/>测试数据3<br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="hdjy/images/hdjy_head.png"  width="20px" height="20px"/>测试数据4<br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="hdjy/images/hdjy_head.png"  width="20px" height="20px"/>测试数据5<br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="hdjy/images/hdjy_head.png"  width="20px" height="20px"/>测试数据6<br/>


		</td>
      </tr>
     
    </table>
   <jsp:include page="../foot.jsp"/>
  </center>
  </body>
</html>
