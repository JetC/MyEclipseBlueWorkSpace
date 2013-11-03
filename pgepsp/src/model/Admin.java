package model;

public class Admin {
	int id;
	String a_name;
	String a_username;
	String a_super;
	String a_password;
	public int getId(){
		return this.id;
			}
	public void setId(int id){
		this.id=id;
	}
	public String getA_name(){
		return this.a_name;
	}
	public void setA_name(String a_name ){
		this.a_name=a_name;
	}
	public String getA_username(){
		return this.a_username;
	}
	public void setA_username(String a_username ){
		this.a_username=a_username;
	}
	public String getA_password(){
		return this.a_password;
	}
	public void setA_password(String a_password ){
		this.a_password=a_password;
	}
	public String getA_super(){
		return this.a_super;
	}
	public void setA_super(String a_super){
		this.a_super=a_super;
	}
}
