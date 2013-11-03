<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	response.setContentType("image/jpeg");
	//response.setContentType("image/gif");
	//response.setContentType("image/png");
	//response.setContentType("image/gif");
	//response.setContentType("image/image/bitmap");
	byte[] data = null;
	data = (byte[])ActionContext.getContext().getSession().get("pic");
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
