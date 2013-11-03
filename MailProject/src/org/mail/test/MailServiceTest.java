package org.mail.test;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

import junit.framework.TestCase;

import org.mail.bean.*;
import org.mail.send.MailService;
public class MailServiceTest extends TestCase{
	public void testSend(){
		MailSendBean bean=new MailSendBean();
		bean.setSubject("JavaMail测试");
		bean.setUsername("471169473@qq.com");
		bean.setPassword("1234567890a");
		bean.setSender("471169473@qq.com");
		bean.setReciver("471169473@qq.com");
		bean.setMessage("本章主要讨论的问题主要是关于JavaMail方面的知识点,在讨论之前我们先来回顾下，在没有电子邮件之前，相处两地的人，他们的通信更多的是采用写信，或者电话，");
	    String path[]={"c:\\image.rar"};
		bean.setFiles(path);
	    MailService service=new MailService();
	    service.sendMail(bean);
	    System.out.println("发送成功!");
	}
	public void reciver(){
	    Properties p=System.getProperties();
	    Session session=Session.getDefaultInstance(p);
	    try{
	    	Store store=session.getStore();
	    	Folder f=store.getFolder("inbox");
	    	Message mess[]=f.getMessages();
	    	for(int i=0;i<mess.length;i++){
	    		Message m=mess[i];
	    		
	    	}
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    }
	  
	    
	}

}
