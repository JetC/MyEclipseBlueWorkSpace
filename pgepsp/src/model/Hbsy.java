package model;

import java.util.Date;

public class Hbsy {
	private int id;
	private String e_name;
	private String e_abstract;
	private String e_detail;
	private Date e_addtime;
	private int e_personId;	
	private int e_count;
	private String e_type;

	public void setId(int id){		
		this.id=id;
	}
	public int getId(){
		return this.id;
	}
	public void setE_name(String e_name){
		this.e_name=e_name;
	}
	public String getE_name(){
		return this.e_name;
	}
	
	public void setE_abstract(String e_abstract){
		this.e_abstract=e_abstract;
	}
	public String getE_abstract(){
		return this.e_abstract;
	}
	
	public void setE_detail(String e_detail){
		this.e_detail=e_detail;
	}
	public String getE_detail(){
		return this.e_detail;
	}
	
	public void setE_addtime(Date e_addtime){
		this.e_addtime=e_addtime;
	}
	public Date getE_addtime(){		
		return this.e_addtime;
	}
	
	public void setE_personId(int e_personId){
		this.e_personId=e_personId;
	}
	public int getE_personId(){
		return this.e_personId;
	}
	
	public void setE_count(int e_count){
		this.e_count=e_count;
	}
	public int getE_count(){
		return this.e_count;
	}
	
	public void setE_type(String e_type){
		this.e_type=e_type;
	}
	public String getE_type(){
		return this.e_type;
	}
}
