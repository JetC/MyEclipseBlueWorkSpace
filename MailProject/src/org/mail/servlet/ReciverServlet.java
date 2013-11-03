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
		response.setContentType("message/rfc822");//��Ҫ����Ӧ���ݵ���������Ϊmessage/rfc822
		ServletOutputStream out=response.getOutputStream();//��ȡ��Ӧ���ֽ���
		Properties prop=System.getProperties();
		Session sess=Session.getDefaultInstance(prop);//��ȡ�������֮��ĻỰ����
		try {
			Store store=sess.getStore("pop3");//ͨ���Ự��ȡStore����
		    String host="pop.qq.com";//ȷ����������ַ
		    String username="471169473@qq.com";//ȷ����¼��
		    String password="1234567890a";//ȷ����¼����
		    store.connect(host, username, password);//�����û����������¼��ָ���ķ�����
		    Folder fold=store.getFolder("inbox");//�����ļ�����Ϊinbox
		    fold.open(Folder.READ_ONLY);//��ֻ���ķ�ʽ���ļ���
		    Message[] mess=fold.getMessages();//��ȡ�ļ���������ʼ�
		    for(int i=0;i<mess.length;i++){//����ѭ�����ʼ������������ʾ����
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
