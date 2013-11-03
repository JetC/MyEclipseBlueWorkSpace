package dao;

import java.util.List;

import model.PublishOrigin;
import tools.YeekuHibernateDaoSupport;

public class PublishOriginDao extends YeekuHibernateDaoSupport<PublishOrigin>{
	public int save(PublishOrigin publishOrigin) {
		return (Integer)getHibernateTemplate().save(publishOrigin);
	}
	
	public PublishOrigin find(int id) {
		return getHibernateTemplate().get(PublishOrigin.class,id);
	}

	public void update(PublishOrigin publishOrigin) {
		getHibernateTemplate().update(publishOrigin);
	}
	
	public void delete(PublishOrigin publishOrigin) {
		getHibernateTemplate().delete(publishOrigin);
	}
	
	@SuppressWarnings("unchecked")
	public List<PublishOrigin> findList(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	public int maxRecords(String hql){
		return getHibernateTemplate().find(hql).size();
	}
}
