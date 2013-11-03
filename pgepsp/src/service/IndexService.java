package service;

import java.util.List;

import model.IndexLooking;
import dao.IndexLookingDao;

public class IndexService {
	public IndexLookingDao indLooDao;

	public void setIndLooDao(IndexLookingDao indLooDao) {
		this.indLooDao = indLooDao;
	}
	
	//添加记录
	public int saveIndLoo(IndexLooking indexLooking){
		int a=indLooDao.save(indexLooking);
		if(a!=0){
		return a;
		}
		else return 0;
	}
	
	//查找记录
	@SuppressWarnings("rawtypes")
	public List find(String hql){
		return indLooDao.find(hql);
	}
}
