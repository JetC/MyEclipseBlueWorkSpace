package org.mail.recive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.FetchProfile;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeUtility;

import org.mail.bean.MailReciveBean;

import sun.misc.BASE64Decoder;

public class MailRecive {

	public void reciveMail(MailReciveBean bean) {
		Properties prop = new Properties();
		prop.put("mail.pop3.host", bean.getHost());
		Session sess = Session.getDefaultInstance(prop);
		try {
			Store store = sess.getStore("pop3");
			store.connect(bean.getHost(), bean.getUsername(), bean
					.getPassword());
			Folder fold = store.getFolder("inbox");
			fold.open(Folder.READ_ONLY);
			FetchProfile profile = new FetchProfile();
			profile.add(FetchProfile.Item.ENVELOPE);
			Message mess[] = fold.getMessages();
			fold.fetch(mess, profile);
			for (int i = 0; i < mess.length; i++) {
				Message m = mess[i];
				handleMessage(m, bean);
			}
			if (fold != null) {
				fold.close(false);
			}
			if (store != null) {
				store.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void handleMessage(Message m, MailReciveBean bean) {// 通过MailReciveBean来获取附件的保存路径
		try {
			System.out.println("邮件主题:" + m.getSubject());
			System.out.println("发件人地址:" + m.getFrom()[0].toString());
			// System.out.println("发送时间:"+m.getSentDate().toLocaleString());
			Object o = m.getContent();
			if (o instanceof Multipart) {// 用来判断该邮件的内容是否为带附件的
				Multipart part = (Multipart) o;// 如果是则强制转换为Multipart
				int count = part.getCount();// 用来获取该部分所包含的附件总数
				for (int i = 0; i < count; i++) {
					BodyPart body = part.getBodyPart(i);
					String disposition = body.getDisposition();
					if (disposition != null
							&& disposition.equals(Part.ATTACHMENT)) {//
						String n = body.getFileName();// 获取未解码的文件名
						String fileName=decodeText(n);
						InputStream in = body.getInputStream();// 获得邮件的输入流
						String filePath = bean.getSavePath()+"\\"+fileName;// 用来设置保存的路径
						System.out.println("文件保存路径:" + filePath);
						File file = new File(filePath);
						if (!file.exists()) {
							file.createNewFile();
						}
						FileOutputStream out = new FileOutputStream(file);
						byte content[] = new byte[255];
						int read;
						while ((read = in.read(content)) != -1) {
							out.write(content);
						}
						out.close();
						in.close();
					}
				}
			} else if (o instanceof String) {
				String text = (String) o;
				text=decodeText(text);
				System.out.println(text);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected String decodeText(String text)
			throws UnsupportedEncodingException {
		if (text == null)
			return null;
		if (text.startsWith("=?GB") || text.startsWith("=?gb"))
			text = MimeUtility.decodeText(text);
		else
			text = new String(text.getBytes("iso-8859-1"));
		return text;
	}
}
