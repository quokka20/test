package com.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Collection_main {

	public static void main(String[] args) {
		// Java Collections
		// �ټ����� ��ü�� ������ �� �ִ� �ڷᱸ��(Data structures)
		// �迭�� ������ �غ��ϰ� �پ��� Ȱ����� �����ϴ� �ڷᱸ��
		// �迭�� Ư¡�� ����ϱ� ���� �ݵ�� �� ������ Ȯ���ؾ� ��
		// �̿��ڰ� 'x' Ű�� ���� ������ �����͸� �Է� �޾Ƽ� �迭�� �����ϴ� ���
		
//		Scanner sc = new Scanner(System.in);
//		String[] member = new String[5];
//		int i =0;
//		while(true) {
//			System.out.println("ȸ���̸��� �Է����ּ���: ");
//			String name = sc.nextLine();
//			if(name.equals("x")) {
//				break;
//			}
//			member[i++] = name;
//			if(i==member.length) {
//				// ���纸�� �� ū �迭�� �����ϰ� ���� �迭�� ���� �� �迭�� �����Ѵ�
//				String[] temp = new String[member.length+5];
//				for(int j = 0; j<member.length; j++) {
//					temp[j] = member[j];
//				}
//				System.arraycopy(member, 0, temp, 0, member.length);
//				member = temp;
//			}
//			
//		}
//		System.out.println(Arrays.toString(member));
		
		// Collections : List, Set, Map
		// List : ����, �ߺ�����
		// Set : ��������, �ߺ��Ұ�
		// Map : value�� key�� �����Ͽ� ������ ����, �˻� ����
		
		// ����Ʈ ��� ��
//		ArrayList<String> sList = new ArrayList<>();
//		sList.add("��ȣ��");
//		sList.add("�̼���");
//		sList.add("�����");
//		sList.add("�̼���");
//		System.out.println(sList);
//		
//		for(int i = 0; i<sList.size(); i++) {
//			System.out.println(sList.get(i));
//			if(sList.get(i).equals("�����")) {
//				System.out.printf("%d. %s \n",i+1, sList.get(i));
//			}
//		}
//		
//		String msg = sList.contains("ȫ�浿") ? "ȸ�� ����" : "ȸ�� �ƴ�" ;
//		System.out.println(msg);
		
		// set ��� ��(�ߺ��� �Ѱ��� ó��)
//		HashSet<String> set = new HashSet<>();
//		set.add("ȫ�浿");
//		set.add("�����");
//		set.add("ȫ�浿");
//		
//		Iterator<String> it = set.iterator();
//		while(it.hasNext()) {
//			String s = it.next();
//			System.out.println(s);
//		}
//		System.out.println(set.toString());
		
		// map ��� ��
//		HashMap<String, String> mem = new HashMap<>();
//		mem.put("id1", "ȫ�浿");
//		mem.put("id2", "�����");
//		mem.put("id3", "ȫ�浿");
//
//		System.out.println(mem.toString());
//		
//		String name = mem.get("id3");
//		System.out.printf("id=%s, name=%s \n","id3", name);
//		
//		Set<String> keys = mem.keySet();
//		Iterator<String> it = keys.iterator();
//		while(it.hasNext()) {
//			String key = it.next();
//			System.out.println(key);
//			System.out.println(mem.get(key));
//		}
		
		// List�� ������ ������ �� ������?
		// int -> Integer
//		Integer i = Integer.valueOf(100);
//		ArrayList<Integer> numList = new ArrayList<>();
//		numList.add(i);
//		numList.add(200); // int -> Integer ��ȯ, Auto-Boxing
//		
//		Integer intg = numList.get(0);
//		int iv = intg.intValue();
//		System.out.println(iv);
//		
//		int i2 = numList.get(0); // Unboxing
//		System.out.println(i2);
		
		// �� �⺻�� �������� Wrapper
		// byte -> Byte
		// short -> Short
		// int -> Integer
		// long -> Long
		// char -> Character
		// float -> Float
		// double -> Double
		// boolean -> Boolean
		
//		int a = 10;
//		a = Integer.valueOf(20);	// Unboxing
//		Integer iobj = 30;			// Auto-Boxing
	
//		Random rd = new Random();
//		HashSet<Integer> sf = new HashSet<>();
//		
//		while(sf.size() < 5) {
//			sf.add(rd.nextInt(10)+1);
//
//		}
//		System.out.println(sf.toString());
//		Iterator<Integer> it = sf.iterator();
//		while(it.hasNext()) {
//			int i = it.next();
//			System.out.print(i+" ");
//		}
		
		
//		Random rd = new Random();
//		HashSet<Character> sc = new HashSet<>();
//		
//			if((rd.nextInt(2)) == 0) {
//				while(sc.size() < 10) {
//					sc.add((char)(rd.nextInt(26)+65));
//				}
//			} else {
//				while(sc.size() < 10) {
//					sc.add((char)(rd.nextInt(26)+97));
//				}
//			}
//			
//		System.out.println(sc.toString());
		
		
//		ArrayList<String> sl = new ArrayList<String>();
//		sl.add("A");
//		Object obj = new ArrayList<>();
//		sl = (ArrayList<String>)obj;
		
//		ArrayList<String> sl = new ArrayList<String>();
//		List<String> l = new ArrayList<String>();
		
		Product p1 = new Product("������","�Ｚ","2021-12-06",10000);
		Product p2 = new Product("g102", "������", "2021-09-07", 2000);
		Product p3 = new Product("�����","���ѱ�","2021-10-22", 200);
		Product p4 = new Product("�Ƹ޸�ī��", "��Ÿ����", "2021-12-06", 400);
		Product p5 = new Product("���Ÿ��̽���", "����", "2021-03-10", 3000);
		ArrayList<Product> pp = new ArrayList<>();
		
		pp.add(p1);
		pp.add(p2);
		pp.add(p3);
		pp.add(p4);
		pp.add(p5);
		
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i<pp.size(); i++) {
			System.out.println(pp.get(i).getName()+" "+ pp.get(i).getMadeBy()+"  "+ pp.get(i).getDate()+"  "+ pp.get(i).getPrice());			
		}
		while(true) {
			System.out.println("���(s), �˻�(f), �߰�(a), ����(u), ����(d), ����(x): ");
			String input = sc.next();
			sc.nextLine();
			if(input.equals("x")) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			} else if(input.equals("s")) {
				for(int i = 0; i<pp.size(); i++) {
					System.out.println(pp.get(i).getName()+" "+ pp.get(i).getMadeBy()+" "+ pp.get(i).getDate()+" "+ pp.get(i).getPrice());			
				}			
			} else if(input.equals("f")) {
				System.out.println("��ǰ���� �Է����ּ���: ");
				String p_name = sc.next();
				sc.nextLine();
				int temp = 0;
				for(int i = 0; i<pp.size(); i++) {
					if(pp.get(i).getName().equals(p_name)) {
						System.out.println(pp.get(i).getName()+" "+ pp.get(i).getMadeBy()+" "+ pp.get(i).getDate()+" "+ pp.get(i).getPrice());
						temp ++;
					} 
				} if(temp==0) {
					System.out.println("�ش� ��ǰ�� �����ϴ�");
				}
			} else if(input.equals("a")) {
				System.out.println("�߰��Ͻ� ��ǰ���� �Է����ּ���: ");
				String p_name = sc.next();
				System.out.println("�ش��ǰ�� �����縦 �Է����ּ���: ");
				String p_madeBy = sc.next();
				System.out.println("�ش��ǰ�� �������� �Է����ּ���: ");
				String p_date = sc.next();
				System.out.println("�ش��ǰ�� ������ �Է����ּ���: ");
				int p_price = sc.nextInt();
				sc.nextLine();
				
				pp.add(new Product(p_name, p_madeBy, p_date, p_price));
				System.out.println(p_name+"��(��) �߰��Ǿ����ϴ�.");
			} else if(input.equals("d")) {
				System.out.println("������ ��ǰ���� �Է����ּ���: ");
				String p_name = sc.next();
				sc.nextLine();
				for(int i = 0; i<pp.size(); i++) {
					if(pp.get(i).getName().equals(p_name)) {
						pp.remove(i);
						System.out.println(p_name+"��(��) �����Ǿ����ϴ�.");
					}
				}
			} else if(input.equals("u")) {
				System.out.println("������ ��ǰ���� �Է����ּ���: ");
				String p_name = sc.next();
				sc.nextLine();
				for(int i = 0; i<pp.size(); i++) {
					if(pp.get(i).getName().equals(p_name)) {
						pp.remove(i);
					}
				}
				System.out.println("����� ��ǰ���� �Է����ּ���");
				p_name = sc.next();
				System.out.println("����� ��ǰ�� �����縦 �Է����ּ���: ");
				String p_madeBy = sc.next();
				System.out.println("����� ��ǰ�� �������� �Է����ּ���: ");
				String p_date = sc.next();
				System.out.println("����� ��ǰ�� ������ �Է����ּ���: ");
				int p_price = sc.nextInt();
				sc.nextLine();
				
				pp.add(new Product(p_name, p_madeBy, p_date, p_price));
				System.out.println(p_name+"��(��) ����Ǿ����ϴ�.");
			} else {
				System.err.println("�ش� �޴��� �����ϴ�. �ٽ� �Է����ּ���");
			}
		}
		System.out.println("���α׷� ����");

	}
}

