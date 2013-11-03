package com.gwhb.service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gwhb.dao.PictureDao;
import com.gwhb.model.Picture;
import com.gwhb.vo.PictureVo;

@Service("pictureService")
public class PictureService {

	private PictureDao pictureDao;

	public Serializable save(final PictureVo pictureVo) throws SQLException {
		return pictureDao.save(pictureVo);
	}

	public void delete(Picture picture) {
		pictureDao.delete(picture);
	}

	public byte[] getById(int id) {
		return pictureDao.getById(id);
	}

	public String getTypeById(int id) {
		return pictureDao.getTypeById(id);
	}

	public int count() {
		return pictureDao.count();
	}

	public int count(String keyword) {
		return pictureDao.count(keyword);
	}

	public List<Integer> list(int pageNum) {
		return pictureDao.list(pageNum);
	}

	public List<Integer> list(int pageNum, String keyword) {
		return pictureDao.list(pageNum, keyword);
	}

	public PictureDao getPictureDao() {
		return pictureDao;
	}

	@Resource
	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}

}