package dao;
import java.sql.SQLException;
import java.util.List;
import model.Picture;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PictureDao extends HibernateDaoSupport{
	//���¼
	public int save(Picture p) {
		System.out.print("ִ�е�ͼƬ��ӵ�Dao��!\n");
		return (Integer)getHibernateTemplate().save(p);
	}
	//�ļ�¼
	public void update(Picture p) {
		getHibernateTemplate().update(p);
	}
	//ɾ��¼
	public void delete(Picture p) {
		getHibernateTemplate().delete(p);
	}
	//��ID�Ҽ�¼
	public Picture find(int id) {
		return getHibernateTemplate().get(Picture.class,id);
	}
	@SuppressWarnings("unchecked")
	//���Ҷ����¼
	public List<Picture> findList(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	@SuppressWarnings("unchecked")
	//�������м�¼
	public List<Picture> findAll(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	//��¼������
	public int Records(String hql){
		System.out.print("ִ�е�Dao��!\n");		
		return getHibernateTemplate().find(hql).size();
	}
	public Picture findPicture(final String hql){
		Picture pic= (Picture)getHibernateTemplate()
		.execute(new HibernateCallback<Object>()
				{
					//ʵ��HibernateCallback�ӿڱ���ʵ�ֵķ���
					public Object doInHibernate(Session session)
						throws HibernateException, SQLException
					{
						//ִ��Hibernate��ҳ��ѯ
						Query query = session.createQuery(hql);
						//Ϊhql��䴫�����
						Object result = query.uniqueResult();
						return result;
					}
				});
		return pic;
}
}
