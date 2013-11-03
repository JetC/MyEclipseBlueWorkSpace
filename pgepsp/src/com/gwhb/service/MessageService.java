package com.gwhb.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gwhb.dao.MessageDao;
import com.gwhb.model.Message;

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

	@Resource
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

}