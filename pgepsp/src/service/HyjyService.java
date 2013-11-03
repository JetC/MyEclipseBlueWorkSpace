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
	//ID�б��¼
	public List<Hyjy> selectAll() {
		String hql="from Hyjy order by id desc";
		return dao.findAll(hql);
	}
	//COUNT�б��¼
	public List<Hyjy> selectAllByCount() {
		String hql="from Hyjy order by m_count desc";
		return dao.findAll(hql);
	}
	//�������з���
	public List<Hyjy> typeList(){
		String hql="select distinct m_type from Hyjy";
		return dao.findAll(hql);
	}
	//ID����
	public Hyjy findFromId(int id) {
		return dao.find(id);
	}
	//�����м�¼
	public int getRows(){
		String hql="from Hyjy";
		System.out.print("ִ�е�Service��!\n");
		return dao.Records(hql);
	}
	
	//���Ӽ�¼
	public int add(Hyjy h){
		System.out.print("ִ�е�Service��!\n");
		return dao.save(h);
	}
	//ɾ����¼
	public void delete(Hyjy h){
		System.out.print("ִ�е�Service��!\n");
		dao.delete(h);
	}
	//���¼�¼
	public void update(Hyjy h){
		System.out.print("ִ�е�Service��!\n");
		dao.update(h);
	}
	
	
	//��ҳ��ʼ��
	public Pager pageInitial(Pager pager,String method){
		pager.newPager(pager.getCurrentPage(),method,pager.getMaxRecords(),pager.getPageSize());
		return pager;
	}
	//��ҳ��ʾ
	public List<Hyjy> viewHdjyByList(int offset,int pageSize){
		String hql="from Hyjy order by id Desc";
		return pagedao.findByPage(hql, offset, pageSize);
	}
	//����ͳ��
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
	//���������ҳ
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
