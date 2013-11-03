<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
response.setContentType("image/jpeg");
byte[] data = null;
	data = (byte[])ActionContext.getContext().getSession().get("p_picture");
	out.println("length=" + data.length);
	ServletOutputStream op = response.getOutputStream();
	op.write(data, 0, data.length);
	op.close();
	op = null;
	response.flushBuffer();
	//清除输出流，防止释放时被捕获异常
	out.clear();
	out = pageContext.pushBody();
%>
