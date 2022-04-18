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

//로그인 쓰레드
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
					loginRes.setContents("로그인 성공");
					oos.writeObject(loginRes);
					oos.flush();
					// 이용자 ID, 출력스트림을 쌍으로 저장
					ChatServer.outs.put(uid, oos);
					// 로그인 성공시 채팅을 위한 통신용 쓰레드 시작
					new CommThread(uid,oos,oin).start();
				} else {
					loginRes.setContents("로그인 실패");
					oos.writeObject(loginRes);
					oos.flush();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("로그인 쓰레드 종료");
		}
		
		private boolean checkMember(String uid, String pwd) {
			File f = new File("C:/Users/ysmin/Javatest/chatmember.txt");
			if(!f.exists()) {
				System.err.println("파일없음");
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