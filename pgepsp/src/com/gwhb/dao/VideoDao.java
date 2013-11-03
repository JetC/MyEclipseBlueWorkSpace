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

import com.gwhb.model.Video;
import com.gwhb.vo.VideoVo;

@Component("videoDao")
public class VideoDao {

	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Serializable save(final VideoVo videoVo) throws SQLException {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		Video video = new Video();
		video.setTitle(videoVo.getTitle());
		video.setDescribe(videoVo.getDescribe());
		video.setPlace(videoVo.getPlace());
		video.setPerson(videoVo.getPerson());
		video.setType(videoVo.getType());
		video.setExtension(videoVo.getVideoContentType());
		video.setVideo(BLOB.getEmptyBLOB());
		video.setPicture(BLOB.getEmptyBLOB());
		Serializable id = session.save(video);
		session.getTransaction().commit();
		session.close();

		System.err.println("id=" + id);

		final String querysql = "select v_video, v_picture from db_video where id = "
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
				// 鐢�for update 鏂瑰紡閿佸畾鏁版嵁琛�
				ResultSet rs = st.executeQuery(querysql);
				try {
					if (rs.next()) {
						System.err.println("have resultset");
						// 寰楀埌java.sql.blob 瀵硅薄
						BLOB video = (BLOB) rs.getBlob("v_video");
						// 寰楀埌鏁版嵁搴撶殑杈撳嚭娴�
						OutputStream outStream = video.getBinaryOutputStream();
						// 杩欓噷鐢ㄤ竴涓枃浠舵ā鎷熻緭鍏ユ祦.
						System.err.println("name="
								+ videoVo.getVideo().getName());
						System.err.println("length="
								+ videoVo.getVideo().length());
						InputStream inStream = new FileInputStream(videoVo
								.getVideo());
						// 灏嗚緭鍏ユ祦鍐欏埌杈撳嚭娴�
						byte[] b = new byte[video.getBufferSize()];
						int len = 0;
						while ((len = inStream.read(b)) != -1) {
							System.err.println("len=" + len);
							outStream.write(b, 0, len);
						}
						inStream.close();
						outStream.flush();
						outStream.close();

						BLOB picture = (BLOB) rs.getBlob("v_picture");
						// 寰楀埌鏁版嵁搴撶殑杈撳嚭娴�
						outStream = picture.getBinaryOutputStream();
						// 杩欓噷鐢ㄤ竴涓枃浠舵ā鎷熻緭鍏ユ祦.
						System.err.println("name="
								+ videoVo.getPicture().getName());
						System.err.println("length="
								+ videoVo.getPicture().length());
						inStream = new FileInputStream(videoVo.getPicture());
						// 灏嗚緭鍏ユ祦鍐欏埌杈撳嚭娴�
						b = new byte[picture.getBufferSize()];
						len = 0;
						while ((len = inStream.read(b)) != -1) {
							System.err.println("len=" + len);
							outStream.write(b, 0, len);
						}
						inStream.close();
						outStream.flush();
						outStream.close();
						con.commit();// 涔嬪墠鍥犱负娌℃湁commit 鎵�互blob涓�洿涓嶈兘鍐欏叆鏁版嵁搴撲腑
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

	public void delete(Video video) {
		hibernateTemplate.delete(video);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public byte[] getPictureById(int id) {
		final String querysql = "select v_picture from db_video where id = "
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
				// 鐢�for update 鏂瑰紡閿佸畾鏁版嵁琛�
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
						con.commit();// 涔嬪墠鍥犱负娌℃湁commit 鎵�互blob涓�洿涓嶈兘鍐欏叆鏁版嵁搴撲腑
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public byte[] getVideoById(int id) {
		final String querysql = "select v_video from db_video where id = " + id
				+ " for update";

		System.err.println("sqlquery=" + querysql);

		return hibernateTemplate.execute(new HibernateCallback() {

			@SuppressWarnings("deprecation")
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				System.err.println("start callback");
				Connection con = session.connection();
				con.setAutoCommit(false);
				Statement st = con.createStatement();
				// 鐢�for update 鏂瑰紡閿佸畾鏁版嵁琛�
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
						con.commit();// 涔嬪墠鍥犱负娌℃湁commit 鎵�互blob涓�洿涓嶈兘鍐欏叆鏁版嵁搴撲腑
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
		String hql = "select v.extension from com.gwhb.model.Video v where v.id = ?";
		return (String) hibernateTemplate.iterate(hql, id).next();
	}

	public int count() {
		String hql = "select count(*) from com.gwhb.model.Video";
		return ((Long) hibernateTemplate.iterate(hql).next()).intValue();
	}

	public int count(String keyword) {
		String hql = "select count(*) from com.gwhb.model.Video v where v.describe like ?";
		return ((Long) hibernateTemplate.iterate(hql, "%" + keyword + "%")
				.next()).intValue();
	}

	public List<Video> list() {
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Integer> list(final int pageNum) {
		final String queryString = "select v.id from com.gwhb.model.Video v";
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
	public List<Integer> list(final int pageNum, final String keyword) {
		final String queryString = "select v.id from com.gwhb.model.Video v where v.describe like :describe";
		@SuppressWarnings("rawtypes")
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