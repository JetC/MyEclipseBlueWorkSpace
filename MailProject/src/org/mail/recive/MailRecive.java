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

	protected void handleMessage(Message m, MailReciveBean bean) {// ͨ��MailReciveBean����ȡ�����ı���·��
		try {
			System.out.println("�ʼ�����:" + m.getSubject());
			System.out.println("�����˵�ַ:" + m.getFrom()[0].toString());
			// System.out.println("����ʱ��:"+m.getSentDate().toLocaleString());
			Object o = m.getContent();
			if (o instanceof Multipart) {// �����жϸ��ʼ��������Ƿ�Ϊ��������
				Multipart part = (Multipart) o;// �������ǿ��ת��ΪMultipart
				int count = part.getCount();// ������ȡ�ò����������ĸ�������
				for (int i = 0; i < count; i++) {
					BodyPart body = part.getBodyPart(i);
					String disposition = body.getDisposition();
					if (disposition != null
							&& disposition.equals(Part.ATTACHMENT)) {//
						String n = body.getFileName();// ��ȡδ������ļ���
						String fileName=decodeText(n);
						InputStream in = body.getInputStream();// ����ʼ���������
						String filePath = bean.getSavePath()+"\\"+fileName;// �������ñ����·��
						System.out.println("�ļ�����·��:" + filePath);
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
