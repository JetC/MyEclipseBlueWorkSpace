package dao;

import java.util.List;
import model.Hyjy;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HyjyDao extends HibernateDaoSupport{
	//存记录
	public int save(Hyjy h) {
		System.out.print("执行到Dao层!\n");
		return (Integer)getHibernateTemplate().save(h);
	}
	//改记录
	public void update(Hyjy h) {
		getHibernateTemplate().update(h);
	}
	//删记录
	public void delete(Hyjy h) {
		getHibernateTemplate().delete(h);
	}
	//按ID找记录
	public Hyjy find(int id) {
		return getHibernateTemplate().get(Hyjy.class,id);
	}

	@SuppressWarnings("unchecked")
	//查找多个记录
	public List<Hyjy> findList(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	@SuppressWarnings("unchecked")
	//查找所有记录
	public List<Hyjy> findAll(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	//记录的总数
	public int Records(String hql){
		System.out.print("执行到Dao层!\n");		
		return getHibernateTemplate().find(hql).size();
	}
	
}
