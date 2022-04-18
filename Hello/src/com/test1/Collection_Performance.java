package com.test1;

/* List 중에서 ArrayList 와 LinkedList 비교
 * 
 * ArrayList : 원소를 순서대로 순회하여 값을 출력하는데 최적화
 *  - 원소의 값을 삭제, 중간삽입 등의 기능은 LinkedList에 비해 매우 느림
 *  
 * LinkedList: 원소를 삭제, 중간삽입 하는 기능에 최적화
 *  - 원소의 값을 순서대로 순회하여 출력하는 기능은 ArrayList에 비해 느림
 *  
 * ArrayList와 LinkedList에 각각 1천만개의 정수를 저장하고 삽입, 삭제 성능 테스트
*/

import java.util.*;

public class Collection_Performance 
{
	public static void main(String[] args) 
	{
		arrayListLoop();
		linkedListLoop();
		
		arrayListInsert();
		linkedListInsert();
		
		arrayListRemove();
		linkedListRemove();
	}
	
	static void arrayListLoop() {
		// ArrayList 순회 성능 테스트
		System.out.println("원소갯수 10만");
		ArrayList<Integer> alist = new ArrayList<>();
		for(int i=0;i<100000;i++) {
			alist.add(i);
		}
		long start = System.currentTimeMillis();
		int v = 0;
		for(int i=0;i<alist.size();i++) {
			v = alist.get(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("ArrayList\t원소순회 경과시간(ms):"+(end-start));
	}
	
	static void linkedListLoop() {
		// LinkedList 순회 성능 테스트
		LinkedList<Integer> alist = new LinkedList<>();
		for(int i=0;i<100000;i++) {
			alist.add(i);
		}
		long start = System.currentTimeMillis();
		int v = 0;
		for(int i=0;i<alist.size();i++) {
			v = alist.get(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("LinkedList\t원소순회 경과시간(ms):"+(end-start));
		System.out.println();
	}
	
	static void arrayListInsert() {
		// ArrayList 삽입 성능 테스트
		System.out.println("원소갯수 1000만");
		ArrayList<Integer> alist = new ArrayList<>();
		for(int i=0;i<10000000;i++) {
			alist.add(i);
		}

		long start = System.currentTimeMillis();
		alist.add(0, 1234);  // 맨 앞에 새로운 데이터 추가(모든 데이터가 뒤로 밀려남)
		long end = System.currentTimeMillis();
		System.out.println("ArrayList\t원소삽입 경과시간(ms):"+(end-start));
	}

	static void linkedListInsert() {
		// LinkedList 삽입 성능 테스트
		LinkedList<Integer> linkedList = new LinkedList<>();
		for(int i=0;i<10000000;i++) {
			linkedList.add(i);
		}

		long start = System.currentTimeMillis();
		linkedList.add(0, 1234);  // 맨 앞에 새로운 데이터 추가(모든 데이터가 뒤로 밀려남)
		long end = System.currentTimeMillis();
		System.out.println("LinkedList\t원소삽입 경과시간(ms):"+(end-start));
		System.out.println();
	}
	
	static void arrayListRemove() {
		// ArrayList 삭제 성능 테스트
		System.out.println("원소갯수 1000만");
		ArrayList<Integer> alist = new ArrayList<>();
		for(int i=0;i<10000000;i++) {
			alist.add(i);
		}

		long start = System.currentTimeMillis();
		alist.remove(0);  // 맨 앞의 데이터 삭제(모든 데이터가 앞으로 이동)
		long end = System.currentTimeMillis();
		System.out.println("ArrayList\t원소삭제 경과시간(ms):"+(end-start));
	}
	
	static void linkedListRemove() {
		// LinkedList 삭제 성능 테스트
		LinkedList<Integer> linkedList = new LinkedList<>();
		for(int i=0;i<10000000;i++) {
			linkedList.add(i);
		}

		long start = System.currentTimeMillis();
		linkedList.remove(0);  // 맨 앞의 데이터 삭제(링크만 수정됨)
		long end = System.currentTimeMillis();
		System.out.println("LinkedList\t원소삭제 경과시간(ms):"+(end-start));
		System.out.println("............테스트 종료");
	}
}
