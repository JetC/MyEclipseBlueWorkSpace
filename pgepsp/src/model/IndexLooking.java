package model;

import java.util.Date;

public class IndexLooking {
	private int id;
	private Date i_enterTime;
	private String i_ip;
	public String getI_ip() {
		return i_ip;
	}
	public void setI_ip(String i_ip) {
		this.i_ip = i_ip;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getI_enterTime() {
		return i_enterTime;
	}
	public void setI_enterTime(Date i_enterTime) {
		this.i_enterTime = i_enterTime;
	}

}
