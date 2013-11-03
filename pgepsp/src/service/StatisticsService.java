package service;

import java.util.List;

import model.Statistics;
import dao.StatisticsDao;

public class StatisticsService {
//依赖注入块	
public StatisticsDao staDao;
public void setStaDao(StatisticsDao staDao) {
	this.staDao = staDao;
}

//添加记录
public int saveSta(Statistics statistics){
	int a=staDao.save(statistics);
	if(a!=0){
	return a;
	}
	else return 0;
}

//查找记录集合
public List<Statistics> findListSta(String hql){
	return staDao.findList(hql);
}

//删除记录集合
public void deleteListSta(List<Statistics> list){
	staDao.deleteList(list);
}

//删除记录
public void deleteSta(Statistics statistics){
	staDao.delete(statistics);
}

//计算记录条数
public int count(String hql){
	return staDao.countRecords(hql);
}

//找未知种类的对应集合
@SuppressWarnings("rawtypes")
public List find(String hql){
	return staDao.find(hql);
}
}
