package org.mail.auth;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthor extends Authenticator{//��JavaMail��,�����Ҫ��֤�����ڳ���Ա��˵����̳�Authenticator������
	private String username;
	private String password;
	public MyAuthor(String username,String password){
		this.username=username;
		this.password=password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username,password);
	}
}
