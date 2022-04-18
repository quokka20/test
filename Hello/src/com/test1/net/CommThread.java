package com.test1.net;

import java.io.BufferedReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;

// ä�� ��ſ� ������
public class CommThread extends Thread {

	private ObjectInputStream oin;
	private ObjectOutputStream oos;
	private String uid;
	
	CommThread(String uid, ObjectOutputStream oos, ObjectInputStream oin){
		this.uid = uid;
		this.oin = oin;
		this.oos = oos;
		System.out.println("CommThread ����");
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
				// ��� �������� ��½�Ʈ������ msg�� �۽��Ѵ�.
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
				System.err.println(uid+"���� �����̽��ϴ�.");
			}
			System.out.println("Comm ����");
		
		
	}
	
	/**	�̿��� �޽����κ��� �����ڿ� ������ �����Ͽ� �迭�� �����Ѵ�({"�۽���:�޽���","������"})
	 * 	Ư�� �����ڸ� ������� ���� �޽����� {'�۽���:�޽���'} �������� �迭�� �����Ͽ� �����Ѵ�
	 * 	"�۽���:����:������", "�۽���:����"
	 **/
	
	private String[] getReceiver(String uMsg) {
		String[] msg = uMsg.split(":");

		
		if(msg.length == 3 && msg[2] != null && !msg.equals("")){	//Ư�� �̿��ڿ��Ը� ������ �޽���
			return new String[] {msg[0]+":"+msg[1],msg[2]};
		}
		//��� �����ڿ��� ������ �޽����� ���
		return new String[] {msg[0]+":"+msg[1]};
	}
	
	
}
