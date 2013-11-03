package model;

import java.util.Date;

public class Hdjy {
	private int id;
	private String a_title;
	private String a_abstract;
	private String a_detail;
	private Date a_time;
	private Date a_addtime;
	private int a_personId;	
	private int a_count;
	private String a_type;

	public void setId(int id){		
		this.id=id;
	}
	public int getId(){
		return this.id;
	}
	public void setA_title(String a_title){
		this.a_title=a_title;
	}
	public String getA_title(){
		return this.a_title;
	}
	
	public void setA_abstract(String a_abstract){
		this.a_abstract=a_abstract;
	}
	public String getA_abstract(){
		return this.a_abstract;
	}
	
	public void setA_detail(String a_detail){
		this.a_detail=a_detail;
	}
	public String getA_detail(){
		return this.a_detail;
	}
	public void setA_time(Date a_time){
		this.a_time=a_time;
	}
	public Date getA_time(){		
		return this.a_time;
	}
	public void setA_addtime(Date a_addtime){
		this.a_addtime=a_addtime;
	}
	public Date getA_addtime(){		
		return this.a_addtime;
	}
	
	public void setA_personId(int a_personId){
		this.a_personId=a_personId;
	}
	public int getA_personId(){
		return this.a_personId;
	}
	
	public void setA_count(int a_count){
		this.a_count=a_count;
	}
	public int getA_count(){
		return this.a_count;
	}
	
	public void setA_type(String a_type){
		this.a_type=a_type;
	}
	public String getA_type(){
		return this.a_type;
	}
}
