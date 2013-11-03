package org.mail.bean;

public class MailReciveBean {
	private String username;//用来保存登录名
	private String password;//用来保存登录的密码
	private String host;//用来保存主机的地址
	private String savePath;//用来存放附件的保存路径
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
}
