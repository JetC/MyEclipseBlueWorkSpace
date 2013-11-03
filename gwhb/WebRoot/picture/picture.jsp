<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	String fileType = (String) request.getAttribute("fileType");
	if (fileType.equals("image/bmp")) {
		response.setContentType("image/bmp");
	} else if (fileType.equals("image/pjpeg")) {
		response.setContentType("image/jpeg");
	} else if (fileType.equals("image/gif")) {
		response.setContentType("image/gif");
	} else if (fileType.equals("image/x-png")) {
		response.setContentType("image/png");
	}
	byte[] data = null;
	data = (byte[]) request.getAttribute("bs");

	ServletOutputStream op = response.getOutputStream();
	op.write(data, 0, data.length);
	op.flush();
	op.close();
	op = null;
	response.flushBuffer();
	//清除输出流，防止释放时被捕获异常
	out.clear();
	out = pageContext.pushBody();
%>