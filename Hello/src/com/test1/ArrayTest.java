package com.test1;

import java.util.Random;
import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {

//		StringArray();
		searchTest();
	}
	
	static void arrayTest() {
		int[] score = new int[10];
		Random rd = new Random();
		for(int i =0; i<score.length; i++) {
			score[i] = rd.nextInt(20);
			System.out.println(score[i]);

		}
	}
	
	static void StringArray() {
		String[] names = new String[3];
		
		names[0]="�����";
		names[1]="������";
		names[2]="�̽¿�";
		
		for(int i =0;i<names.length;i++) {
//			System.out.println(names[i]);
			if(names[i].equals("�����")) {
				System.out.println(i);
			}
		}
	}
	
	static void searchTest() {
		int[] number = new int[5];
		String[] name = new String[5];
		String[] phone = new String[5];
		
		for(int i = 0; i<number.length;i++) {
			number[i] = i+1; 
//			System.out.println(number[i]);
		}
		
		name[0] = "�̽¿�";
		name[1] = "�߽ż�";
		name[2] = "������";
		name[3] = "������";
		name[4] = "�����";
		
		phone[0] = "010-1111-1111";
		phone[1] = "010-2222-2222";
		phone[2] = "010-3333-3333";
		phone[3] = "010-4444-4444";
		phone[4] = "010-5555-5555";
		
		boolean found = false;
		int searchnumber = -1;
		Scanner sc = new Scanner(System.in);
		while(true) 
		{
		System.out.println("�˻��Ͻðڽ��ϱ�?(y/n): ");
		String m = sc.nextLine().trim();
		if(m.equals("y")) {
		System.out.println("�˻��� �̸��� �Է��ϼ���: ");
		String search = sc.nextLine().trim();
			for(int i =0; i<name.length; i++) {
				if(name[i].equals(search)) {
					searchnumber = i;
					found = true;
					System.out.println(number[searchnumber]);
					System.out.println(phone[searchnumber]);
					break;
					}
			}
			if(!found) {
				System.out.println("�˻� ����� �����ϴ�.");
		  		}
		} else {
			System.out.println("�˻��� �����մϴ�.");
			break;
			}
		}
		

		
		
	}

	
}
