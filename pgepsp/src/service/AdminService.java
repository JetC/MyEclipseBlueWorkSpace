package service;
import model.Admin;
import dao.*;
import java.util.List;
import tools.*;
public class AdminService {
	AdminDao dao;
	AdminPageDao pagedao;
	public AdminDao getDao(){
		return this.dao;
	}
	public void setDao(AdminDao dao){
		this.dao=dao;
	}
	public AdminPageDao getPagedao(){
		return this.pagedao;
	}
	public void setPagedao(AdminPageDao pagedao){
		this.pagedao=pagedao;
	}
	
	//ID列表记录
	public List<Admin> selectAll() {
		String hql="from Admin order by id desc";
		return dao.findAll(hql);
	}
	//ID查找
	public Admin findFromId(int id) {
		return dao.find(id);
	}
	//名称查找
	public Admin findFromName(String a_username) {
		System.out.println("进行到后台管理服务段!");
		//AdminDao dao=new AdminDao();
		String hql="from Admin where a_username='"+a_username+"'";
		return dao.findName(hql);
	}
	//查所有记录
	public int getRows(){
		String hql="from Admin";
		System.out.print("执行到Service层!\n");
		return dao.Records(hql);
	}
	
	//增加记录
	public int add(Admin h){
		System.out.print("执行到Service层!\n");
		//dao=new AdminDao();
		return dao.save(h);
	}
	//删除记录
	public void delete(Admin h){
		System.out.print("执行到Service层!\n");
		dao.delete(h);
	}
	//更新记录
	public void update(Admin h){
		System.out.print("执行到Service层!\n");
		dao.update(h);
	}
	
	
	//分页初始化
	public Pager pageInitial(Pager pager,String method){
		pager.newPager(pager.getCurrentPage(),method,pager.getMaxRecords(),pager.getPageSize());
		return pager;
	}
	//按页显示
	public List<Admin> viewAdminByList(int offset,int pageSize){
		String hql="from Admin order by id Desc";
		return pagedao.findByPage(hql, offset, pageSize);
	}
	
}