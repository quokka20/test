package com.test1.net;

import java.io.File;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

public class ChatServer {
	// �̿����� ID, ��½�Ʈ���� �÷��ǿ� �����ϰ� ���߿� ID�� ����Ͽ� �� �̿����� ��½�Ʈ���� �����Ͽ�
	// �޽����� ������ �ʿ䰡 �ֱ� ������ Ű, ���� ������ ������ �� �ִ� Map�� ����� �ʿ䰡 �ִ�.
	// HashMap, Hashtable�� ����� ���� �ִµ�, HashMap�� ���� ������ ȯ�濡 ����ȭ���� �ʾƼ�
	// ������ �������� �������� ���� ���� �����Ƿ� �� ���α׷��� ���� ���� ������ ȯ�濡�� ���������� �۵��Ϸ���
	// Hashtable�� �����ϴ� ���� ����. Hahstable�� ������ �ټ� ���������� ���� ������ ȯ�濡 ����ȭ�Ǿ� �ֱ� �����̴�.
	
	static Hashtable<String, ObjectOutputStream> outs = new Hashtable<String, ObjectOutputStream>();
	
	
	
	public static void main(String[] args) {
		// ���� �������� ��� ��� ����
		try {
			ServerSocket server = new ServerSocket(1234);
			while(true) {
				System.out.println("���� ���� �� ��� ��");
				Socket soc = server.accept(); // ���, Ŭ���̾�Ʈ�� ������ ������ ���ŷ ���·� ���
				System.out.println("Ŭ���̾�Ʈ ����");
				System.out.println("�α��� ��");
				new LoginThread(soc).start();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("���� ����");

	}

//	private static boolean login(Socket soc) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
//		String userData = br.readLine();
//		//String userData = "scott:tiger";
//		String[] user = userData.split(":");
//		//System.out.printf("id:%s pwd:%s \n",user[0], user[1]);
//		PrintWriter pw = new PrintWriter(new OutputStreamWriter(soc.getOutputStream()));
//		if(user[0].equals("scott") && user[1].equals("tiger")) {
//			pw.println("�α��� ����");
//			pw.flush();
//			return true;
//		}
//		pw.println("�α��� ����");
//		pw.flush();
//		return false;
//	}
	
	
	
	
	
}
