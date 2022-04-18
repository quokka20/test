package com.test1.net;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

//�α��� ������
	class LoginThread extends Thread{
		
		Socket soc;
		ObjectInputStream oin;
		ObjectOutputStream oos;

		
		public LoginThread(Socket soc) {
			this.soc = soc;
			try {
				oin = new ObjectInputStream(soc.getInputStream());
				oos = new ObjectOutputStream(soc.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			String userData;
			try {
				MsgFormat mf = (MsgFormat) oin.readObject();
				String uid = mf.getUid();
				String pwd = mf.getPwd();
				MsgFormat loginRes = new MsgFormat();
				if(checkMember(uid,pwd)) {
					loginRes.setContents("�α��� ����");
					oos.writeObject(loginRes);
					oos.flush();
					// �̿��� ID, ��½�Ʈ���� ������ ����
					ChatServer.outs.put(uid, oos);
					// �α��� ������ ä���� ���� ��ſ� ������ ����
					new CommThread(uid,oos,oin).start();
				} else {
					loginRes.setContents("�α��� ����");
					oos.writeObject(loginRes);
					oos.flush();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("�α��� ������ ����");
		}
		
		private boolean checkMember(String uid, String pwd) {
			File f = new File("C:/Users/ysmin/Javatest/chatmember.txt");
			if(!f.exists()) {
				System.err.println("���Ͼ���");
				return false;
			}
			try {
				BufferedReader br = new BufferedReader(new FileReader(f));
				String line = null;
				while((line=br.readLine())!=null) {
					String[] fdata = line.split(":");
					if(fdata[0].equals(uid) && fdata[1].equals(pwd)) {
						br.close();
						return true;
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
	}