package service;
import model.Admin;
import dao.*;
import java.util.List;
import tools.*;
public class AdminService {
	AdminDao dao;
	AdminPageDao pagedao;
	public AdminDao getDao(){
		return this.dao;
	}
	public void setDao(AdminDao dao){
		this.dao=dao;
	}
	public AdminPageDao getPagedao(){
		return this.pagedao;
	}
	public void setPagedao(AdminPageDao pagedao){
		this.pagedao=pagedao;
	}
	
	//ID�б��¼
	public List<Admin> selectAll() {
		String hql="from Admin order by id desc";
		return dao.findAll(hql);
	}
	//ID����
	public Admin findFromId(int id) {
		return dao.find(id);
	}
	//���Ʋ���
	public Admin findFromName(String a_username) {
		System.out.println("���е���̨��������!");
		//AdminDao dao=new AdminDao();
		String hql="from Admin where a_username='"+a_username+"'";
		return dao.findName(hql);
	}
	//�����м�¼
	public int getRows(){
		String hql="from Admin";
		System.out.print("ִ�е�Service��!\n");
		return dao.Records(hql);
	}
	
	//���Ӽ�¼
	public int add(Admin h){
		System.out.print("ִ�е�Service��!\n");
		//dao=new AdminDao();
		return dao.save(h);
	}
	//ɾ����¼
	public void delete(Admin h){
		System.out.print("ִ�е�Service��!\n");
		dao.delete(h);
	}
	//���¼�¼
	public void update(Admin h){
		System.out.print("ִ�е�Service��!\n");
		dao.update(h);
	}
	
	
	//��ҳ��ʼ��
	public Pager pageInitial(Pager pager,String method){
		pager.newPager(pager.getCurrentPage(),method,pager.getMaxRecords(),pager.getPageSize());
		return pager;
	}
	//��ҳ��ʾ
	public List<Admin> viewAdminByList(int offset,int pageSize){
		String hql="from Admin order by id Desc";
		return pagedao.findByPage(hql, offset, pageSize);
	}
	
}