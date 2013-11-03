package org.mail.servlet;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReciverServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("message/rfc822");//需要把响应内容的类型设置为message/rfc822
		ServletOutputStream out=response.getOutputStream();//获取响应的字节六
		Properties prop=System.getProperties();
		Session sess=Session.getDefaultInstance(prop);//获取与服务器之间的会话连接
		try {
			Store store=sess.getStore("pop3");//通过会话获取Store对象
		    String host="pop.qq.com";//确定服务器地址
		    String username="471169473@qq.com";//确定登录名
		    String password="1234567890a";//确定登录密码
		    store.connect(host, username, password);//根据用户名和密码登录到指定的服务器
		    Folder fold=store.getFolder("inbox");//开打文件夹名为inbox
		    fold.open(Folder.READ_ONLY);//以只读的方式打开文件夹
		    Message[] mess=fold.getMessages();//获取文件夹下面的邮件
		    for(int i=0;i<mess.length;i++){//利用循环把邮件在浏览器中显示出来
		    	Message m=mess[i];
		    	m.writeTo(out);		    	
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 doGet(request,response);
	}
}
