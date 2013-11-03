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
	//ID�б��¼
	public List<Hdjy> selectAll() {
		String hql="from Hdjy order by id desc";
		return dao.findAll(hql);
	}
	//COUNT�б��¼
	public List<Hdjy> selectAllByCount() {
		String hql="from Hdjy order by a_count desc";
		return dao.findAll(hql);
	}
	//�������з���
	public List<Hdjy> typeList(){
		String hql="select distinct a_type from Hdjy";
		return dao.findAll(hql);
	}
	//ID����
	public Hdjy findFromId(int id) {
		return dao.find(id);
	}
	//�����м�¼
	public int getRows(){
		String hql="from Hdjy";
		System.out.print("ִ�е�Service��!\n");
		return dao.Records(hql);
	}
	
	//���Ӽ�¼
	public int add(Hdjy h){
		System.out.print("ִ�е�Service��!\n");
		return dao.save(h);
	}
	//ɾ����¼
	public void delete(Hdjy h){
		System.out.print("ִ�е�Service��!\n");
		dao.delete(h);
	}
	//���¼�¼
	public void update(Hdjy h){
		System.out.print("ִ�е�Service��!\n");
		dao.update(h);
	}
	
	
	//��ҳ��ʼ��
	public Pager pageInitial(Pager pager,String method){
		pager.newPager(pager.getCurrentPage(),method,pager.getMaxRecords(),pager.getPageSize());
		return pager;
	}
	//��ҳ��ʾ
	public List<Hdjy> viewHdjyByList(int offset,int pageSize){
		String hql="from Hdjy order by id Desc";
		return pagedao.findByPage(hql, offset, pageSize);
	}
	//����ͳ��
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
	//���������ҳ
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
