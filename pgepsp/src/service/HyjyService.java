package service;
import model.Hyjy;
import dao.*;
import java.util.List;
import tools.*;
public class HyjyService {
	HyjyDao dao;
	HyjyPageDao pagedao;
	public void setDao(HyjyDao dao){
		this.dao=dao;
	}
	public HyjyDao getDao(){
		return this.dao;
	}
	public void setPagedao(HyjyPageDao pagedao){
		this.pagedao=pagedao;
	}
	public HyjyPageDao getPagedao(){
		return this.pagedao;
	}
	//ID列表记录
	public List<Hyjy> selectAll() {
		String hql="from Hyjy order by id desc";
		return dao.findAll(hql);
	}
	//COUNT列表记录
	public List<Hyjy> selectAllByCount() {
		String hql="from Hyjy order by m_count desc";
		return dao.findAll(hql);
	}
	//查找所有分类
	public List<Hyjy> typeList(){
		String hql="select distinct m_type from Hyjy";
		return dao.findAll(hql);
	}
	//ID查找
	public Hyjy findFromId(int id) {
		return dao.find(id);
	}
	//查所有记录
	public int getRows(){
		String hql="from Hyjy";
		System.out.print("执行到Service层!\n");
		return dao.Records(hql);
	}
	
	//增加记录
	public int add(Hyjy h){
		System.out.print("执行到Service层!\n");
		return dao.save(h);
	}
	//删除记录
	public void delete(Hyjy h){
		System.out.print("执行到Service层!\n");
		dao.delete(h);
	}
	//更新记录
	public void update(Hyjy h){
		System.out.print("执行到Service层!\n");
		dao.update(h);
	}
	
	
	//分页初始化
	public Pager pageInitial(Pager pager,String method){
		pager.newPager(pager.getCurrentPage(),method,pager.getMaxRecords(),pager.getPageSize());
		return pager;
	}
	//按页显示
	public List<Hyjy> viewHdjyByList(int offset,int pageSize){
		String hql="from Hyjy order by id Desc";
		return pagedao.findByPage(hql, offset, pageSize);
	}
	//搜索统计
	public List<Hyjy> searchName(String keyword){
		String hql="from Hyjy where m_title like '%"+keyword+"%'"+" order by id Desc";
		return dao.findAll(hql);
	}
	public List<Hyjy> searchType(String keyword){
		String hql="from Hyjy where m_type like '%"+keyword+"%'"+" order by id Desc";
		return dao.findAll(hql);
	}
	public List<Hyjy> searchDetailList(String keyword){
		String hql="from Hyjy where m_detail like '%"+keyword+"%'"+" order by id Desc";
		return dao.findAll(hql);
	}
	//搜索结果分页
	public List<Hyjy> searchNameListByPage(int offset,int pageSize,String keyword){
		String hql="from Hyjy where m_title like '%"+keyword+"%'"+" order by id Desc";
		return pagedao.findByPage(hql, offset, pageSize);
	}
	public List<Hyjy> searchTypeListByPage(int offset,int pageSize,String keyword){
		String hql="from Hyjy where m_type like '%"+keyword+"%'"+" order by id Desc";
		return pagedao.findByPage(hql, offset, pageSize);
	}
	public List<Hyjy> searchDetailListByPage(int offset,int pageSize,String keyword){
		String hql="from Hyjy where m_detail like '%"+keyword+"%'"+" order by id Desc";
		return pagedao.findByPage(hql, offset, pageSize);
	}
}
