package com.gwhb.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gwhb.dao.MessageDao;
import com.gwhb.model.Message;

/**
 * Service层，该层主要负责执行业务逻辑，也可理解为调用DAO层的中间阶段。
 * 
 * @author 曹黎宏宇。
 * 
 */
//表示Spring自动new一个该类对象，名字叫messageService。
@Service("messageService")
public class MessageService {

	private MessageDao messageDao;

	public Serializable save(Message message) {
		return messageDao.save(message);
	}

	public void update(Message message) {
		messageDao.update(message);
	}

	public void delete(Message message) {
		messageDao.delete(message);
	}

	public Message get(int id) {
		return messageDao.getById(id);
	}

	public int count() {
		return messageDao.count();
	}

	public int count(String keyword) {
		return messageDao.count(keyword);
	}

	public List<Message> list(int pageNum) {
		return messageDao.list(pageNum);
	}

	public List<Message> list(int pageNum, String keyword) {
		return messageDao.list(pageNum, keyword);
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}

	//Spring自动注入成员变量。
	@Resource
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

}