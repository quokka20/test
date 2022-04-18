package com.test1.net;

import java.io.File;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

public class ChatServer {
	// 이용자의 ID, 출력스트림을 컬렉션에 저장하고 나중에 ID를 사용하여 그 이용자의 출력스트림을 추출하여
	// 메시지를 전송할 필요가 있기 때문에 키, 값을 쌍으로 저장할 수 있는 Map을 사용할 필요가 있다.
	// HashMap, Hashtable을 사용할 수가 있는데, HashMap은 다중 쓰레드 환경에 최적화되지 않아서
	// 성능은 빠르지만 안전하지 않을 수가 있으므로 이 프로그램과 같이 다중 쓰레드 환경에서 안정적으로 작동하려면
	// Hashtable을 선택하는 것이 좋다. Hahstable의 성능은 다소 떨어지더라도 다중 쓰레드 환경에 최적화되어 있기 때문이다.
	
	static Hashtable<String, ObjectOutputStream> outs = new Hashtable<String, ObjectOutputStream>();
	
	
	
	public static void main(String[] args) {
		// 대기용 소켓으로 대기 기능 시작
		try {
			ServerSocket server = new ServerSocket(1234);
			while(true) {
				System.out.println("서버 생성 및 대기 중");
				Socket soc = server.accept(); // 대기, 클라이언트가 접속할 때까지 블로킹 상태로 대기
				System.out.println("클라이언트 접속");
				System.out.println("로그인 중");
				new LoginThread(soc).start();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("서버 종료");

	}

//	private static boolean login(Socket soc) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
//		String userData = br.readLine();
//		//String userData = "scott:tiger";
//		String[] user = userData.split(":");
//		//System.out.printf("id:%s pwd:%s \n",user[0], user[1]);
//		PrintWriter pw = new PrintWriter(new OutputStreamWriter(soc.getOutputStream()));
//		if(user[0].equals("scott") && user[1].equals("tiger")) {
//			pw.println("로그인 성공");
//			pw.flush();
//			return true;
//		}
//		pw.println("로그인 실패");
//		pw.flush();
//		return false;
//	}
	
	
	
	
	
}
