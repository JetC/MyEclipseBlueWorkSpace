package org.mail.test;

import junit.framework.TestCase;

import org.mail.bean.MailReciveBean;
import org.mail.recive.MailRecive;

public class MailReciveTest extends TestCase{
	public void testRecive(){
		MailReciveBean bean=new MailReciveBean();
		bean.setHost("pop.qq.com");
		bean.setUsername("471169473@qq.com");
		bean.setPassword("1234567890a");
		bean.setSavePath("d:\\");
		MailRecive recive=new MailRecive();
		recive.reciveMail(bean);
		
	}

}
