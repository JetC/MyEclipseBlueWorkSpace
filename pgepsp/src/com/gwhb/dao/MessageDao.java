package com.gwhb.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.gwhb.model.Message;

@Component("messageDao")
public class MessageDao {

	private HibernateTemplate hibernateTemplate;

	public Serializable save(Message message) {
		return hibernateTemplate.save(message);
	}

	public void update(Message message) {
		hibernateTemplate.update(message);
	}

	public void delete(Message message) {
		hibernateTemplate.delete(message);
	}

	public Message getById(int id) {
		return hibernateTemplate.get(Message.class, id);
	}

	public int count() {
		String hql = "select count(*) from com.gwhb.model.Message";
		return ((Long) hibernateTemplate.iterate(hql).next()).intValue();
	}

	public int count(String keyword) {
		String hql = "select count(*) from com.gwhb.model.Message m where m.content like ?";
		return ((Long) hibernateTemplate.iterate(hql, "%" + keyword + "%")
				.next()).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<Message> list(final int pageNum) {
		final String queryString = "from com.gwhb.model.Message m order by m.time desc";
		@SuppressWarnings("rawtypes")
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List result = session.createQuery(queryString).setFirstResult(
						pageNum * 10).setMaxResults(10).list();
				return result;
			}
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Message> list(final int pageNum, final String keyword) {
		final String queryString = "from com.gwhb.model.Message m where m.content like :content order by m.time desc";
		@SuppressWarnings("rawtypes")
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List result = session.createQuery(queryString).setString(
						"content", "%" + keyword + "%").setFirstResult(
						pageNum * 10).setMaxResults(10).list();
				return result;
			}
		});
		return list;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}