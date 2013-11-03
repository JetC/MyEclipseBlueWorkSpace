package dao;

import java.util.List;
import model.Admin;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AdminDao extends HibernateDaoSupport{
	//存记录
	public int save(Admin h) {
		System.out.print("执行到Dao层!\n");
		return (Integer)getHibernateTemplate().save(h);
	}
	//改记录
	public void update(Admin h) {
		getHibernateTemplate().update(h);
	}
	//删记录
	public void delete(Admin h) {
		getHibernateTemplate().delete(h);
	}
	//按ID找记录
	public Admin find(int id) {
		return getHibernateTemplate().get(Admin.class,id);
	}
	//按名称查找
	
	public Admin findName(String hql) {
		System.out.println("进行到后台管理DAO层!");
		@SuppressWarnings("unchecked")
		List<Admin> l=getHibernateTemplate().find(hql);
		System.out.println("查询完毕");
		if(l.size()==0){
			return null;
		}
		else{
		Admin h = new Admin();
		h.setA_name(l.get(0).getA_name());
		h.setA_password(l.get(0).getA_password());
		h.setA_super(l.get(0).getA_super());
		h.setA_username(l.get(0).getA_username());
		return h;}
	}
	@SuppressWarnings("unchecked")
	//查找多个记录
	public List<Admin> findList(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	@SuppressWarnings("unchecked")
	//查找所有记录
	public List<Admin> findAll(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	//记录的总数
	public int Records(String hql){
		System.out.print("执行到Dao层!\n");		
		return getHibernateTemplate().find(hql).size();
	}
	
}