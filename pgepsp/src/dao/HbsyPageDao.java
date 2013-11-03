package dao;

import java.util.List;
import model.*;
import tools.YeekuHibernateDaoSupport;

public class HbsyPageDao extends YeekuHibernateDaoSupport<Hbsy> {
	public int save(Hbsy h) {
		return (Integer)getHibernateTemplate().save(h);
	}
	public Hbsy find(int id) {
		return getHibernateTemplate().get(Hbsy.class,id);
	}

	public void update(Hbsy h) {
		getHibernateTemplate().update(h);
	}
	
	public void delete(Hbsy h) {
		getHibernateTemplate().delete(h);
	}
	
	@SuppressWarnings("unchecked")
	public List<Hbsy> findList(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	public int maxRecords(String hql){
		return getHibernateTemplate().find(hql).size();
	}
}
