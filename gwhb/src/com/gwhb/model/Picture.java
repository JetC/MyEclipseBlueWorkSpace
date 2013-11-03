package com.gwhb.model;

import java.sql.Blob;

public class Picture {
	private int id;
	private String p_title;
	private String p_describe;
	private String p_place;
	private String p_type;
	private Blob p_picture;
	private int p_resolution;
	private String p_extension;
	private int p_templateId;
	private int p_templateNum;
	private int Fk_eId;
	private int Fk_maId;
	private int Fk_pid;
	private String person;

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getP_title() {
		return p_title;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
	}

	public String getP_describe() {
		return p_describe;
	}

	public void setP_describe(String p_describe) {
		this.p_describe = p_describe;
	}

	public String getP_place() {
		return p_place;
	}

	public void setP_place(String p_place) {
		this.p_place = p_place;
	}

	public String getP_type() {
		return p_type;
	}

	public void setP_type(String p_type) {
		this.p_type = p_type;
	}

	public Blob getP_picture() {
		return p_picture;
	}

	public void setP_picture(Blob p_picture) {
		this.p_picture = p_picture;
	}

	public int getP_resolution() {
		return p_resolution;
	}

	public void setP_resolution(int p_resolution) {
		this.p_resolution = p_resolution;
	}

	public String getP_extension() {
		return p_extension;
	}

	public void setP_extension(String p_extension) {
		this.p_extension = p_extension;
	}

	public int getP_templateId() {
		return p_templateId;
	}

	public void setP_templateId(int p_templateId) {
		this.p_templateId = p_templateId;
	}

	public int getP_templateNum() {
		return p_templateNum;
	}

	public void setP_templateNum(int p_templateNum) {
		this.p_templateNum = p_templateNum;
	}

	public int getFk_eId() {
		return Fk_eId;
	}

	public void setFk_eId(int fk_eId) {
		Fk_eId = fk_eId;
	}

	public int getFk_maId() {
		return Fk_maId;
	}

	public void setFk_maId(int fk_maId) {
		Fk_maId = fk_maId;
	}

	public int getFk_pid() {
		return Fk_pid;
	}

	public void setFk_pid(int fk_pid) {
		Fk_pid = fk_pid;
	}
}
