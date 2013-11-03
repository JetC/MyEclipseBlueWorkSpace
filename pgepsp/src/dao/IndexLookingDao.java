package dao;

import java.util.List;

import tools.YeekuHibernateDaoSupport;

import model.IndexLooking;

public class IndexLookingDao extends YeekuHibernateDaoSupport<IndexLooking>{
	public int save(IndexLooking indexLooking) {
		return (Integer)getHibernateTemplate().save(indexLooking);
	}
	
	public IndexLooking find(int id) {
		return getHibernateTemplate().get(IndexLooking.class,id);
	}

	public void update(IndexLooking indexLooking) {
		getHibernateTemplate().update(indexLooking);
	}
	
	public void delete(IndexLooking indexLooking) {
		getHibernateTemplate().delete(indexLooking);
	}
	
	public void deleteList(List<IndexLooking> list){
		getHibernateTemplate().deleteAll(list);
	}
	
	@SuppressWarnings("unchecked")
	public List<IndexLooking> findList(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	public int countRecords(String hql){
		return getHibernateTemplate().find(hql).size();
	}
	
	@SuppressWarnings("rawtypes")
	public List find(String hql) {
		return getHibernateTemplate().find(hql);
	}

}
