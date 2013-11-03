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
	//ID�б��¼
	public List<Hbsy> selectAll() {
		String hql="from Hbsy order by id desc";
		return dao.findAll(hql);
	}
	//COUNT�б��¼
	public List<Hbsy> selectAllByCount() {
		String hql="from Hbsy order by e_count desc";
		return dao.findAll(hql);
	}
	//�������з���
	public List<Hbsy> typeList(){
		String hql="select distinct e_type from Hbsy";
		return dao.findAll(hql);
	}
	//ID����
	public Hbsy findFromId(int id) {
		return dao.find(id);
	}
	//�����м�¼
	public int getRows(){
		String hql="from Hbsy";
		System.out.print("ִ�е�Service��!\n");
		return dao.Records(hql);
	}
	
	//���Ӽ�¼
	public int add(Hbsy h){
		System.out.print("ִ�е�Service��!\n");
		return dao.save(h);
	}
	//ɾ����¼
	public void delete(Hbsy h){
		System.out.print("ִ�е�Service��!\n");
		dao.delete(h);
	}
	//���¼�¼
	public void update(Hbsy h){
		System.out.print("ִ�е�Service��!\n");
		dao.update(h);
	}
	
	
	//��ҳ��ʼ��
	public Pager pageInitial(Pager pager,String method){
		pager.newPager(pager.getCurrentPage(),method,pager.getMaxRecords(),pager.getPageSize());
		return pager;
	}
	//��ҳ��ʾ
	public List<Hbsy> viewHbsyByList(int offset,int pageSize){
		String hql="from Hbsy order by id Desc";
		return pagedao.findByPage(hql, offset, pageSize);
	}
	//����ͳ��
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
	//���������ҳ
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
