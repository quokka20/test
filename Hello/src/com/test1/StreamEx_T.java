package com.test1;

import java.io.*;
import java.util.*;

/* �ؽ�Ʈ ����(member.txt)�� ������� CRUD ����
 * ���α׷��� ���۵Ǹ� ȭ�鿡 ȸ����� 5�������� ǥ�õȴ�
 * ����Ʈ �ϴܿ� �޴��� ǥ�õȴ�(���(s), �˻�(f), �߰�(a), ����(u), ����(d), ����(x))
 * �ؽ�Ʈ ���Ͽ� ����� ������ ���� : num|name|phone|email
 */
public class StreamEx_T 
{
	static File src = new File("D:/JavaTest/member.txt");
	
	static List<Member> loadList() throws Exception {
		FileReader fr = new FileReader(src);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		List<Member> list = new ArrayList<>();
		while((line=br.readLine())!=null) {
			String[] token = line.split("\\|");
			// Integer.parseInt�� ����ؼ� token[0]�κп� String���� ���� �� int�� ��ȯ
			int num = Integer.parseInt(token[0]);
			list.add(new Member(num, token[1], token[2], token[3]));
		}
		br.close();
		return list;
	}
	
	static void showList(List<Member> list) {
		for(int i=0;i<list.size();i++) {
			list.get(i).printMem();
		}
	}
	
	static String menu() {
		System.out.println("------------------------------------------------");
		Scanner kbd = new Scanner(System.in);
		System.out.print("���(s), �˻�(f), �߰�(a), ����(u), ����(d), ����(x):");
		String m = kbd.nextLine().trim();
		System.out.println("------------------------------------------------");
		return m;
	}
	
	static Member find() throws Exception {
		Scanner kbd = new Scanner(System.in);
		System.out.print("�˻��� ȸ����ȣ:");
		int num = Integer.parseInt(kbd.nextLine().trim());
		return search(num);
	}
	
	static Member search(int num) throws Exception {
		List<Member> list = loadList();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).num == num) {
				return list.get(i);
			}
		}
		throw new Exception("��ȣ�� �˻� ����");
	}
	
	static boolean add() {
		Scanner kbd = new Scanner(System.in);
		System.out.print("��ȣ �̸� ��ȭ ����:");
		int num = kbd.nextInt();
		String name = kbd.next();
		String phone = kbd.next();
		String email = kbd.nextLine().trim();
		return appendFile(new Member(num,name,phone,email));
	}
	
	static boolean appendFile(Member m) {
		File dest = new File("D:/JavaTest/member.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(dest, true);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return false;
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.printf("%d|%s|%s|%s\n", m.num, m.name, m.phone, m.email);
		pw.close();
		return true;
	}
	
	static boolean update() {
		Scanner kbd = new Scanner(System.in);
		System.out.print("������ ȸ����ȣ:");
		int num = Integer.valueOf(kbd.nextLine().trim());
		try {
			Member m = search(num);
			if(m!=null) {
				System.out.print("�� ��ȭ��ȣ �� �̸���:");
				String newPhone = kbd.next();
				String newEmail = kbd.nextLine().trim();
				List<Member> list = loadList();
				for(int i=0;i<list.size();i++) {
					if(list.get(i).num == num) {
						list.get(i).phone = newPhone;
						list.get(i).email = newEmail;
					}
				}
				return overwrite(list);  // ���� ���Ͽ� �����
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	
	static boolean overwrite(List<Member> list)  {
		File dest = new File("D:/JavaTest/member.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(dest);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return false;
		}
		PrintWriter pw = new PrintWriter(fw);
		Member m = null;
		for(int i=0;i<list.size();i++) {
			m = list.get(i);
			pw.printf("%d|%s|%s|%s\n", m.num, m.name, m.phone, m.email);
			pw.flush();
		}
		pw.close();
		return true;
	}
	
	static boolean delete() {
		Scanner kbd = new Scanner(System.in);
		System.out.print("������ ȸ����ȣ:");
		int num = Integer.valueOf(kbd.nextLine().trim());
		try {
			Member m = search(num);
			List<Member> list = loadList();
			list.remove(m);
			System.out.println("���Ҽ�:"+list.size());
			return overwrite(list);  // ���� ���Ͽ� �����
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	
	public static void main(String[] args) 
	{
		List<Member> list = null;
		try {
			list = loadList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		showList(list);
		
		boolean go = true;
		while(go) 
		{
			String m = menu();
			try {
				switch(m) {
				case "s":
					showList( loadList() );
					break;
				case "f":
					find().printMem();
					break;
				case "a":
					if(add()) System.out.println("ȸ������ �߰� ����!");
					else System.err.println("ȸ������ �߰� ����!!!");
					break;
				case "u":
					//��� ȸ�� ����? -> ����Ʈ -> ������� Member��ü ã��
					//�˻��� Member��ü�� �� ��ȭ, �� �̸����� ����
					//����Ʈ -> ���Ͽ� �����
					if(update()) System.out.println("ȸ������ ���� ����!");
					else System.err.println("ȸ������ ���� ����!!!");
					break;
				case "d":
					if(delete()) System.out.println("ȸ������ ���� ����!");
					else System.err.println("ȸ������ ���� ����!!!");
					break;
				case "x":
					go = false;
					break;
				default:
					System.err.println("�޴��Է� ����");
				}
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}	
		}
		
		System.out.println("���α׷� ����...");
	}
}
