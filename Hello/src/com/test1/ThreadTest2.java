package com.test1;



public class ThreadTest2 {

	static int num;

	public static void main(String[] args) {

//		System.out.println(num);

		// 2���� �����带 �����ϰ� 
		// t1�� 1�ʿ� �ѹ��� num���� �ø���,
		// t2�� 1�ʿ� �ѹ��� num���� ������,
		// ���� ������ �Ŀ��� �� ���� ȭ�鿡 ǥ���Ѵ�.
		// t1�� ���� ��� �ø��ٰ� 5�� �����ϸ� ����� (wait()
		//  - waitǮ���� ���(�뺸�� �� ������)
		// t2�� ���� ��� �����ٰ� 0�� �����ϸ� �����(wait(), notify())
		/*
		 * ������� run()�޼ҵ尡 �����ϸ� �����尡 �״´�(�ٽ� ���� �Ұ�)
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
							obj.notify(); //waitǮ�� �ִ� �����忡�� ����(Ȱ���˸�)
							obj.wait();   //���� �����带 waitǮ�� �̵�
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
