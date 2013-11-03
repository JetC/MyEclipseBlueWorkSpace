package dao;

import java.util.List;
import model.Statistics;
import tools.YeekuHibernateDaoSupport;

public class StatisticsDao extends YeekuHibernateDaoSupport<Statistics>{
	public int save(Statistics statistics) {
		return (Integer)getHibernateTemplate().save(statistics);
	}
	
	public Statistics find(int id) {
		return getHibernateTemplate().get(Statistics.class,id);
	}

	public void update(Statistics statistics) {
		getHibernateTemplate().update(statistics);
	}
	
	public void delete(Statistics statistics) {
		getHibernateTemplate().delete(statistics);
	}
	
	public void deleteList(List<Statistics> list){
		getHibernateTemplate().deleteAll(list);
	}
	@SuppressWarnings("unchecked")
	public List<Statistics> findList(String hql) {
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
