package com.test1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


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


public class Collection_test {

	// �ʱ� �� ���������� ���ϰ� ���� ���ؼ�
	static List<Product> p = init();
	
	// �ʱ� ��
	static List<Product> init() {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product("������","�Ｚ","2021-12-06",10000));
		list.add(new Product("g102", "������", "2021-09-07", 2000));
		list.add(new Product("�����","���ѱ�","2021-10-22", 200));
		list.add(new Product("�Ƹ޸�ī��", "��Ÿ����", "2021-12-06", 400));
		list.add(new Product("����", "����", "2021-03-10", 3000));

		return list;
	}
	
	// �޴���
	static String menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("----------------------------------------------");
		System.out.print("���(s), �˻�(f), �߰�(a), ����(u), ����(d), ����(x): ");
		String m = sc.nextLine();
		
		return m;
	}
	
	// ��� ����
	static void list(List<Product> list) {
		System.out.println("----------------------------------------------");
		System.out.println("��ǰ ���");
		for(int i = 0; i<list.size(); i++) {
			list.get(i).print();
		}
	}
	
	// ��� �˻�
	static Product search() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��� ��ǰ���� �Է����ּ���: ");
		String name = sc.nextLine();
		
		for(int i = 0; i<p.size(); i++) {
			if(p.get(i).getName().equals(name)) {
				return p.get(i);
			}
		}
		return null;
	}
	
	// ��Ͽ� �� �߰�
	static void add() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("�߰��� ��ǰ���� �Է����ּ���: ");
			String name = sc.next();
			System.out.print("�߰��� ��ǰ�� �����縦 �Է����ּ���: ");
			String madeBy = sc.next();
			System.out.print("�߰��� ��ǰ�� �������� �Է����ּ���: ");
			String date = sc.next();
			System.out.print("�߰��� ��ǰ�� ������ �Է����ּ���: ");
			int price = sc.nextInt();
			sc.nextLine();
			p.add(new Product(name,madeBy,date,price));
		} catch(InputMismatchException ime) {
			System.err.println("�˸��� ���� �Է��ϼ���");
		}

	}
	
	static void update() {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ��ǰ�� �Է����ּ���: ");
		String name = sc.next();
		Product uProduct = null;
		for(int i = 0; i<p.size(); i++) {
			if(p.get(i).getName().equals(name)) {
				uProduct = p.get(i);
				break;
			}
		}
		
		if(uProduct != null) {
			System.out.print("�ٲ� ��ǰ���� �Է����ּ���: ");
			String u_name = sc.next();
			System.out.print("�ٲ� ��ǰ�� �����縦 �Է����ּ���: ");
			String u_madeBy = sc.next();
			System.out.print("�ٲ� ��ǰ�� �������� �Է����ּ���: ");
			String u_date = sc.next();
			System.out.print("�ٲ� ��ǰ�� ������ �Է����ּ���: ");
			int u_price = sc.nextInt();
			
			uProduct.setName(u_name);
			uProduct.setMadeBy(u_madeBy);
			uProduct.setDate(u_date);
			uProduct.setPrice(u_price);
			System.out.println("���� �����߽��ϴ�.");
		} else {
			System.out.println("���� �����߽��ϴ�.");
		}
	}
	
	static void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ��ǰ���� �Է����ּ���: ");
		String name = sc.nextLine();
		Product dProduct = null;
		
		for(int i = 0; i<p.size(); i++) {
			if(p.get(i).getName().equals(name)) {
				dProduct = p.get(i);
				break;
			}
		}
		if(dProduct != null) {
			p.remove(dProduct);
			System.out.println("���� �����߽��ϴ�.");
			
		} else {
			System.out.println("���� �����߽��ϴ�.");
		} 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean go = true;
		
		
//		list(init());
		list(p);
		
		while(go) {
			String m = menu();
			if(m.equals("x")) {
				System.out.println("�ý����� �����մϴ�");
				go = false;
			} else if(m.equals("s")) {
				list(p);
			} else if(m.equals("f")) {
				Product s = search();
				if(s != null) {
					s.print();
				} else {
					System.err.println("�ش� ��ǰ�� �����ϴ�.");
				}
			} else if(m.equals("a")) {
				add();
			} else if(m.equals("u")) {
				update();
			} else if(m.equals("d")) {
				delete();
			} else {
				System.err.println("�ش� �޴��� �����ϴ� �ٽ� �Է����ּ���.");
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}