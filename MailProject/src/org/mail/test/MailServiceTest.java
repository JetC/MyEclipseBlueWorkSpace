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
		bean.setSubject("JavaMail����");
		bean.setUsername("471169473@qq.com");
		bean.setPassword("1234567890a");
		bean.setSender("471169473@qq.com");
		bean.setReciver("471169473@qq.com");
		bean.setMessage("������Ҫ���۵�������Ҫ�ǹ���JavaMail�����֪ʶ��,������֮ǰ���������ع��£���û�е����ʼ�֮ǰ���ദ���ص��ˣ����ǵ�ͨ�Ÿ�����ǲ���д�ţ����ߵ绰��");
	    String path[]={"c:\\image.rar"};
		bean.setFiles(path);
	    MailService service=new MailService();
	    service.sendMail(bean);
	    System.out.println("���ͳɹ�!");
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
