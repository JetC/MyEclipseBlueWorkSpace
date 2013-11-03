package model;

import java.util.Date;

public class Hyjy {
	private int id;
	private String m_title;
	private String m_abstract;
	private String m_detail;
	private Date m_time;
	private Date m_addtime;
	private int m_personId;	
	private int m_count;
	private String m_type;

	public void setId(int id){		
		this.id=id;
	}
	public int getId(){
		return this.id;
	}
	public void setM_title(String m_title){
		this.m_title=m_title;
	}
	public String getM_title(){
		return this.m_title;
	}
	
	public void setM_abstract(String m_abstract){
		this.m_abstract=m_abstract;
	}
	public String getM_abstract(){
		return this.m_abstract;
	}
	
	public void setM_detail(String m_detail){
		this.m_detail=m_detail;
	}
	public String getM_detail(){
		return this.m_detail;
	}
	public void setM_time(Date m_time){
		this.m_time=m_time;
	}
	public Date getM_time(){		
		return this.m_time;
	}
	public void setM_addtime(Date m_addtime){
		this.m_addtime=m_addtime;
	}
	public Date getM_addtime(){		
		return this.m_addtime;
	}
	
	public void setM_personId(int m_personId){
		this.m_personId=m_personId;
	}
	public int getM_personId(){
		return this.m_personId;
	}
	
	public void setM_count(int m_count){
		this.m_count=m_count;
	}
	public int getM_count(){
		return this.m_count;
	}
	
	public void setM_type(String m_type){
		this.m_type=m_type;
	}
	public String getM_type(){
		return this.m_type;
	}
}
