package com.gwhb.action;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gwhb.model.Message;
import com.gwhb.service.MessageService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Action层，MVC结构的控制器，最好别包含业务逻辑（有Service层的情况下）。
 * 
 * @author 曹黎宏宇。
 * 
 */
// 表示Spring自动new一个该类对象，名字叫messageAction。
@Component("messageAction")
// Spring设置该类对象生命周期，一般Action都这么设置，表示每次new一个新对象。
@Scope("prototype")
public class MessageAction extends ActionSupport {

	private static final long serialVersionUID = 1124990390592191109L;
	private MessageService messageService;
	private Message message;

	private HttpServletRequest request;

	public String save() throws Exception {
		request = ServletActionContext.getRequest();
		String ip = request.getRemoteAddr();
		message.setIp(ip);
		message.setTime(Calendar.getInstance().getTime());
		messageService.save(message);
		return SUCCESS;
	}

	public String update() throws Exception {
		request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		String reply = request.getParameter("reply");
		message = messageService.get(id);
		message.setReply(reply);
		message.setReplytime(Calendar.getInstance().getTime());
		messageService.update(message);
		return SUCCESS;
	}

	public String delete() throws Exception {
		messageService.delete(message);
		return SUCCESS;
	}

	public String show() throws Exception {
		request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		Message message = messageService.get(id);
		request.setAttribute("message", message);
		return SUCCESS;
	}

	public String list() throws Exception {
		request = ServletActionContext.getRequest();
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		String keyword = request.getParameter("keyword");
		int count;
		if (keyword == null || keyword.trim().equals("")) {
			count = messageService.count();
		} else {
			count = messageService.count(keyword);
		}
		if (pageNum < 0) {
			pageNum = 0;
		} else if (pageNum > (count - 1) / 10) {
			pageNum = (count - 1) / 10;
		}
		List<Message> messages;
		if (keyword == null || keyword.trim().equals("")) {
			messages = messageService.list(pageNum);
		} else {
			messages = messageService.list(pageNum, keyword);
		}
		request.setAttribute("messages", messages);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("keyword", keyword);
		request.setAttribute("count", count);
		return SUCCESS;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	// Spring自动注入成员变量。
	@Resource
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public Message getMessage() {
		return message;
	}

	// 由Struts注入，故不用管。
	public void setMessage(Message message) {
		this.message = message;
	}

}