package com.test1;

import java.util.ArrayList;
import java.util.List;

public class LambdaTest {
	
	@FunctionalInterface //함수형 인터페이스의 문법 검사를 컴파일러에게 의뢰함
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
		/* 클래스의 상속 및 오버라이드 예 */
		class MyThread extends Thread 
		{
			@Override
			public void run() {
				System.out.println("실행");
			}
		}
		Thread t1 = new MyThread();
		//t1.start();
		
		/* 익명 클래스(Anonymous Class)로 구현한 쓰레드 */
		Thread t = new Thread() {
			@Override
			public void run() {
				System.out.println("실행");
			}
		};
		//t.start();
		
		/* 익명 클래스의 객체를 참조변수 없이 사용하는 예 
		new Thread() {
			@Override
			public void run() {
				System.out.println("실행");
			}
		}.start(); */
		
		/* 익명 클래스의 객체를 아규먼트로 받아서 사용하는 예
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("실행");
			}
		}).start(); */
		
		/* 함수형 인터페이스를 사용하는 예(Lambda Expression) */
		new Thread(()->{
			System.out.println("실행");
		}).start();
		
		SUM mul =  (a,b)->a+b;  // SUM인터페이스의 add()메소드 구현
		test(mul);
		test( (a,b)->a+b );  // 위와 동일한 표현
		
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