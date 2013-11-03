package action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import model.Admin;
import service.AdminService;

public class AdminAction {
	int id;
	String a_name;
	String a_username;
	String a_super;
	String a_password;
	Admin h;
	AdminService adminservice;
	//辅助变量
	String user_check;
	String ip;
	String nowTime;
	String isSuper;
	public int getId(){
		return this.id;
			}
	public void setId(int id){
		this.id=id;
	}
	public String getA_name(){
		return this.a_name;
	}
	public void setA_name(String a_name){
		this.a_name=a_name;
	}
	public String getA_username(){
		return this.a_username;
	}
	public void setA_username(String a_username){
		this.a_username=a_username;
	}
	public String getA_password(){
		return this.a_password;
	}
	public void setA_password(String a_password){
		this.a_password=a_password;
	}
	public String getA_super(){
		return this.a_super;
	}
	public void setA_super(String a_super){
		this.a_super=a_super;
	}
	public Admin getH(){
		return this.h;
	}
	public void setH(Admin h){
		this.h=h;
	}
	public AdminService getAdminservice(){
		return this.adminservice;
	}
	public void setAdminservice(AdminService adminservice){
		this.adminservice=adminservice;
	}

	//中间辅助变量
	public String getUser_check(){
		return this.user_check;
	}
	public String getIp(){
		return this.ip;
	}
	public String getNowTime(){
		return this.nowTime;
	}
	public String getIsSuper(){
		return this.isSuper;
	}
//以下是Action的方法
	public String admin_login_index(){
		return "login_index";
	}
	public String admin_login(){
		System.out.print("即将进入登陆验证:"+a_username+"\n");
		//AdminService adminservice=new AdminService();
		h=adminservice.findFromName(a_username);
		if(h==null){
			user_check="您输入的用户不存在!";
			return "login_false";
		}
		else{
			if(a_password.equals(h.getA_password())){
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();			
				session.setAttribute("a_username", a_username);
				session.setAttribute("a_super",h.getA_super());
				session.setAttribute("a_name", h.getA_name());
				return "login_success";
			}
			else{
				user_check="您输入的密码错误!";
				return "login_false";
			}
		}
	}
	
	public String info(){
		//写入session的ACTION方法
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();	
		//session.setAttribute("a_username","国网环保管理员");
		a_username=(String) session.getAttribute("a_username");
		ip=getIpAddr(request);
		long t=new Date().getTime();
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		nowTime=""+df.format(t);	
		isSuper=(String)session.getAttribute("a_super");
		return "info";
	}
	
	public String admin_add(){		
		return "add_success";
	}
	public String admin_add_do(){
		System.out.print("即将进入管理员添加:户名"+a_username+"  真实名字"+a_name+"  权限"+a_super+"  密码"+a_password+"\n");
		h.setA_name(a_name);
		h.setA_username(a_username);
		h.setA_super(a_super);
		h.setA_password(a_password);
		adminservice.add(h);
		return "add_success";
	}
	
	public String admin_info(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		a_username=(String) session.getAttribute("a_username");
		a_name=(String) session.getAttribute("a_name");
		a_super=(String) session.getAttribute("a_super");
		return "info";
	}
	public String admin_logout(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		a_username=null;
		a_name=null;
		a_super=null;
		session.setAttribute("a_username",null);
		session.setAttribute("a_name",null);
		session.setAttribute("a_super",null);
		return "logout";
	}
	
	
	
	//查看IP
		public String getIpAddr(HttpServletRequest request){
			String ip=request.getHeader("x-forwarded-for");
			if(ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
				ip=request.getHeader("Proxy-Client-IP");
			}
			if(ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
				ip=request.getHeader("WL-Proxy-Client-IP");
			}
			if(ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
				ip=request.getRemoteAddr();
			}
			return ip;
		}
}
