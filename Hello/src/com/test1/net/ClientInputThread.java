package com.test1.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ClientInputThread extends Thread {

	ObjectInputStream oin;

	public ClientInputThread(ObjectInputStream oin) {
		this.oin = oin;
	}

	@Override
	public void run() {
		try {
			while(true) {
				MsgFormat mf = (MsgFormat) oin.readObject();
				System.out.println();
				System.out.println(mf.getContents());
				
				if(mf.getFileName()!=null) {
					mf.saveFile("C:/test/pic");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("클라이언트 쓰레드 종료");
	}
	
	
	
	
}
