package org.mail.send;


import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeMessage.RecipientType;

import org.mail.auth.MyAuthor;
import org.mail.bean.MailSendBean;

import sun.misc.BASE64Encoder;

public class MailService {
	private Properties sendParameter;//该对象用来保存和发送邮件相关的配置信息
	
	
	public Properties getSendParameter() {
		if(sendParameter==null){
			sendParameter=new Properties();
			sendParameter.put("mail.transport.protocol","smtp");//该语句用来设置发送邮件的协议
			sendParameter.put("mail.smtp.port", "25");//该语句用来设置发送邮件的端口号
			sendParameter.put("mail.smtp.host", "smtp.qq.com");//该语句用来设置发送电子邮件的服务器地址
			sendParameter.put("mail.smtp.auth","true");//该语句用来设计登录服务器时是否需要安全认证
		}
		return sendParameter;
	}
	public void setSendParameter(Properties sendParameter) {
		this.sendParameter = sendParameter;
	}
	public boolean sendMail(MailSendBean bean){//该方法用来接收，外部发送邮件的信息，同时发送出去
		Properties p=this.getSendParameter();//该语句用来获取发送邮件的配置参数
		String username=bean.getUsername();//获取用户名
		String password=bean.getPassword();//获取密码
		MyAuthor author=new MyAuthor(username,password);//根据用户名和密码，构造认证的对象
		Session session=Session.getDefaultInstance(p,author);//根据配置参数，和认证对象，来获取会话对象
		MimeMessage message=new MimeMessage(session);//根据会话对象，来获取消息
		try {
			message.setSubject(bean.getSubject());
			message.setSender(new InternetAddress(bean.getSender()));
			message.setRecipient(RecipientType.TO, new InternetAddress(bean.getReciver()));
            Multipart filePart=new MimeMultipart();//该语句用来构造带附件的消息体
            
            MimeBodyPart body=null;
            BASE64Encoder encode=new BASE64Encoder();
            for(int i=0;i<bean.getFiles().length;i++){
            	 body=new MimeBodyPart();
            	 DataSource source=new FileDataSource(bean.getFiles()[i]);//获取附件的路径
            	 DataHandler handler=new DataHandler(source);
            	 body.setDataHandler(handler);
            	 sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
            	 String fileName=bean.getFiles()[i];
            	 fileName=fileName.substring(fileName.lastIndexOf('\\')+1,fileName.length());
            	 body.setFileName("=?GBK?B?"+enc.encode(fileName.getBytes())+"?=");
            	 filePart.addBodyPart(body); 
            }
            body=new MimeBodyPart();
            body.setText(bean.getMessage());//设计消息的文本内容
            filePart.addBodyPart(body);
            message.setContent(filePart);
            Transport.send(message);
            System.out.println("发送成功!");
            return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 		
		return false;
	}
	

}








