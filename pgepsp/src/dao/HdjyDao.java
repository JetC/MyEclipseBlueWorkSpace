package dao;

import java.util.List;
import model.Hdjy;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HdjyDao extends HibernateDaoSupport{
	//存记录
	public int save(Hdjy h) {
		System.out.print("执行到Dao层!\n");
		return (Integer)getHibernateTemplate().save(h);
	}
	//改记录
	public void update(Hdjy h) {
		getHibernateTemplate().update(h);
	}
	//删记录
	public void delete(Hdjy h) {
		getHibernateTemplate().delete(h);
	}
	//按ID找记录
	public Hdjy find(int id) {
		return getHibernateTemplate().get(Hdjy.class,id);
	}

	@SuppressWarnings("unchecked")
	//查找多个记录
	public List<Hdjy> findList(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	@SuppressWarnings("unchecked")
	//查找所有记录
	public List<Hdjy> findAll(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	//记录的总数
	public int Records(String hql){
		System.out.print("执行到Dao层!\n");		
		return getHibernateTemplate().find(hql).size();
	}
	
}
