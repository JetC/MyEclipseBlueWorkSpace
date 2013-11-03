package dao;

import java.util.List;
import model.Hdjy;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HdjyDao extends HibernateDaoSupport{
	//���¼
	public int save(Hdjy h) {
		System.out.print("ִ�е�Dao��!\n");
		return (Integer)getHibernateTemplate().save(h);
	}
	//�ļ�¼
	public void update(Hdjy h) {
		getHibernateTemplate().update(h);
	}
	//ɾ��¼
	public void delete(Hdjy h) {
		getHibernateTemplate().delete(h);
	}
	//��ID�Ҽ�¼
	public Hdjy find(int id) {
		return getHibernateTemplate().get(Hdjy.class,id);
	}

	@SuppressWarnings("unchecked")
	//���Ҷ����¼
	public List<Hdjy> findList(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	@SuppressWarnings("unchecked")
	//�������м�¼
	public List<Hdjy> findAll(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	//��¼������
	public int Records(String hql){
		System.out.print("ִ�е�Dao��!\n");		
		return getHibernateTemplate().find(hql).size();
	}
	
}
