package dao;

import java.util.List;
import model.Hbsy;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HbsyDao extends HibernateDaoSupport{
	//���¼
	public int save(Hbsy h) {
		System.out.print("ִ�е�Dao��!\n");
		return (Integer)getHibernateTemplate().save(h);
	}
	//�ļ�¼
	public void update(Hbsy h) {
		getHibernateTemplate().update(h);
	}
	//ɾ��¼
	public void delete(Hbsy h) {
		getHibernateTemplate().delete(h);
	}
	//��ID�Ҽ�¼
	public Hbsy find(int id) {
		return getHibernateTemplate().get(Hbsy.class,id);
	}

	@SuppressWarnings("unchecked")
	//���Ҷ����¼
	public List<Hbsy> findList(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	@SuppressWarnings("unchecked")
	//�������м�¼
	public List<Hbsy> findAll(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	//��¼������
	public int Records(String hql){
		System.out.print("ִ�е�Dao��!\n");		
		return getHibernateTemplate().find(hql).size();
	}
	
}
