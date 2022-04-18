package com.test1;



public class ThreadTest2 {

	static int num;

	public static void main(String[] args) {

//		System.out.println(num);

		// 2개의 쓰레드를 정의하고 
		// t1은 1초에 한번씩 num값을 올리고,
		// t2는 1초에 한번씩 num값을 내리고,
		// 값을 변경한 후에는 그 값을 화면에 표시한다.
		// t1이 값을 계속 올리다가 5에 도달하면 멈춘다 (wait()
		//  - wait풀에서 대기(통보가 올 때까지)
		// t2는 값을 계속 내리다가 0에 도달하면 멈춘다(wait(), notify())
		/*
		 * 쓰레드는 run()메소드가 종료하면 쓰레드가 죽는다(다시 실행 불가)
		 */
		
		/*
		Object obj = new Object();  
		
		new Thread(()->{
			while(true) {
				synchronized(obj) 
				{
					ThreadTest2.num++;
					System.out.print(num+" ");
					try {
						if (ThreadTest2.num==5) {
							obj.notify(); //wait풀에 있는 쓰레드에게 통지(활동알림)
							obj.wait();   //현재 쓰레드를 wait풀로 이동
						}
					
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(()->{
			while(true) {
				synchronized(obj) 
				{
					try {
						if(ThreadTest2.num==0) {
							obj.notify();
							obj.wait();
						}else {
							ThreadTest2.num--;
							System.out.print(num+" ");
						}
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();*/
		
//		deadState();
		
		Object obj = new Object();
		
		new Thread(()->{
			while(true) {
				synchronized (obj) {
					ThreadTest2.num++;
					System.out.print(num+" ");
						try {
							if(ThreadTest2.num==5) {
								obj.notify();
								obj.wait();
							}
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
		}).start();
		
		new Thread(()->{
			while(true) {
				synchronized (obj) {
					ThreadTest2.num--;
					System.out.print(num+" ");
						try {
							if(ThreadTest2.num == 0) {
								obj.notify();
								obj.wait();
							}
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
		}).start();
	}
	
	static void deadState() {
		Thread t1 = new Thread(()->{
			for(int i=0;i<10;i++) {
				System.out.println(i);
			}
		});
		t1.start();
		//t1.start();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Runnable r1 = new Runnable() {
//
//			@Override
//			public void run() {
//				while (true) {
//					System.out.println(num++);
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//
//			}
//		};
//
//		Runnable r2 = new Runnable() {
//
//			@Override
//			public void run() {
//				while (true) {
//					System.out.println(num--);
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//
//			}
//		};
//
//		
//		Thread addThread = new Thread(r1);
//		Thread minusThread = new Thread(r2);
//		
//		addThread.start();
//		minusThread.start();
//		
//		
//		
//	}
//
//	static void printAddNum() {
//		while (true) {
//			System.out.println(num++);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//
//	static void printMinusNum() {
//		while (true) {
//			System.out.println(num--);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//	
//	static void deadState() {
//		Thread t1 = new Thread(()->{
//			for(int i = 0; i<10;i++) {
//				
//			}
//		});
	}
}
