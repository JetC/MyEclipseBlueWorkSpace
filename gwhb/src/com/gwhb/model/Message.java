package com.gwhb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model层主要负责在各层之间传递数据。
 * 
 * @author 曹黎宏宇。
 * 
 */
//Hibernate中说明该类为实体类，要在数据库中对应数据库表。
@Entity
//设置该表表名为db_message。
@Table(name = "db_message")
public class Message {

	private int id;
	private String ip;
	private String content;
	private Date time;
	private String reply;
	private Date replytime;
	private String replyer;

	//表示该字段对应主键。
	@Id
	//表示该字段自动递增。
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//表示该字段对应字段名为m_ip，下同。
	@Column(name = "m_ip")
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "m_content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "m_time")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "m_reply")
	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	@Column(name = "m_replytime")
	public Date getReplytime() {
		return replytime;
	}

	public void setReplytime(Date replytime) {
		this.replytime = replytime;
	}

	@Column(name = "m_replyer")
	public String getReplyer() {
		return replyer;
	}

	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}

}