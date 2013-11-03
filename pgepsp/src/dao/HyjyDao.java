package dao;

import java.util.List;
import model.Hyjy;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HyjyDao extends HibernateDaoSupport{
	//���¼
	public int save(Hyjy h) {
		System.out.print("ִ�е�Dao��!\n");
		return (Integer)getHibernateTemplate().save(h);
	}
	//�ļ�¼
	public void update(Hyjy h) {
		getHibernateTemplate().update(h);
	}
	//ɾ��¼
	public void delete(Hyjy h) {
		getHibernateTemplate().delete(h);
	}
	//��ID�Ҽ�¼
	public Hyjy find(int id) {
		return getHibernateTemplate().get(Hyjy.class,id);
	}

	@SuppressWarnings("unchecked")
	//���Ҷ����¼
	public List<Hyjy> findList(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	@SuppressWarnings("unchecked")
	//�������м�¼
	public List<Hyjy> findAll(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	//��¼������
	public int Records(String hql){
		System.out.print("ִ�е�Dao��!\n");		
		return getHibernateTemplate().find(hql).size();
	}
	
}
