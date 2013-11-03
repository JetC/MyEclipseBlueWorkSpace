package dao;

import java.util.List;
import model.Admin;
import tools.YeekuHibernateDaoSupport;

public class AdminPageDao extends YeekuHibernateDaoSupport<Admin> {
	public int save(Admin h) {
		return (Integer)getHibernateTemplate().save(h);
	}
	public Admin find(int id) {
		return getHibernateTemplate().get(Admin.class,id);
	}

	public void update(Admin h) {
		getHibernateTemplate().update(h);
	}
	
	public void delete(Admin h) {
		getHibernateTemplate().delete(h);
	}
	
	@SuppressWarnings("unchecked")
	public List<Admin> findList(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	public int maxRecords(String hql){
		return getHibernateTemplate().find(hql).size();
	}
}
