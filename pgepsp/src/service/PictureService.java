package service;
import java.util.List;

import model.Picture;
import dao.*;

public class PictureService {
public PictureDao picDao;
public void setPicDao(PictureDao picDao) {
	this.picDao = picDao;
}

//���ͼƬ
public int addPic(Picture pic) {
	return picDao.save(pic);
}

//ȡ��ͼƬ
public Picture findPic(int pr_id){
	String hql="from Picture where Fk_pid='"+pr_id+"'";
	Picture pic=null;
	pic=picDao.findPicture(hql);
	return pic;
}
public Picture findaIdPic(int pr_id){
	String hql="from Picture where Fk_aId='"+pr_id+"'";
	Picture pic=null;
	pic=picDao.findPicture(hql);
	return pic;
}
public Picture findeIdPic(int pr_id){
	String hql="from Picture where Fk_eId='"+pr_id+"'";
	Picture pic=null;
	pic=picDao.findPicture(hql);
	return pic;
}
public Picture findmIdPic(int pr_id){
	String hql="from Picture where Fk_mId='"+pr_id+"'";
	Picture pic=null;
	pic=picDao.findPicture(hql);
	return pic;
}

//ɾ��ͼƬ
public void deletePic(Picture picture){
	picDao.delete(picture);
}

//����ͼƬ
public void updatePic(Picture picture){
	picDao.update(picture);
}

//ȡ��ͼƬ����
public List<Picture> findPicList(String hql){
	return picDao.findList(hql);
}

//���Ӽ�¼
public int add(Picture p){
	System.out.print("ִ�е�ͼƬ��ӵ�Service��!\n");
	return picDao.save(p);
}
//ɾ����¼
public void delete(Picture p){
	System.out.print("ִ�е�Service��!\n");
	picDao.delete(p);
}
//���¼�¼
public void update(Picture p){
	System.out.print("ִ�е�Service��!\n");
	picDao.update(p);
}

//ID����
public Picture findFromId(int id) {
	return picDao.find(id);
}

}