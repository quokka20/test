package com.test1;

import java.util.*;

public class Collection_main_T {
	//static List<Product> p = init();
	
	public static void main(String[] args) 
	{
		// Java Collections
		// �ټ����� �ڹ� ��ü(Object)�� ������ �� �ִ� �ڷᱸ��(Data Structures)
		// �迭�� ������ �غ��ϰ� �پ��� Ȱ����� �����ϴ� �ڷᱸ��
		// �迭�� Ư¡�� ����ϱ� ���� �ݵ�� �� ������ Ȯ���ؾ� �Ѵٴ� ��
		// �̿��ڰ� 'x' Ű�� ���� ������ �����͸� �Է� �޾Ƽ� �迭�� �����ϴ� ���
		
		// �迭�� �̿��� �Է� ������ �����ϱ�
		// Ű���忡�� ȸ���� �̸��� �Է� �޾Ƽ� �迭�� �����Ѵ�
		// �ݺ��ؼ� �ټ��� ȸ������ �Է��ϴٰ� 
		// �̿��ڰ� ȸ���� �̸��� �ƴ� 'x' Ű�� ������ �Է��� ����ǰ�
		// �� ������ �Էµ� ȸ���� �̸��� ȭ�鿡 ǥ���غ�����.
		/*
		Scanner kbd = new Scanner(System.in);
		String[] mem = new String[5];
		int i = 0;
		while(true) {
			System.out.print("ȸ����:");
			String name = kbd.nextLine();
			if(name.equals("x")) break;
			mem[i++] = name;
			if(i==mem.length) {
				String[] tmp = new String[mem.length+5];
				System.arraycopy(mem, 0, tmp, 0, mem.length);
				mem = tmp;
			}
		}
		System.out.println(Arrays.toString(mem));
		*/
		
		//Collections : List, Set, Map
		/* List : ����, �ߺ����
		 * Set : ����, �ߺ�����
		 * Map : value�� key�� �����Ͽ� ������ ����, �˻����� Ź��
		 */
		
		/*
		// ����Ʈ ��� ��
		ArrayList<String> sList = new ArrayList<>();
		sList.add("��ȣ��");
		sList.add("�̼���");
		sList.add("�����");
		sList.add("�̼���");
		
		System.out.println(sList.toString());
		
		for(int i=0; i<sList.size(); i++) {
			//System.out.print(sList.get(i) + " ");
			if(sList.get(i).equals("�����")) {
				System.out.printf("%d. %s \n", i+1, sList.get(i));
			}
		}
		
		String msg = sList.contains("ȫ�浿") ? "ȫ�浿�� ȸ�� ����" : "ȫ�浿�� ��ܿ� ����";
		System.out.println(msg);
		*/
		
		// Set : ����, �ߺ�����
		/*
		HashSet<String> set = new HashSet<>();
		set.add("�����");
		set.add("ȫ�浿");
		set.add("ȫ�浿");
		
		System.out.println(set.toString());
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String v = it.next();
			System.out.print(v + " ");
		}
		*/
		//Map : key, value�� ������ �����Ͽ� ����
		/*
		HashMap<String, String> mem = new HashMap<>();
		mem.put("id1", "ȫ�浿");
		mem.put("id2", "�����");
		mem.put("id3", "ȫ�浿");
		
		System.out.println(mem.toString());
		
		String name = mem.get("id3");
		System.out.printf("id=%s, name=%s \n", "id3", name);
		
		Set<String> keys = mem.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			//System.out.print(key + " ");
			//������ ���� key�� ����Ͽ� ��� value�� ǥ���غ�����.
			String value = mem.get(key);
			System.out.print(value + " ");
		}
		*/
		
		// List�� ������ ������ �� ������?
		/*
		// int -> Integer
		Integer i = Integer.valueOf(100);  // int -> Integer��ȯ
		ArrayList<Integer> numList = new ArrayList<>();
		numList.add(i);
		numList.add(200);  // int->Integer ��ȯ, Auto-Boxing
		
		//Integer intg = numList.get(0);
		//int iv = intg.intValue();
		
		int i2 = numList.get(0);  // Unboxing
		*/
		/* �� �⺻�� �������� Wrapper Ŭ����
		 * byte -> Byte
		 * short -> Short
		 * int -> Integer
		 * long -> Long
		 * char -> Character
		 * float -> Float
		 * double -> Double
		 * boolean -> Boolean
		 */
		
		// Auto-Boxing, Unboxing �� ��
		/*
		int a = 10;
		a = Integer.valueOf(20);  // Unboxing
		Integer iobj = 30;        // Auto-Boxing
		*/
		
		// ������ ����(1~10)�� 5���� �ߺ����� �ʵ��� �÷��ǿ� �����غ�����.
		/*
		Random rd = new Random();
		HashSet<Integer> numSet = new HashSet<>();
		while(numSet.size()<5) {
			numSet.add( rd.nextInt(10)+1); // Auto-Boxing
		}
		System.out.println(numSet.toString());
		
		Iterator<Integer> it = numSet.iterator();
		while(it.hasNext()) {
			int i = it.next();  //Unboxing
			System.out.print(i + " ");
		}
		*/
		
		// ���� ���ĺ� ���� 10���� �ߺ����� �ʵ��� �����Ͽ� ǥ���غ�����.
		/*
		Random rd = new Random();
		HashSet<Character> charSet = new HashSet<>();
		while(charSet.size()<10) {
			charSet.add((char)(rd.nextInt(26)+97));
		}
		System.out.println(charSet.toString());
		*/
		/*
		ArrayList<String> sList = new ArrayList<>();
		sList.add("A");
		Object obj = new ArrayList<>();
		sList = (ArrayList<String>)obj;
		*/
		
		//ArrayList<String> sList = new ArrayList<>();
		//List<String> list = new ArrayList<>();
		
		/* Collection API�� Ȱ���� CRUD(Create, Read, Update, Delete)
		 * Product Ŭ���� ����(��ǰ��, ������, ������, ����)
		 * ���α׷��� ���۵Ǹ� ��ǰ���� ����Ʈ(5��)�� ȭ�鿡 ǥ�õȴ�
		 * ����Ʈ �ϴܿ��� �̿��� �޴��� �� ������ ǥ�õǰ� ������ �Է��ϰ� �Ѵ�
		 * �޴� ����) ���(s), �˻�(f), �߰�(a), ����(u), ����(d), ����(x):
		 * s : ����� �����ش�
		 * f : ��ǰ���Է�: > �ش� ��ǰ�� �˻��Ͽ� �� ����� �����ش�
		 * a : ��ǰ�� ������ ������ ����: �Է� �ް� Product��ü ���� > �÷��ǿ� ����
		 * u : ������ ��ǰ�� > ��ǰ�� ������ �Է� > �÷��ǿ��� ���� ���� ����
		 * d : ��ǰ���� �Է� �޾Ƽ� �ش� ��ǰ������ �÷��ǿ��� ����
		 * ��� �޴��� ����� �Ŀ��� �޴��� �ϴܿ� �ٽ� �������� �Ѵ�
		 * �̿��ڰ� 'x' �� �Է��� ���� ���α׷��� �����Ѵ�
		*/
		
		boolean go = true;

		while(go) {
			list(p);
			String m = menu();
			if(m.equals("x")) {
				go = false;
			}else if(m.equals("f")) {
				Product res = find();
				if(res!=null) {
					print(res);
				}else {
					System.err.println("�˻� ����� �����ϴ�");
				}
			}else if(m.equals("a")) {
				add();
			}else if(m.equals("u")) {
				update(); // �˻�/����
			}else if(m.equals("d")) {
				delete();
			}
		}
		System.out.println("���α׷� ����...");
	} // end of main()
	
