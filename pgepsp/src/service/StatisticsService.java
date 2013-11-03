package service;

import java.util.List;

import model.Statistics;
import dao.StatisticsDao;

public class StatisticsService {
//����ע���	
public StatisticsDao staDao;
public void setStaDao(StatisticsDao staDao) {
	this.staDao = staDao;
}

//��Ӽ�¼
public int saveSta(Statistics statistics){
	int a=staDao.save(statistics);
	if(a!=0){
	return a;
	}
	else return 0;
}

//���Ҽ�¼����
public List<Statistics> findListSta(String hql){
	return staDao.findList(hql);
}

//ɾ����¼����
public void deleteListSta(List<Statistics> list){
	staDao.deleteList(list);
}

//ɾ����¼
public void deleteSta(Statistics statistics){
	staDao.delete(statistics);
}

//�����¼����
public int count(String hql){
	return staDao.countRecords(hql);
}

//��δ֪����Ķ�Ӧ����
@SuppressWarnings("rawtypes")
public List find(String hql){
	return staDao.find(hql);
}
}
