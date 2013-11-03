package service;
import java.util.List;

import model.Picture;
import dao.*;

public class PictureService {
public PictureDao picDao;
public void setPicDao(PictureDao picDao) {
	this.picDao = picDao;
}

//添加图片
public int addPic(Picture pic) {
	return picDao.save(pic);
}

//取出图片
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

//删除图片
public void deletePic(Picture picture){
	picDao.delete(picture);
}

//更新图片
public void updatePic(Picture picture){
	picDao.update(picture);
}

//取出图片集合
public List<Picture> findPicList(String hql){
	return picDao.findList(hql);
}

//增加记录
public int add(Picture p){
	System.out.print("执行到图片添加的Service层!\n");
	return picDao.save(p);
}
//删除记录
public void delete(Picture p){
	System.out.print("执行到Service层!\n");
	picDao.delete(p);
}
//更新记录
public void update(Picture p){
	System.out.print("执行到Service层!\n");
	picDao.update(p);
}

//ID查找
public Picture findFromId(int id) {
	return picDao.find(id);
}

}