package dao;

import java.util.List;
import model.PublishRead;
import tools.YeekuHibernateDaoSupport;

public class PublishReadDao extends YeekuHibernateDaoSupport<PublishRead> {
	public int save(PublishRead publishRead) {
		return (Integer)getHibernateTemplate().save(publishRead);
	}
	
	public PublishRead find(int id) {
		return getHibernateTemplate().get(PublishRead.class,id);
	}

	public void update(PublishRead publishRead) {
		getHibernateTemplate().update(publishRead);
	}
	
	public void delete(PublishRead publishRead) {
		getHibernateTemplate().delete(publishRead);
	}
	
	@SuppressWarnings("unchecked")
	public List<PublishRead> findList(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	public int maxRecords(String hql){
		return getHibernateTemplate().find(hql).size();
	}
}
