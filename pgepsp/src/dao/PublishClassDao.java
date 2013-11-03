package dao;

import java.util.List;

import model.PublishClass;


import tools.YeekuHibernateDaoSupport;

public class PublishClassDao extends YeekuHibernateDaoSupport<PublishClass>{
	
	public int save(PublishClass publishClass) {
		return (Integer)getHibernateTemplate().save(publishClass);
	}
	
	public PublishClass find(int id) {
		return getHibernateTemplate().get(PublishClass.class,id);
	}

	public void update(PublishClass publishClass) {
		getHibernateTemplate().update(publishClass);
	}
	
	public void delete(PublishClass publishClass) {
		getHibernateTemplate().delete(publishClass);
	}
	
	@SuppressWarnings("unchecked")
	public List<PublishClass> findList(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	public int maxRecords(String hql){
		return getHibernateTemplate().find(hql).size();
	}
}
