package com.gwhb.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;

import oracle.sql.BLOB;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.gwhb.model.Picture;
import com.gwhb.vo.PictureVo;

@Component("pictureDao")
public class PictureDao {

	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	public Serializable save(final PictureVo pictureVo) throws SQLException {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		Picture picture = new Picture();
		picture.setP_title(pictureVo.getTitle());
		picture.setP_describe(pictureVo.getDescribe());
		picture.setP_place(pictureVo.getPlace());
		picture.setPerson(pictureVo.getPerson());
		picture.setP_type(pictureVo.getType());
		picture.setP_extension(pictureVo.getPictureContentType());
		picture.setP_picture(BLOB.getEmptyBLOB());
		// FileInputStream fis = new FileInputStream(pictureVo.getPicture());
		// picture.setPicture(Hibernate.createBlob(fis));
		Serializable id = session.save(picture);
		session.getTransaction().commit();
		session.close();

		System.err.println("id=" + id);

		final String querysql = "select p_picture from db_picture where id = "
				+ id + " for update";

		System.err.println("sqlquery=" + querysql);

		hibernateTemplate.execute(new HibernateCallback() {

			@SuppressWarnings("deprecation")
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				System.err.println("start callback");
				Connection con = session.connection();
				con.setAutoCommit(false);
				Statement st = con.createStatement();
				// 用 for update 方式锁定数据行
				ResultSet rs = st.executeQuery(querysql);
				try {
					if (rs.next()) {
						System.err.println("have resultset");
						// 得到java.sql.blob 对象
						BLOB blob = (BLOB) rs.getBlob(1);
						// 得到数据库的输出流
						OutputStream outStream = blob.getBinaryOutputStream();
						// 这里用一个文件模拟输入流.
						System.err.println("name="
								+ pictureVo.getPicture().getName());
						System.err.println("length="
								+ pictureVo.getPicture().length());
						InputStream inStream = new FileInputStream(pictureVo
								.getPicture());
						// 将输入流写到输出流
						byte[] b = new byte[blob.getBufferSize()];
						int len = 0;
						while ((len = inStream.read(b)) != -1) {
							System.err.println("len=" + len);
							outStream.write(b, 0, len);
						}
						inStream.close();
						outStream.flush();
						outStream.close();
						con.commit();// 之前因为没有commit 所以blob一直不能写入数据库中
						con.close();
					} else {
						System.err.println("without resultset");
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}

		});

		return id;
	}

	public void delete(Picture picture) {
		hibernateTemplate.delete(picture);
	}

	@SuppressWarnings("unchecked")
	public byte[] getById(int id) {
		final String querysql = "select p_picture from db_picture where id = "
				+ id + " for update";

		System.err.println("sqlquery=" + querysql);

		return hibernateTemplate.execute(new HibernateCallback() {

			@SuppressWarnings("deprecation")
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				System.err.println("start callback");
				Connection con = session.connection();
				con.setAutoCommit(false);
				Statement st = con.createStatement();
				// 用 for update 方式锁定数据行
				ResultSet rs = st.executeQuery(querysql);
				byte[] b = null;
				try {
					if (rs.next()) {
						System.err.println("have resultset");
						BLOB blob = (BLOB) rs.getBlob(1);
						InputStream inStream = blob.getBinaryStream();
						b = new byte[(int) blob.length()];
						inStream.read(b);
						inStream.close();
						con.commit();// 之前因为没有commit 所以blob一直不能写入数据库中
						con.close();
					} else {
						System.err.println("without resultset");
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return b;
			}

		});
	}

	public String getTypeById(Integer id) {
		String hql = "select p.extension from com.gwhb.model.Picture p where p.id = ?";
		return (String) hibernateTemplate.iterate(hql, id).next();
	}

	public int count() {
		String hql = "select count(*) from com.gwhb.model.Picture";
		return ((Long) hibernateTemplate.iterate(hql).next()).intValue();
	}

	public int count(String keyword) {
		String hql = "select count(*) from com.gwhb.model.Picture p where p.describe like ?";
		return ((Long) hibernateTemplate.iterate(hql, "%" + keyword + "%")
				.next()).intValue();
	}

	public List<Picture> list() {
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Integer> list(final int pageNum) {
		final String queryString = "select p.id from com.gwhb.model.Picture p";
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
	public List<Integer> list(final int pageNum, final String keyword) {
		final String queryString = "select p.id from com.gwhb.model.Picture p where p.describe like :describe";
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List result = session.createQuery(queryString).setString(
						"describe", "%" + keyword + "%").setFirstResult(
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