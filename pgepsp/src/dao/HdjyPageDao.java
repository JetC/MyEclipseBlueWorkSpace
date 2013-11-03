package dao;

import java.util.List;
import model.*;
import tools.YeekuHibernateDaoSupport;

public class HdjyPageDao extends YeekuHibernateDaoSupport<Hdjy> {
	public int save(Hdjy h) {
		return (Integer)getHibernateTemplate().save(h);
	}
	public Hdjy find(int id) {
		return getHibernateTemplate().get(Hdjy.class,id);
	}

	public void update(Hdjy h) {
		getHibernateTemplate().update(h);
	}
	
	public void delete(Hdjy h) {
		getHibernateTemplate().delete(h);
	}
	
	@SuppressWarnings("unchecked")
	public List<Hdjy> findList(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	public int maxRecords(String hql){
		return getHibernateTemplate().find(hql).size();
	}
}
