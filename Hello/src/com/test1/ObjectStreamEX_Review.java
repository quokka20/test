package com.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObjectStreamEX_Review {

	// ObjectInputStream / ObjectOutputStream
	// FileInputStream / FileOutputStream
	// List<Member>
	// ���α׷� ���۵Ǹ� Member 5���� ���� ����� ǥ�õǰ� �޴��� �ϴܿ� ǥ��
	
	//���� �ҽ�
	static File src = new File("C:/Users/ysmin/Javatest/member_test.obj");
	
	// �ʱⰪ ���� �� ������Ʈ�� ����
	static void init() {
		List<Member> list = new ArrayList<>();
		list.add(new Member(1,"���ϵ�","010-1111-1111","first@naver.com"));
		list.add(new Member(2,"�̼���","010-2222-2222","2222@naver.com"));
		list.add(new Member(3,"�ڻ��","010-3333-3333","samsam@naver.com"));
		list.add(new Member(4,"�ֳ���","010-4444-4444","four@naver.com"));
		list.add(new Member(5,"����","010-5555-5555","oioi@naver.com"));
		
		try {
			FileOutputStream fout = new FileOutputStream(src);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			oos.writeObject(list);
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("������Ʈ �ʱⰪ �Է� ����");
		}
	}
	
	// ������Ʈ�� �ִ� ����Ʈ �� ��������
	static List<Member> loadList() {
		try {
			FileInputStream fin = new FileInputStream(src);
			ObjectInputStream ois = new ObjectInputStream(fin);
			List<Member> list = (ArrayList<Member>) ois.readObject();
			ois.close();

			return list;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("loadList() ����");
			return null;
		}
	}
	
	// ����Ʈ�� �� �پ� ����ϱ�
	static void printList(List<Member> list) {
		System.out.println("-----------------------------------------------");
		for(int i = 0; i<list.size(); i++) {
			list.get(i).printMem();
		}
	}
	
	// �޴� ���
	static String menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------------------------------------------");
		System.out.print("���(s), �˻�(f), �߰�(a), ����(u), ����(d), ����(x):");
		String m = sc.next();
		
		return m;
		
	}
	
	static int searchNum() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��Ͻ� ȸ���� ��ȣ�� �Է����ּ���: ");
		int num = sc.nextInt();
		sc.nextLine();
		
		return num;
	}
	
	static Member search(int num) throws Exception {
		List<Member> list = loadList();
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).num == num) {
				return list.get(i);
			}
		}
		throw new Exception("���� ȸ����ȣ�Դϴ�.");
	}
	
	static List<Member> addInfo() {

			Scanner sc = new Scanner(System.in);
			System.out.print("�߰��Ͻ� ȸ���� ��ȣ�� �Է����ּ���: ");
			int num = sc.nextInt();
			System.out.print("�߰��Ͻ� ȸ���� �̸��� �Է����ּ���: ");
			String name = sc.next();
			System.out.print("�߰��Ͻ� ȸ���� ��ȭ�� �Է����ּ���: ");
			String phone = sc.next();
			System.out.print("�߰��Ͻ� ȸ���� �̸����� �Է����ּ���: ");
			String email = sc.next();
			sc.nextLine();
			
			List<Member> list = loadList();
			list.add(new Member(num,name,phone,email));
			
			return list;

	}
	
	static void overwrite(List<Member> list) {
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(src);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			oos.writeObject(list);
			oos.close();
			System.out.println("�����߽��ϴ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("�����߽��ϴ�");
		}
	}
	
	static int deleteNum() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�����Ͻ� ȸ���� ȸ����ȣ�� �Է����ּ���: ");
		int num = sc.nextInt();
		sc.nextLine();
		
		return num;
	}
	
	static List<Member> delete(int num) throws Exception {
		Member m = search(num);
		List<Member> list = loadList();
		list.remove(m);
		return list;
	}
	
	static void updateInfo() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.print("�����Ͻ� ȸ���� ȸ����ȣ�� �Է����ּ���: ");
		int num = sc.nextInt();
		search(num);
		System.out.print("���� ����ϴ� �̸��� �Է����ּ���: ");
		String name = sc.next();
		System.out.print("���� ����ϴ� ��ȭ��ȣ�� �Է����ּ���: ");
		String phone = sc.next();
		System.out.print("���� ����ϴ� �̸����� �Է����ּ���: ");
		String email = sc.next();
	
		List<Member> list = loadList();
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).num== num) {
				list.get(i).name = name;
				list.get(i).phone = phone;
				list.get(i).email = email;
				break;
			}
		}
		overwrite(list);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if(!src.exists()) {
			init();
		}
		List<Member> list = loadList();
		printList(list);
		boolean go = true;
		
		while(go) {
			try {
				switch(menu()) {
				case("x") : System.out.println("���α׷� ����"); go=false; break;
				case("s") : printList(loadList()); break;
				case("f") : search(searchNum()).printMem();
				case("a") : overwrite(addInfo()); break;
				case("u") : updateInfo(); break;
				case("d") : overwrite(delete(deleteNum())); break;
				default : System.err.println("���� �޴��Դϴ� �ٽ� �Է����ּ���");
				}
			} catch(Exception e) {
				System.err.println(e.getMessage());
				
			}
			
		}
		
		
		
		
	}

}
