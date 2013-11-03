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
	//存记录
	public int save(Picture p) {
		System.out.print("执行到图片添加的Dao层!\n");
		return (Integer)getHibernateTemplate().save(p);
	}
	//改记录
	public void update(Picture p) {
		getHibernateTemplate().update(p);
	}
	//删记录
	public void delete(Picture p) {
		getHibernateTemplate().delete(p);
	}
	//按ID找记录
	public Picture find(int id) {
		return getHibernateTemplate().get(Picture.class,id);
	}
	@SuppressWarnings("unchecked")
	//查找多个记录
	public List<Picture> findList(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	@SuppressWarnings("unchecked")
	//查找所有记录
	public List<Picture> findAll(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	//记录的总数
	public int Records(String hql){
		System.out.print("执行到Dao层!\n");		
		return getHibernateTemplate().find(hql).size();
	}
	public Picture findPicture(final String hql){
		Picture pic= (Picture)getHibernateTemplate()
		.execute(new HibernateCallback<Object>()
				{
					//实现HibernateCallback接口必须实现的方法
					public Object doInHibernate(Session session)
						throws HibernateException, SQLException
					{
						//执行Hibernate分页查询
						Query query = session.createQuery(hql);
						//为hql语句传入参数
						Object result = query.uniqueResult();
						return result;
					}
				});
		return pic;
}
}
