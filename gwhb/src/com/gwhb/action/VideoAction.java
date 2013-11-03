package com.gwhb.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gwhb.model.Video;
import com.gwhb.service.VideoService;
import com.gwhb.vo.VideoVo;
import com.opensymphony.xwork2.ActionSupport;

@Component("videoAction")
@Scope("prototype")
public class VideoAction extends ActionSupport {

	private static final long serialVersionUID = 1124990390592191109L;
	private VideoService videoService;
	private VideoVo videoVo;
	private List<Video> videos;

	private HttpServletRequest request;

	// private HttpSession session;
	// private ServletContext application;

	public String save() throws Exception {
		// request = ServletActionContext.getRequest();
		// request获得方式
		// session = request.getSession();
		// session获得方式
		// application = ServletActionContext.getServletContext();
		// application获得方式
		videoService.save(videoVo);
		return SUCCESS;
	}

	public String preview() throws Exception {
		request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		byte[] b = videoService.getPictureById(id);
		String fileType = videoService.getTypeById(id);
		System.err.println("length=" + b.length);
		request.setAttribute("bs", b);
		request.setAttribute("fileType", fileType);
		return SUCCESS;
	}

	public String get() throws Exception {
		request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		byte[] b = videoService.getVideoById(id);
		String fileType = videoService.getTypeById(id);
		System.err.println("length=" + b.length);
		request.setAttribute("bs", b);
		request.setAttribute("fileType", fileType);
		return SUCCESS;
	}

	public String list() throws Exception {
		request = ServletActionContext.getRequest();
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		String keyword = request.getParameter("keyword");
		int count;
		if (keyword == null || keyword.trim().equals("")) {
			count = videoService.count();
		} else {
			count = videoService.count(keyword);
		}
		if (pageNum < 0) {
			pageNum = 0;
		} else if (pageNum > (count - 1) / 10) {
			pageNum = (count - 1) / 10;
		}
		List<Integer> ids;
		if (keyword == null || keyword.trim().equals("")) {
			ids = videoService.list(pageNum);
		} else {
			ids = videoService.list(pageNum, keyword);
		}
		request.setAttribute("ids", ids);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("keyword", keyword);
		request.setAttribute("count", count);
		return SUCCESS;
	}

	public VideoService getVideoService() {
		return videoService;
	}

	@Resource
	public void setVideoService(VideoService videoService) {
		this.videoService = videoService;
	}

	public VideoVo getVideoVo() {
		return videoVo;
	}

	public void setVideoVo(VideoVo videoVo) {
		this.videoVo = videoVo;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

}