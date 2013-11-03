package org.mail.bean;

public class MailSendBean {//��Bean����Ҫ����������ʼ���ص���Ϣ
	private String username;
	private String password;
	private String subject;//���������ʼ�������
	private String sender;//�������淢���ߵĵ�ַ
	private String reciver;//������������ߵĵ�ַ
	private String message;//�������淢�͵���Ϣ
	private String[] pathes;//�������渽���ļ���·��
	public MailSendBean(){}
	public MailSendBean(String username,String password,String sender,String reciver,String message,String[] pathes,String subject){
		this.username=username;
		this.password=password;
		this.sender=sender;
		this.reciver=reciver;
		this.message=message;
		this.pathes=pathes;
		this.subject=subject;
		StringBuffer res=new StringBuffer(username+"\n");
		res.append(password+"\n");
		res.append(sender+"\n");
		res.append(reciver+"\n");
		res.append(message+"\n");
		for(int i=0;i<pathes.length;i++){
			res.append(pathes[i]+"\n");
		}
		System.out.println(res.toString());
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReciver() {
		return reciver;
	}
	public void setReciver(String reciver) {
		this.reciver = reciver;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String[] getFiles() {
		return pathes;
	}
	public void setFiles(String[] files) {
		this.pathes = files;
	}
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String[] getPathes() {
		return pathes;
	}
	public void setPathes(String[] pathes) {
		this.pathes = pathes;
	}
	

}
