package dao;

import java.util.List;
import model.Hbsy;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HbsyDao extends HibernateDaoSupport{
	//存记录
	public int save(Hbsy h) {
		System.out.print("执行到Dao层!\n");
		return (Integer)getHibernateTemplate().save(h);
	}
	//改记录
	public void update(Hbsy h) {
		getHibernateTemplate().update(h);
	}
	//删记录
	public void delete(Hbsy h) {
		getHibernateTemplate().delete(h);
	}
	//按ID找记录
	public Hbsy find(int id) {
		return getHibernateTemplate().get(Hbsy.class,id);
	}

	@SuppressWarnings("unchecked")
	//查找多个记录
	public List<Hbsy> findList(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	@SuppressWarnings("unchecked")
	//查找所有记录
	public List<Hbsy> findAll(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	//记录的总数
	public int Records(String hql){
		System.out.print("执行到Dao层!\n");		
		return getHibernateTemplate().find(hql).size();
	}
	
}
