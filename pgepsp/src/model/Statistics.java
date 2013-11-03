package model;

import java.util.Date;

public class Statistics {
	private int id;
	private Date s_enterTime;
	private Date s_closeTime;
	private Long s_totalTime;
	private String s_ip;
	private String s_type;
	private int FK_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getS_enterTime() {
		return s_enterTime;
	}
	public void setS_enterTime(Date s_enterTime) {
		this.s_enterTime = s_enterTime;
	}
	public Date getS_closeTime() {
		return s_closeTime;
	}
	public void setS_closeTime(Date s_closeTime) {
		this.s_closeTime = s_closeTime;
	}
	public Long getS_totalTime() {
		return s_totalTime;
	}
	public void setS_totalTime(Long s_totalTime) {
		this.s_totalTime = s_totalTime;
	}
	public String getS_ip() {
		return s_ip;
	}
	public void setS_ip(String s_ip) {
		this.s_ip = s_ip;
	}
	public String getS_type() {
		return s_type;
	}
	public void setS_type(String s_type) {
		this.s_type = s_type;
	}
	public int getFK_id() {
		return FK_id;
	}
	public void setFK_id(int fK_id) {
		FK_id = fK_id;
	}
}
