package service;
import model.Hdjy;
import dao.*;
import java.util.List;
import tools.*;
public class HdjyService {
	HdjyDao dao;
	HdjyPageDao pagedao;
	public void setDao(HdjyDao dao){
		this.dao=dao;
	}
	public HdjyDao getDao(){
		return this.dao;
	}
	public void setPagedao(HdjyPageDao pagedao){
		this.pagedao=pagedao;
	}
	public HdjyPageDao getPagedao(){
		return this.pagedao;
	}
	//ID列表记录
	public List<Hdjy> selectAll() {
		String hql="from Hdjy order by id desc";
		return dao.findAll(hql);
	}
	//COUNT列表记录
	public List<Hdjy> selectAllByCount() {
		String hql="from Hdjy order by a_count desc";
		return dao.findAll(hql);
	}
	//查找所有分类
	public List<Hdjy> typeList(){
		String hql="select distinct a_type from Hdjy";
		return dao.findAll(hql);
	}
	//ID查找
	public Hdjy findFromId(int id) {
		return dao.find(id);
	}
	//查所有记录
	public int getRows(){
		String hql="from Hdjy";
		System.out.print("执行到Service层!\n");
		return dao.Records(hql);
	}
	
	//增加记录
	public int add(Hdjy h){
		System.out.print("执行到Service层!\n");
		return dao.save(h);
	}
	//删除记录
	public void delete(Hdjy h){
		System.out.print("执行到Service层!\n");
		dao.delete(h);
	}
	//更新记录
	public void update(Hdjy h){
		System.out.print("执行到Service层!\n");
		dao.update(h);
	}
	
	
	//分页初始化
	public Pager pageInitial(Pager pager,String method){
		pager.newPager(pager.getCurrentPage(),method,pager.getMaxRecords(),pager.getPageSize());
		return pager;
	}
	//按页显示
	public List<Hdjy> viewHdjyByList(int offset,int pageSize){
		String hql="from Hdjy order by id Desc";
		return pagedao.findByPage(hql, offset, pageSize);
	}
	//搜索统计
	public List<Hdjy> searchName(String keyword){
		String hql="from Hdjy where a_title like '%"+keyword+"%'"+" order by id Desc";
		return dao.findAll(hql);
	}
	public List<Hdjy> searchType(String keyword){
		String hql="from Hdjy where a_type like '%"+keyword+"%'"+" order by id Desc";
		return dao.findAll(hql);
	}
	public List<Hdjy> searchDetailList(String keyword){
		String hql="from Hdjy where a_detail like '%"+keyword+"%'"+" order by id Desc";
		return dao.findAll(hql);
	}
	//搜索结果分页
	public List<Hdjy> searchNameListByPage(int offset,int pageSize,String keyword){
		String hql="from Hdjy where a_title like '%"+keyword+"%'"+" order by id Desc";
		return pagedao.findByPage(hql, offset, pageSize);
	}
	public List<Hdjy> searchTypeListByPage(int offset,int pageSize,String keyword){
		String hql="from Hdjy where a_type like '%"+keyword+"%'"+" order by id Desc";
		return pagedao.findByPage(hql, offset, pageSize);
	}
	public List<Hdjy> searchDetailListByPage(int offset,int pageSize,String keyword){
		String hql="from Hdjy where a_detail like '%"+keyword+"%'"+" order by id Desc";
		return pagedao.findByPage(hql, offset, pageSize);
	}
}
