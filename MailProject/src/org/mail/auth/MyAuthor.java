package org.mail.auth;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthor extends Authenticator{//在JavaMail中,如果需要认证，对于程序员来说必须继承Authenticator抽象类
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
