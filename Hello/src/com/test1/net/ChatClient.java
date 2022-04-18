package com.test1.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {
	
	static String uid;

	public static void main(String[] args) {

		// Socket�� �̿��Ͽ� ������ ����
		try {
			// 127.0.0.1
			Socket client = new Socket("127.0.0.1",1234);
			System.out.println("Ŭ���̾�Ʈ -> ���� ���� ����");
			
			ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
			ObjectInputStream oin = new ObjectInputStream(client.getInputStream());

			
			Scanner sc = new Scanner(System.in);

			System.out.print("ID: ");
			String uid = sc.nextLine().trim();
			
			System.out.print("PW: ");
			String upw = sc.nextLine().trim();
			
//			String loginData = String.format("%s:%s", uid, upw);
//			PrintWriter pw = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
//			pw.println(loginData);
//			pw.flush();
//			MsgFormat mf = new MsgFormat();
//			mf.setContents(loginData);
//			oos.writeObject(mf);
//			oos.flush();
			
//			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
//			String loginResult = br.readLine();
//			System.out.println(loginResult);
			
			
			MsgFormat mf = new MsgFormat();
			mf.setUid(uid);
			mf.setPwd(upw);
			oos.writeObject(mf);
			oos.flush();
		
			MsgFormat login = (MsgFormat) oin.readObject();
			String loginResult = login.getContents();
			
			// �α��ο� ������ �Ŀ� �������� ä�� ����
			new ClientInputThread(oin).start();
		
			// Ŭ���̾�Ʈ�� Ű���� -> ������ ����
			if(loginResult.equals("�α��� ����")) {
				ChatClient.uid=uid;
				
//				mf.print();
//				mf.saveFile("C:/test");
				while(true) {
					System.out.print("�޽��� �Է�: ");
					String contents = sc.nextLine().trim();
					System.out.print("������: ");
					String rec = sc.nextLine().trim();
					System.out.print("���� ���: ");
					String fPath = sc.nextLine().trim();
					System.out.print("���� �̸�: ");
					String fName = sc.nextLine().trim();
					MsgFormat comm = new MsgFormat();
					comm.setSender(ChatClient.uid);	
					comm.setContents(contents);
					comm.setRecevier(rec);
					
					if(fPath!=null && !fPath.equals("")) {
						if(fName!=null && !fName.equals("")) {
							comm.setFileName(fName);
							comm.loadFile(fPath);
						}
					}
					
					oos.writeObject(comm);
					oos.flush();
//					MsgFormat mf = createMsg();
//					oos.writeObject(mf);
//					oos.flush();

//					String svrMsg = br.readLine();	// �����κ��� ����
//					System.out.println(svrMsg);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ŭ���̾�Ʈ ����");
		
	}

	static MsgFormat createMsg() {
		MsgFormat mf = new MsgFormat();
		Scanner sc = new Scanner(System.in);
		
		mf.setSender(ChatClient.uid);
		
		System.out.print("����: ");
		String rec = sc.nextLine().trim();
		mf.setRecevier(rec);
		
		System.out.print("����: ");
		String contents = sc.nextLine().trim();
		mf.setContents(contents);
		
		mf.setFileName("member.txt");
		mf.loadFile("C:/Users/ysmin/Javatest");
		return mf;
	}
}