	static List<Product> p = init();
	
	static List<Product> init(){
		List<Product> list = new ArrayList<>();
		list.add(new Product("Labtop1","Lenova","2010-12-05", 100));
		list.add(new Product("Tablet","LG Elec","2013-10-12", 100));
		list.add(new Product("Desktop","Samsung","2020-04-23", 100));
		list.add(new Product("Tablet2","Lenova","2016-02-14", 100));
		list.add(new Product("Labtop2","Samsung","2020-11-11", 100));
		return list;
	}
	
	static String menu() {
		System.out.println("----------------------------------------------");
		System.out.print("���(s), �˻�(f), �߰�(a), ����(u), ����(d), ����(x):");
		Scanner kbd = new Scanner(System.in);
		String input = kbd.nextLine();
		return input;
	}
	
	static void list(List<Product> list) {
		System.out.println("\t �� ǰ �� ��");
		System.out.println("===================================");
		
		for(int i=0;i<list.size();i++) {
			list.get(i).print();
		}
	}
	
	static Product find() {
		Scanner kbd = new Scanner(System.in);
		System.out.print("��ǰ��:");
		String pName = kbd.nextLine();
		for(int i=0;i<p.size();i++) {
			if(p.get(i).getName().equals(pName)) {
				return p.get(i);
			}
		}
		return null;
	}
	
	static void print(Product product) {
		System.out.println("\t�˻��� ��ǰ ����");
		product.print();
		System.out.println("---------------------------------------");
	}
	
	static void add() {
		Scanner kbd = new Scanner(System.in);
		System.out.print("�߰��� ��ǰ�� ������ ������ ����:");
		String pName = kbd.next();
		String maker = kbd.next();
		String date = kbd.next();
		int price = Integer.valueOf(kbd.nextLine().trim());
		p.add( new Product(pName,maker,date,price));
	}
	
	static void update() {
		Scanner kbd = new Scanner(System.in);
		System.out.print("������ ��ǰ��:");
		String pName = kbd.nextLine().trim();
		Product updateProd = null;
		for(int i=0;i<p.size();i++) {
			if(p.get(i).getName().equals(pName)) {
				updateProd = p.get(i);
				break;
			}
		}
		if(updateProd!=null) {
			System.out.print("�� ������, �� ������, �� ����:");
			String newMaker = kbd.next();
			String newDate = kbd.next();
			int newPrice = Integer.parseInt(kbd.nextLine().trim());
			updateProd.setMadeBy(newMaker);
			updateProd.setDate(newDate);
			updateProd.setPrice(newPrice);
			System.out.println("���� ����");
		}else {
			System.out.println("���� ����");
		}
	}
	
	static void delete() {
		Scanner kbd = new Scanner(System.in);
		System.out.print("������ ��ǰ��:");
		String pName = kbd.nextLine().trim();
		Product prod = null;
		for(int i=0;i<p.size();i++) {
			if(p.get(i).getName().equals(pName)) {
				prod = p.get(i);
				break;
			}
		}
		if(prod!=null) {
			if(p.remove(prod)) {
				System.out.println("���� ����");
			}else {
				System.out.println("���� ����");
			}
		}
	}
}


