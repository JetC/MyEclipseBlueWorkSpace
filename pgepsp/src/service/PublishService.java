package service;
import java.util.List;

import tools.Pager;

import dao.*;
import model.*;
public class PublishService {
	//--这是依赖注入块
	public PictureDao picDao;
	public PublishClassDao pubClaDao;
	public PublishOriginDao pubOriDao;
	public PublishReadDao pubReaDao;
	public void setPicDao(PictureDao picDao) {
		this.picDao = picDao;
	}
	public void setPubClaDao(PublishClassDao pubClaDao) {
		this.pubClaDao = pubClaDao;
	}
	public void setPubOriDao(PublishOriginDao pubOriDao) {
		this.pubOriDao = pubOriDao;
	}
	public void setPubReaDao(PublishReadDao pubReaDao) {
		this.pubReaDao = pubReaDao;
	}

	
	
	//--pc 文章类别增查删改
	public PublishClass findPc(int id){
		return pubClaDao.find(id);
	}
	public int addPc(PublishClass publishClass){
		if(!publishClass.getPc_name().equals("")){
		return pubClaDao.save(publishClass);}
		else{return 0;}
	}
	public List<PublishClass> viewPc(){
		String hql="from PublishClass order by id Desc";
		return pubClaDao.findList(hql);
	}
	public void deletePc(PublishClass publishClass){
		pubClaDao.delete(publishClass);
	}
	public void updatePc(PublishClass publishClass)
	{
		if(!publishClass.getPc_name().equals("")){
		pubClaDao.update(publishClass);}
	}

	
	//--po 文章来源增查删改
	public PublishOrigin findPo(int id){
		return pubOriDao.find(id);
	}
	public int addPo(PublishOrigin publishOrigin){
		if(!publishOrigin.getPo_name().equals("")){
		return pubOriDao.save(publishOrigin);}
		else{return 0;}
	}
	public List<PublishOrigin> viewPo(){
		String hql="from PublishOrigin order by id Desc";
		return pubOriDao.findList(hql);
	}
	public void deletePo(PublishOrigin publishOrigin){
		pubOriDao.delete(publishOrigin);
	}
	public void updatePo(PublishOrigin publishOrigin){
		if(!publishOrigin.getPo_name().equals("")){
		pubOriDao.update(publishOrigin);}
	}

	
	//--pr 导读文章增查删改
	public PublishRead findPr(int id){
		return pubReaDao.find(id);
	}
	public int addPr(PublishRead publishRead){
		if(!(publishRead.getP_title().trim().equals("")||publishRead.getP_preread().trim().equals("")||
				publishRead.getP_detail().trim().equals("")||publishRead.getP_link().trim().equals(""))){
		return pubReaDao.save(publishRead);}
		else{
			return 0;
		}
	}
	public List<PublishRead> viewPr(){
		String hql="from PublishRead order by p_addtime Desc";
		return pubReaDao.findList(hql);
	}
	public void deletePr(PublishRead publishRead){
		pubReaDao.delete(publishRead);
	}
	public void updatePr(PublishRead publishRead){
		if(!(publishRead.getP_title().equals("")||publishRead.getP_preread().equals("")||
				publishRead.getP_detail().equals("")||publishRead.getP_link().equals(""))){
		pubReaDao.update(publishRead);}
	}
	public List<PublishRead> viewPrByList(int offset,int pageSize){
		String hql="from PublishRead order by p_addtime Desc";
		return pubReaDao.findByPage(hql, offset, pageSize);
	}
	
	
	//按文章标题搜索
	public List<PublishRead> research(String key){
		String hql="from PublishRead where p_title like '%"+key+"%'"+" order by p_addtime Desc";
		return pubReaDao.findList(hql);
	}
	public List<PublishRead> researchViewPrByList(int offset,int pageSize,String key){
		String hql="from PublishRead where p_title like '%"+key+"%'"+" order by p_addtime Desc";
		return pubReaDao.findByPage(hql, offset, pageSize);
	}
	
	//按文章的类别搜索
	public List<PublishRead> classResearch(String key){
		String hql="from PublishRead where p_type ='"+key+"'"+" order by p_addtime Desc";
		return pubReaDao.findList(hql);
	}
	public List<PublishRead> classResearchViewPrByList(int offset,int pageSize,String key){
		String hql="from PublishRead where p_type ='"+key+"'"+" order by p_addtime Desc";
		return pubReaDao.findByPage(hql, offset, pageSize);
	}
	
	//按文章的来源搜索
	public List<PublishRead> originResearch(String key){
		String hql="from PublishRead where p_from ='"+key+"'"+" order by p_addtime Desc";
		return pubReaDao.findList(hql);
	}
	public List<PublishRead> originResearchViewPrByList(int offset,int pageSize,String key){
		String hql="from PublishRead where p_from ='"+key+"'"+" order by p_addtime Desc";
		return pubReaDao.findByPage(hql, offset, pageSize);
	}
	
	//进行分页的初始化
	public Pager pageInitial(Pager pager,String method){
		pager.newPager(pager.getCurrentPage(),method,pager.getMaxRecords(),pager.getPageSize());
		return pager;
	}
	
}
