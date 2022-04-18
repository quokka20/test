package com.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ObjectInputStream / ObjectOutputStream
// FileInputStream / FileOutputStream
// List<Member>
// ���α׷� ���۵Ǹ� Member 5���� ���� ����� ǥ�õǰ� �޴��� �ϴܿ� ǥ��



public class ObjectStreamEx {
	
	static File src = new File("C:/Users/ysmin/Javatest/member.obj");
	
	
	static void init() {
		List<Member> list = new ArrayList<>();
		list.add(new Member(11,"�����","010-1111-1111","son@gmail.com"));
		list.add(new Member(12,"ȫâ��","010-2222-2222","hong@gmail.com"));
		list.add(new Member(13,"�߽ż�","010-3333-3333","chu@gmail.com"));
		list.add(new Member(14,"�̽¿�","010-4444-4444","lee@gmail.com"));
		list.add(new Member(15,"������","010-5555-5555","ryu@gmail.com"));

		try {
			FileOutputStream  fout = new FileOutputStream(src);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(list);
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static List<Member> loadList() {
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(src));
			ArrayList<Member> list = (ArrayList<Member>) ois.readObject();
			ois.close();
			
			return list;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("loadList() ����");
			return null;
		}
		
	}
	
	static void print(List<Member> list) {
		System.out.println("-----------------------------------------------");
		for(int i = 0; i<list.size(); i++) {
			list.get(i).printMem();
		}
	}
	
	static int find() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��� ��ȣ�� �Է����ּ���: ");
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}
	
	static Member search(int num, List<Member> list) throws Exception {
		for(int i =0; i<list.size(); i++) {
			if(list.get(i).num == num) {
				return list.get(i);
			}
		}
		throw new Exception("���� ȸ����ȣ�Դϴ�.");
	}

	static String menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------------------------------------------");
		System.out.print("���(s), �˻�(f), �߰�(a), ����(u), ����(d), ����(x):");
		String m = sc.nextLine();
		return m;
	}
	
	static List<Member> addInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�߰��� ��ȣ�� �Է����ּ���: ");
		int num = sc.nextInt();
		System.out.print("�߰��� �̸��� �Է����ּ���: ");
		String name = sc.next();
		System.out.print("�߰��� ��ȭ�� �Է����ּ���: ");
		String phone = sc.next();
		System.out.print("�߰��� �̸����� �Է����ּ���: ");
		String email = sc.next();
		sc.nextLine();
		
		List<Member> list = loadList();
		list.add(new Member(num,name,phone,email));
		return list;
	}
	
	static void add(List<Member> list) {
		
		try {
			FileOutputStream fout = new FileOutputStream(src);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(list);
			oos.close();
			System.out.println("�����Ͽ����ϴ�");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("�����Ͽ����ϴ�");
		}
		
	}
	
	static List<Member> updateInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ��ȣ�� �Է��ϼ���: ");
		int num = sc.nextInt();
		sc.nextLine();
		List<Member> list = loadList();
		try {
			Member m = search(num,list);
			if(m != null) {
				System.out.println("������ �̸��� �Է��ϼ���: ");
				String uName = sc.next();
				System.out.println("������ ��ȭ�� �Է��ϼ���: ");
				String uPhone = sc.next();
				System.out.println("������ �̸����� �Է��ϼ���: ");
				String uEmail = sc.next();
				sc.nextLine();
				for(int i = 0; i<list.size(); i++) {
					if(list.get(i).num == m.num) {
						list.get(i).name = uName;
						list.get(i).phone = uPhone;
						list.get(i).email = uEmail;
						break;
					}
				}
				return list;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	static List<Member> delete() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ��ȣ�� �Է����ּ���: ");
		int num = sc.nextInt();
		sc.nextLine();
		List<Member> list = loadList();
		search(num,list);
		for(int i =0; i<list.size(); i++) {
			if(list.get(i).num == num) {
				list.remove(i);
				break;
			}
		}
		
		return list;
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean go = true;
		init();
		print(loadList());
		while(go) {
			try {
				switch(menu()) {
				case "x":
					go = false;
					System.out.println("����Ǿ����ϴ�");
					break;
				case "s" :
					print(loadList());
					break;
				case "f" :
					search(find(),loadList()).printMem();
					break;
				case "a" :
					add(addInfo());
					break;
				case "u" :
					add(updateInfo());
					break;
				case "d" :
					add(delete());
					break;
				default :
					System.err.println("�߸��� �޴� Ű�� �Է��߽��ϴ�");
				}
			} catch(Exception e) {
				System.err.println(e.getMessage());
			}
			
		}
		
	}

}
