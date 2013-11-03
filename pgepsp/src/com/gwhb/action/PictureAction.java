package com.gwhb.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gwhb.model.Picture;
import com.gwhb.service.PictureService;
import com.gwhb.vo.PictureVo;
import com.opensymphony.xwork2.ActionSupport;

@Component("pictureAction")
@Scope("prototype")
public class PictureAction extends ActionSupport {

	private static final long serialVersionUID = 1124990390592191109L;
	private PictureService pictureService;
	private PictureVo pictureVo=new PictureVo();
	private List<Picture> pictures;

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
		
		pictureService.save(pictureVo);
		return SUCCESS;
	}

	public String get() throws Exception {
		request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		byte[] b = pictureService.getById(id);
		String fileType = pictureService.getTypeById(id);
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
			count = pictureService.count();
		} else {
			count = pictureService.count(keyword);
		}
		if (pageNum < 0) {
			pageNum = 0;
		} else if (pageNum > (count - 1) / 10) {
			pageNum = (count - 1) / 10;
		}
		List<Integer> ids;
		if (keyword == null || keyword.trim().equals("")) {
			ids = pictureService.list(pageNum);
		} else {
			ids = pictureService.list(pageNum, keyword);
		}
		request.setAttribute("ids", ids);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("keyword", keyword);
		request.setAttribute("count", count);
		return SUCCESS;
	}

	public PictureService getPictureService() {
		return pictureService;
	}

	@Resource
	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	public PictureVo getPictureVo() {
		return pictureVo;
	}

	public void setPictureVo(PictureVo pictureVo) {
		this.pictureVo = pictureVo;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

}