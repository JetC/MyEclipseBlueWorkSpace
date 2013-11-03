package org.mail.test;
import javax.mail.*;

import java.util.*;
import java.io.*;

public class ReceiveMail {
    public static void receive(String receiverMailBoxAddress, String username,String password) {
        //�����õ���yahoo���䣬�ʽ����ʼ�ʹ��yahoo��pop3�ʼ�������
        String host = "pop.mail.yahoo.com.cn";
        try {
            //���ӵ��ʼ�������������ʼ�
            Properties prop = new Properties();
            prop.put("mail.pop3.host", host);
            Session session = Session.getDefaultInstance(prop);
            Store store = session.getStore("pop3");
            store.connect(host, username, password);

            Folder inbox = store.getDefaultFolder().getFolder("INBOX");
            //����inbox��������Ϊ�ɶ�д���������Կ����ڶ����ʼ���ֱ��ɾ���ø���
            inbox.open(Folder.READ_WRITE);

            Message[] msg = inbox.getMessages();

            FetchProfile profile = new FetchProfile();
            profile.add(FetchProfile.Item.ENVELOPE);
            inbox.fetch(msg, profile);

            for (int i = 0; i < msg.length; i++) {
                //��Ǵ��ʼ���flag��־�����DELETEDλΪtrue,�����ڶ����ʼ���ֱ��ɾ���ø���������ִ��ʱ�����ڵ���
                //inbox.close()������ʱ��
            	msg[i].setFlag(Flags.Flag.DELETED, true);
				Message msg1 = msg[i];
            	System.out.println("�ʼ�����:" + msg1.getSubject());
				System.out.println("�ʼ�����:" + msg1.getFrom()[0].toString());
			    System.out.println("��������:" + msg1.getSentDate());
                String disposition;//�ñ���������ȡ����������
				BodyPart part;//
				Multipart mp = (Multipart) msg1.getContent();//��ȡ���ʼ��������ӵĸ�������
				//Miltipart������,���ڳ��˶��part,����������
				int mpCount = mp.getCount();
				for (int m = 0; m < mpCount; m++) {
				  
				    part = mp.getBodyPart(m);
				    disposition = part.getDisposition();
				    //�ж��Ƿ��и���
				    if (disposition != null && disposition.equals(Part.ATTACHMENT))
				    {
				        //����������𱣴渽��
				        //�õ�δ������ĸ�������
						String temp = part.getFileName();
						//��ȥ�����ʼ�ʱ�������ĸ����������ͷ��β���õ���ȷ�ĸ�����
						//����ο������ʼ�����SendMail�ĸ��������벿�֣�
						String s = temp.substring(8, temp.indexOf("?="));
						sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
						byte[] b = decoder.decodeBuffer(s);
						//�ļ���������base64����,�����ǽ���
						String fileName = (new String(b));
						System.out.println("�и���:" + fileName);
						
						InputStream in = part.getInputStream();
						FileOutputStream writer = new FileOutputStream(new File(
						        "���渽���ı���·��"+ "\\"+fileName));
						byte[] content = new byte[255];
						int read = 0;
						while ((read = in.read(content)) != -1) {
						    writer.write(content);
						}
						writer.close();
						in.close();
				    } else {
				        //���Ǹ�������ֻ��ʾ�ı�����
				        System.out.println(part.getContent());
				    }
				}
                System.out.println("****************************");
            }
            if (inbox != null) {
                //����Ϊtrue�����Ķ�����ʼ�����ɾ���������������ο�mail.jar��API
                inbox.close(true);
            }
            if (store != null) {
                store.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}