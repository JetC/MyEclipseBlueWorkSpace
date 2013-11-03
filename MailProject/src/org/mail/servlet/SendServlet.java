package org.mail.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mail.bean.MailSendBean;
import org.mail.send.MailService;

public class SendServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String sender=request.getParameter("sender");
		String reciver=request.getParameter("reciver");
		String message=request.getParameter("message");
		String subject=request.getParameter("subject");
		String pathes[]=request.getParameterValues("path");
		MailSendBean bean=new MailSendBean(username,password,sender,reciver,message,pathes,subject);
		MailService service=new MailService();
		service.sendMail(bean);
	}
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}
