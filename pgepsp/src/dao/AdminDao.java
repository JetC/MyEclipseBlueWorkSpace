package dao;

import java.util.List;
import model.Admin;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AdminDao extends HibernateDaoSupport{
	//���¼
	public int save(Admin h) {
		System.out.print("ִ�е�Dao��!\n");
		return (Integer)getHibernateTemplate().save(h);
	}
	//�ļ�¼
	public void update(Admin h) {
		getHibernateTemplate().update(h);
	}
	//ɾ��¼
	public void delete(Admin h) {
		getHibernateTemplate().delete(h);
	}
	//��ID�Ҽ�¼
	public Admin find(int id) {
		return getHibernateTemplate().get(Admin.class,id);
	}
	//�����Ʋ���
	
	public Admin findName(String hql) {
		System.out.println("���е���̨����DAO��!");
		@SuppressWarnings("unchecked")
		List<Admin> l=getHibernateTemplate().find(hql);
		System.out.println("��ѯ���");
		if(l.size()==0){
			return null;
		}
		else{
		Admin h = new Admin();
		h.setA_name(l.get(0).getA_name());
		h.setA_password(l.get(0).getA_password());
		h.setA_super(l.get(0).getA_super());
		h.setA_username(l.get(0).getA_username());
		return h;}
	}
	@SuppressWarnings("unchecked")
	//���Ҷ����¼
	public List<Admin> findList(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	@SuppressWarnings("unchecked")
	//�������м�¼
	public List<Admin> findAll(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	//��¼������
	public int Records(String hql){
		System.out.print("ִ�е�Dao��!\n");		
		return getHibernateTemplate().find(hql).size();
	}
	
}