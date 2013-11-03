package com.gwhb.service;

import java.io.File;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gwhb.dao.VideoDao;
import com.gwhb.model.Video;
import com.gwhb.vo.VideoVo;

@Service("videoService")
public class VideoService {

	private VideoDao videoDao;

	public void saveVideo(VideoVo videoVo) {
		File video = videoVo.getVideo();
		System.out.println(video.getAbsolutePath());
		String ffmpegpath = "D:/ffmpeg-20130820-git-68b63a3-win32-static/bin/ffmpeg.exe";
		String videoRealPath = video.getAbsolutePath();
		String imageRealPath = video.getParent() + File.separator + "temp.jpg";
		List<String> commend = new ArrayList<String>();
		commend.add(ffmpegpath);
		commend.add("-i");
		commend.add(videoRealPath);
		commend.add("-y");
		commend.add("-f");
		commend.add("image2");
		commend.add("-ss");
		commend.add("0");
		commend.add("-t");
		commend.add("0.001");
		commend.add("-vframes");
		commend.add("1");
		commend.add(imageRealPath);
		try {
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commend);
			builder.start();
			videoVo.setPicture(new File(imageRealPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Serializable save(final VideoVo videoVo) throws SQLException {
		saveVideo(videoVo);
		Serializable id = videoDao.save(videoVo);
//		new Timer().schedule(new TimerTask() {
//
//			@Override
//			public void run() {
//				videoVo.getPicture().delete();
//			}
//
//		}, 60000);
		return id;
	}

	public void delete(Video video) {
		videoDao.delete(video);
	}

	public byte[] getVideoById(int id) {
		return videoDao.getVideoById(id);
	}

	public byte[] getPictureById(int id) {
		return videoDao.getPictureById(id);
	}

	public String getTypeById(int id) {
		return videoDao.getTypeById(id);
	}

	public int count() {
		return videoDao.count();
	}

	public int count(String keyword) {
		return videoDao.count(keyword);
	}

	public List<Integer> list(int pageNum) {
		return videoDao.list(pageNum);
	}

	public List<Integer> list(int pageNum, String keyword) {
		return videoDao.list(pageNum, keyword);
	}

	public VideoDao getVideoDao() {
		return videoDao;
	}

	@Resource
	public void setVideoDao(VideoDao videoDao) {
		this.videoDao = videoDao;
	}

}