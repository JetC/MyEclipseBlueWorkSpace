package action;

import java.util.List;

import model.Hbsy;
import model.Hdjy;
import model.Hyjy;
import model.PublishRead;

import service.HbsyService;
import service.HdjyService;
import service.HyjyService;
import service.PublishService;

import com.gwhb.service.PictureService;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport{
	
	// 备份序列号
	private static final long serialVersionUID = 6698532003052877465L;
	
	//依赖注入块
	public PublishService pubSer;
	public HbsyService hbsSer;
	public HdjyService hdjSer;
	public HyjyService hyjSer;
	public PictureService picSer;
	
	public void setPubSer(PublishService pubSer) {
		this.pubSer = pubSer;
	}

	public void setHbsSer(HbsyService hbsSer) {
		this.hbsSer = hbsSer;
	}

	public void setHdjSer(HdjyService hdjSer) {
		this.hdjSer = hdjSer;
	}

	public void setHyjSer(HyjyService hyjSer) {
		this.hyjSer = hyjSer;
	}

	public void setPicSer(PictureService picSer) {
		this.picSer = picSer;
	}

	//与视图间传值
	public List<PublishRead> pubReaList;
	public List<Hbsy> hbsList;
	public List<Hdjy> hdjList;
	public List<Hyjy> hyjList;
	public Hyjy hyj;
	
	public List<PublishRead> getPubReaList() {
		return pubReaList;
	}

	public void setPubReaList(List<PublishRead> pubReaList) {
		this.pubReaList = pubReaList;
	}

	public List<Hbsy> getHbsList() {
		return hbsList;
	}

	public void setHbsList(List<Hbsy> hbsList) {
		this.hbsList = hbsList;
	}

	public List<Hdjy> getHdjList() {
		return hdjList;
	}

	public void setHdjList(List<Hdjy> hdjList) {
		this.hdjList = hdjList;
	}

	public List<Hyjy> getHyjList() {
		return hyjList;
	}

	public void setHyjList(List<Hyjy> hyjList) {
		this.hyjList = hyjList;
	}

	public Hyjy getHyj() {
		return hyj;
	}

	public void setHyj(Hyjy hyj) {
		this.hyj = hyj;
	}

	//主方法
	public String execute(){
		pubReaList=pubSer.viewPrByList(0,6);
		hbsList=hbsSer.viewHbsyByList(0, 6);
		hdjList=hdjSer.viewHdjyByList(0, 8);
		hyjList=hyjSer.viewHdjyByList(0, 3);
		hyj=new Hyjy();
		hyj=hyjSer.viewHdjyByList(0, 1).get(0);
		return "home";
	}
}
