package com.test1.net;

import java.io.BufferedReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;

// 채팅 통신용 쓰레드
public class CommThread extends Thread {

	private ObjectInputStream oin;
	private ObjectOutputStream oos;
	private String uid;
	
	CommThread(String uid, ObjectOutputStream oos, ObjectInputStream oin){
		this.uid = uid;
		this.oin = oin;
		this.oos = oos;
		System.out.println("CommThread 시작");
	}

	@Override
	public void run() {
			try {
				while(true) {
				MsgFormat mf = (MsgFormat)oin.readObject();
				String rec = mf.getRecevier();
				if(rec!=null && !rec.equals("")) {
					ObjectOutputStream recOut = ChatServer.outs.get(rec);
					recOut.writeObject(mf);
					recOut.flush();
					continue;
				}
				// 모든 접속자의 출력스트림으로 msg를 송신한다.
				Set<String> keys = ChatServer.outs.keySet();
				Iterator<String> keyIt = keys.iterator();
				while(keyIt.hasNext()) {
					String uid = keyIt.next();
					ObjectOutputStream uOut = ChatServer.outs.get(uid);
					uOut.writeObject(mf);
					uOut.flush();
				}

				}
			} catch (Exception ex) {
				// TODO Auto-generated catch block
//				ex.printStackTrace();
				ChatServer.outs.remove(uid);
				System.err.println(uid+"님이 나가셨습니다.");
			}
			System.out.println("Comm 종료");
		
		
	}
	
	/**	이용자 메시지로부터 수신자와 내용을 추출하여 배열로 리턴한다({"송신자:메시지","수신자"})
	 * 	특정 수신자를 명시하지 않은 메시지는 {'송신자:메시지'} 형식으로 배열에 저장하여 리턴한다
	 * 	"송신자:내용:수신자", "송신자:내용"
	 **/
	
	private String[] getReceiver(String uMsg) {
		String[] msg = uMsg.split(":");

		
		if(msg.length == 3 && msg[2] != null && !msg.equals("")){	//특정 이용자에게만 보내는 메시지
			return new String[] {msg[0]+":"+msg[1],msg[2]};
		}
		//모든 접속자에게 보내는 메시지인 경우
		return new String[] {msg[0]+":"+msg[1]};
	}
	
	
}
