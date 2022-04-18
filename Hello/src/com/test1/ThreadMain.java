package com.test1;

import java.util.Date;

class NumCode implements Runnable{

	@Override
	public void run() {
		int i = 0;
		while(true) {
			System.out.println(i++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

class DateCode implements Runnable{

	@Override
	public void run() {
		while(true) {
			System.out.println(new Date());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}


class MyThread extends Thread{

	@Override
	public void run() {
		while(true) {
			System.out.println(new Date());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

public class ThreadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Thread t1 = Thread.currentThread();
//		System.out.println(t1.getName());
		
//		Runnable code1 = new Runnable() {
//			
//			@Override
//			public void run() {
//				int i = 0;
//				while(true) {
//					System.out.println(i++);
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		};
//		
//		Runnable code2 = new Runnable() {
//			
//			@Override
//			public void run() {
//				while(true) {
//					System.out.println(new Date());
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//				
//			}
//		};
//		
//		Thread numThread = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				int i = 0;
//				while(true) {
//					System.out.println(i++);
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		});
//		Thread dateThread = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				while(true) {
//					System.out.println(new Date());
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//				
//			}
//		});
//
//		numThread.start();
//		dateThread.start();
		
//		Runnable r1 = ()->{
//			ThreadMain.printNum();
//		};
//		Thread t3 = new Thread(r1);
//		t3.start();
//		
//		new Thread(()->{
//			ThreadMain.printDate();
//		}).start();
		
		new MyThread().start();
		
	}
	
	static void printNum() {
		int i = 0;
		while(true) {
			System.out.println(i++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	static void printDate() {
		while(true) {
			System.out.println(new Date());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



}
