<%@ page language="java" import="java.util.*,org.apache.struts2.ServletActionContext" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
HttpServletRequest _request = ServletActionContext.getRequest();
String a=(String)_request.getAttribute("a_username");
%>
<%
if(a==null){
%>
<jsp:forward page="Login.jsp"></jsp:forward>
<%
}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/admin.css">
	

  </head>
  
  <body><center>
  <table width="1024" border="0">
    <tr>
      <td colspan="2" style="width:1024px; height:112px"><img src="admin/images/admin_logo.png" height="112px" width="1024px"></td>
    </tr>
    <tr>
      <td colspan="2" style="background: url('admin/images/admin_back.png') " height="28px" width="1024px">&nbsp;</td>
    </tr>
    <tr>
      <td width="214" valign="top">
		<table class="success_table">
		<tr><td><img src="admin/images/admin_head.png" width="22px" height="19px"/><a href="admin/info.action" target="main_frame">起始页管理</a></td></tr>
		<tr><td><img src="admin/images/admin_head.png" width="22px" height="19px"/><a href="hbsy/hbsy_index_manage.action" target="main_frame">环保术语管理</a></td></tr>
		<tr><td><img src="admin/images/admin_head.png" width="22px" height="19px"/><a href="hyjy/hyjy_index_manage.action" target="main_frame">重要会议纪要管理</a></td></tr>
		<tr><td><img src="admin/images/admin_head.png" width="22px" height="19px"/><a href="hdjy/hdjy_index_manage.action" target="main_frame">文化活动纪要管理</a></td></tr>
		<tr><td><img src="admin/images/admin_head.png" width="22px" height="19px"/><a href="qkdd/pr" target="main_frame">电子报纸与期刊导读管理</a></td></tr>
		<tr><td><img src="admin/images/admin_head.png" width="22px" height="19px"/><a href="" target="main_frame">图片影像管理</a></td></tr>
		<tr><td><img src="admin/images/admin_head.png" width="22px" height="19px"/><a href="hdjy/hdjy_index_manage.action" target="main_frame">留言板管理</a></td></tr>
		<tr><td><img src="admin/images/admin_head.png" width="22px" height="19px"/><a href="analysis/show" target="main_frame">信息统计管理</a></td></tr>
		<tr><td height="400px"></td></tr>
		</table>
		</td>
      <td width="800" valign="top" align="left">
      <iframe id="main_frame" name="main_frame" width="800px" height=370px  marginheight="0" marginwidth="0" scrolling="auto" frameborder="0" src="admin/info.action"></iframe>
      <iframe id="down_frame" name="down_frame" width="800px" height="800px" marginheight="0" marginwidth="0" scrolling="auto" frameborder="0" src=""></iframe>
      &nbsp;</td>
      
    </tr>
  </table></center>
  </body>
</html>
