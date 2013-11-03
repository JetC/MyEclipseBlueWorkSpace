package dao;

import java.util.List;
import model.*;
import tools.YeekuHibernateDaoSupport;

public class HyjyPageDao extends YeekuHibernateDaoSupport<Hyjy> {
	public int save(Hyjy h) {
		return (Integer)getHibernateTemplate().save(h);
	}
	public Hyjy find(int id) {
		return getHibernateTemplate().get(Hyjy.class,id);
	}

	public void update(Hyjy h) {
		getHibernateTemplate().update(h);
	}
	
	public void delete(Hyjy h) {
		getHibernateTemplate().delete(h);
	}
	
	@SuppressWarnings("unchecked")
	public List<Hyjy> findList(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	public int maxRecords(String hql){
		return getHibernateTemplate().find(hql).size();
	}
}
