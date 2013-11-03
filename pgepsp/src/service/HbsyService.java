package service;
import model.Hbsy;
import dao.*;
import java.util.List;
import tools.*;
public class HbsyService {
	HbsyDao dao;
	HbsyPageDao pagedao;
	public void setDao(HbsyDao dao){
		this.dao=dao;
	}
	public HbsyDao getDao(){
		return this.dao;
	}
	public void setPagedao(HbsyPageDao pagedao){
		this.pagedao=pagedao;
	}
	public HbsyPageDao getPagedao(){
		return this.pagedao;
	}
	//ID列表记录
	public List<Hbsy> selectAll() {
		String hql="from Hbsy order by id desc";
		return dao.findAll(hql);
	}
	//COUNT列表记录
	public List<Hbsy> selectAllByCount() {
		String hql="from Hbsy order by e_count desc";
		return dao.findAll(hql);
	}
	//查找所有分类
	public List<Hbsy> typeList(){
		String hql="select distinct e_type from Hbsy";
		return dao.findAll(hql);
	}
	//ID查找
	public Hbsy findFromId(int id) {
		return dao.find(id);
	}
	//查所有记录
	public int getRows(){
		String hql="from Hbsy";
		System.out.print("执行到Service层!\n");
		return dao.Records(hql);
	}
	
	//增加记录
	public int add(Hbsy h){
		System.out.print("执行到Service层!\n");
		return dao.save(h);
	}
	//删除记录
	public void delete(Hbsy h){
		System.out.print("执行到Service层!\n");
		dao.delete(h);
	}
	//更新记录
	public void update(Hbsy h){
		System.out.print("执行到Service层!\n");
		dao.update(h);
	}
	
	
	//分页初始化
	public Pager pageInitial(Pager pager,String method){
		pager.newPager(pager.getCurrentPage(),method,pager.getMaxRecords(),pager.getPageSize());
		return pager;
	}
	//按页显示
	public List<Hbsy> viewHbsyByList(int offset,int pageSize){
		String hql="from Hbsy order by id Desc";
		return pagedao.findByPage(hql, offset, pageSize);
	}
	//搜索统计
	public List<Hbsy> searchName(String keyword){
		String hql="from Hbsy where e_name like '%"+keyword+"%'"+" order by id Desc";
		return dao.findAll(hql);
	}
	public List<Hbsy> searchType(String keyword){
		String hql="from Hbsy where e_type like '%"+keyword+"%'"+" order by id Desc";
		return dao.findAll(hql);
	}
	public List<Hbsy> searchDetailList(String keyword){
		String hql="from Hbsy where e_detail like '%"+keyword+"%'"+" order by id Desc";
		return dao.findAll(hql);
	}
	//搜索结果分页
	public List<Hbsy> searchNameListByPage(int offset,int pageSize,String keyword){
		String hql="from Hbsy where e_name like '%"+keyword+"%'"+" order by id Desc";
		return pagedao.findByPage(hql, offset, pageSize);
	}
	public List<Hbsy> searchTypeListByPage(int offset,int pageSize,String keyword){
		String hql="from Hbsy where e_type like '%"+keyword+"%'"+" order by id Desc";
		return pagedao.findByPage(hql, offset, pageSize);
	}
	public List<Hbsy> searchDetailListByPage(int offset,int pageSize,String keyword){
		String hql="from Hbsy where e_detail like '%"+keyword+"%'"+" order by id Desc";
		return pagedao.findByPage(hql, offset, pageSize);
	}
}
