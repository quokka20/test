package com.test1;

/* List �߿��� ArrayList �� LinkedList ��
 * 
 * ArrayList : ���Ҹ� ������� ��ȸ�Ͽ� ���� ����ϴµ� ����ȭ
 *  - ������ ���� ����, �߰����� ���� ����� LinkedList�� ���� �ſ� ����
 *  
 * LinkedList: ���Ҹ� ����, �߰����� �ϴ� ��ɿ� ����ȭ
 *  - ������ ���� ������� ��ȸ�Ͽ� ����ϴ� ����� ArrayList�� ���� ����
 *  
 * ArrayList�� LinkedList�� ���� 1õ������ ������ �����ϰ� ����, ���� ���� �׽�Ʈ
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
		// ArrayList ��ȸ ���� �׽�Ʈ
		System.out.println("���Ұ��� 10��");
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
		System.out.println("ArrayList\t���Ҽ�ȸ ����ð�(ms):"+(end-start));
	}
	
	static void linkedListLoop() {
		// LinkedList ��ȸ ���� �׽�Ʈ
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
		System.out.println("LinkedList\t���Ҽ�ȸ ����ð�(ms):"+(end-start));
		System.out.println();
	}
	
	static void arrayListInsert() {
		// ArrayList ���� ���� �׽�Ʈ
		System.out.println("���Ұ��� 1000��");
		ArrayList<Integer> alist = new ArrayList<>();
		for(int i=0;i<10000000;i++) {
			alist.add(i);
		}

		long start = System.currentTimeMillis();
		alist.add(0, 1234);  // �� �տ� ���ο� ������ �߰�(��� �����Ͱ� �ڷ� �з���)
		long end = System.currentTimeMillis();
		System.out.println("ArrayList\t���һ��� ����ð�(ms):"+(end-start));
	}

	static void linkedListInsert() {
		// LinkedList ���� ���� �׽�Ʈ
		LinkedList<Integer> linkedList = new LinkedList<>();
		for(int i=0;i<10000000;i++) {
			linkedList.add(i);
		}

		long start = System.currentTimeMillis();
		linkedList.add(0, 1234);  // �� �տ� ���ο� ������ �߰�(��� �����Ͱ� �ڷ� �з���)
		long end = System.currentTimeMillis();
		System.out.println("LinkedList\t���һ��� ����ð�(ms):"+(end-start));
		System.out.println();
	}
	
	static void arrayListRemove() {
		// ArrayList ���� ���� �׽�Ʈ
		System.out.println("���Ұ��� 1000��");
		ArrayList<Integer> alist = new ArrayList<>();
		for(int i=0;i<10000000;i++) {
			alist.add(i);
		}

		long start = System.currentTimeMillis();
		alist.remove(0);  // �� ���� ������ ����(��� �����Ͱ� ������ �̵�)
		long end = System.currentTimeMillis();
		System.out.println("ArrayList\t���һ��� ����ð�(ms):"+(end-start));
	}
	
	static void linkedListRemove() {
		// LinkedList ���� ���� �׽�Ʈ
		LinkedList<Integer> linkedList = new LinkedList<>();
		for(int i=0;i<10000000;i++) {
			linkedList.add(i);
		}

		long start = System.currentTimeMillis();
		linkedList.remove(0);  // �� ���� ������ ����(��ũ�� ������)
		long end = System.currentTimeMillis();
		System.out.println("LinkedList\t���һ��� ����ð�(ms):"+(end-start));
		System.out.println("............�׽�Ʈ ����");
	}
}
