package com.test1;

import java.util.ArrayList;
import java.util.List;

public class LambdaTest {
	
	@FunctionalInterface //�Լ��� �������̽��� ���� �˻縦 �����Ϸ����� �Ƿ���
	public interface SUM 
	{
		public int add(int a, int b);
	}
	@FunctionalInterface
	public interface AVG {
		public int avg(List<Integer> list);
	}
	public static void main(String[] args) 
	{
		/* Ŭ������ ��� �� �������̵� �� */
		class MyThread extends Thread 
		{
			@Override
			public void run() {
				System.out.println("����");
			}
		}
		Thread t1 = new MyThread();
		//t1.start();
		
		/* �͸� Ŭ����(Anonymous Class)�� ������ ������ */
		Thread t = new Thread() {
			@Override
			public void run() {
				System.out.println("����");
			}
		};
		//t.start();
		
		/* �͸� Ŭ������ ��ü�� �������� ���� ����ϴ� �� 
		new Thread() {
			@Override
			public void run() {
				System.out.println("����");
			}
		}.start(); */
		
		/* �͸� Ŭ������ ��ü�� �ƱԸ�Ʈ�� �޾Ƽ� ����ϴ� ��
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("����");
			}
		}).start(); */
		
		/* �Լ��� �������̽��� ����ϴ� ��(Lambda Expression) */
		new Thread(()->{
			System.out.println("����");
		}).start();
		
		SUM mul =  (a,b)->a+b;  // SUM�������̽��� add()�޼ҵ� ����
		test(mul);
		test( (a,b)->a+b );  // ���� ������ ǥ��
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(6);
		list.add(9);
		
		AVG avg = (li) ->{
			int sum = 0;
			for(int i=0; i<li.size(); i++) {
				sum += li.get(i);
			}
			return sum/li.size();
		};
		
		System.out.println(avg.avg(list));
		
		test2(list, li->{
			int sum=0;
			for(int i=0; i<li.size(); i++) {
				sum += li.get(i);
			}
			return sum/li.size();
		});
	}
	
	public static void test(SUM sum) {
		System.out.println(sum.add(3,5));
	}
	
	public static void test2(List<Integer> list,AVG avg) {
		System.out.println(avg.avg(list));
	}
}