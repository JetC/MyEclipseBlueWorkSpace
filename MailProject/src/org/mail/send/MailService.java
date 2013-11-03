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
	private Properties sendParameter;//�ö�����������ͷ����ʼ���ص�������Ϣ
	
	
	public Properties getSendParameter() {
		if(sendParameter==null){
			sendParameter=new Properties();
			sendParameter.put("mail.transport.protocol","smtp");//������������÷����ʼ���Э��
			sendParameter.put("mail.smtp.port", "25");//������������÷����ʼ��Ķ˿ں�
			sendParameter.put("mail.smtp.host", "smtp.qq.com");//������������÷��͵����ʼ��ķ�������ַ
			sendParameter.put("mail.smtp.auth","true");//�����������Ƶ�¼������ʱ�Ƿ���Ҫ��ȫ��֤
		}
		return sendParameter;
	}
	public void setSendParameter(Properties sendParameter) {
		this.sendParameter = sendParameter;
	}
	public boolean sendMail(MailSendBean bean){//�÷����������գ��ⲿ�����ʼ�����Ϣ��ͬʱ���ͳ�ȥ
		Properties p=this.getSendParameter();//�����������ȡ�����ʼ������ò���
		String username=bean.getUsername();//��ȡ�û���
		String password=bean.getPassword();//��ȡ����
		MyAuthor author=new MyAuthor(username,password);//�����û��������룬������֤�Ķ���
		Session session=Session.getDefaultInstance(p,author);//�������ò���������֤��������ȡ�Ự����
		MimeMessage message=new MimeMessage(session);//���ݻỰ��������ȡ��Ϣ
		try {
			message.setSubject(bean.getSubject());
			message.setSender(new InternetAddress(bean.getSender()));
			message.setRecipient(RecipientType.TO, new InternetAddress(bean.getReciver()));
            Multipart filePart=new MimeMultipart();//����������������������Ϣ��
            
            MimeBodyPart body=null;
            BASE64Encoder encode=new BASE64Encoder();
            for(int i=0;i<bean.getFiles().length;i++){
            	 body=new MimeBodyPart();
            	 DataSource source=new FileDataSource(bean.getFiles()[i]);//��ȡ������·��
            	 DataHandler handler=new DataHandler(source);
            	 body.setDataHandler(handler);
            	 sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
            	 String fileName=bean.getFiles()[i];
            	 fileName=fileName.substring(fileName.lastIndexOf('\\')+1,fileName.length());
            	 body.setFileName("=?GBK?B?"+enc.encode(fileName.getBytes())+"?=");
            	 filePart.addBodyPart(body); 
            }
            body=new MimeBodyPart();
            body.setText(bean.getMessage());//�����Ϣ���ı�����
            filePart.addBodyPart(body);
            message.setContent(filePart);
            Transport.send(message);
            System.out.println("���ͳɹ�!");
            return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 		
		return false;
	}
	

}








