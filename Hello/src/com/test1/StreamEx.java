//package com.test1;
//
//import java.io.*;
//import java.util.*;
//
//// �ؽ�Ʈ ����(member.txt)�� ������� CRUD ����
//// ���α׷��� ���۵Ǹ� ȭ�鿡 ȸ����� 5�� ������ ǥ��
//// ����Ʈ �ϴܿ� �޴��� ǥ��(���(s), �˻�(f), �߰�(a), ����(u), ����(d), ����(x))
//// �ؽ�Ʈ ���Ͽ� ����� ������ ���� : id|name|phone|email
//
//public class StreamEx {
//
//	static File src = new File("C:/Users/ysmin/Javatest/member.txt");
//	
//	static List<Member> loadList() throws Exception{
//		FileReader fr = new FileReader(src);
//		BufferedReader br = new BufferedReader(fr);
//		String line = null;
//		List<Member> list = new ArrayList<Member>();
//		while(( line = br.readLine()) != null) {
//			String[] token = line.split("\\|");
//			int id = Integer.parseInt(token[0]);
//			list.add(new Member(id, token[1], token[2], token[3]));
//		}
//		br.close();
//		return list;
//	}
//	
//	static void showList(List<Member> list) {
//		for(int i = 0; i<list.size(); i++) {
//			list.get(i).printMem();
//		}
//	}
//	
//	static String menu() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("���(s), �˻�(f), �߰�(a), ����(u), ����(d), ����(x): ");
//		String m = sc.nextLine().trim();
//		return m;
//	}
//	
//	static List<Member> deleteList() {
//		List<Member> list = new ArrayList<Member>();
//		try {
//			list = loadList();
//			FileWriter fw = new FileWriter(src);
//			
//			Scanner sc = new Scanner(System.in);
//			System.out.println("������ �̸��� �Է����ּ���: ");
//			String m = sc.nextLine().trim();
//			
//
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		list.get(0).printMem();
//		return null;
//	}
//	
//	static Member find() throws Exception{
//		Scanner sc = new Scanner(System.in);
//		System.out.println("�˻��� ��ȣ�� �Է����ּ��� ");
//		int m = sc.nextInt();
//		
//		return null;
//	}
//	
//	static void search() {
//		List<Member> list = new ArrayList<Member>();
//		try {
//			list = loadList();
//			
//			Scanner sc = new Scanner(System.in);
//			System.out.println("�˻��� ��ȣ�� �Է����ּ��� ");
//			int m = sc.nextInt();
//			
//			for(int i = 0; i<list.size(); i++) {
//				if(m==list.get(i).id) {
//					list.get(i).printMem();
//					break;
//				} else {
//					System.err.println("���� ��ȣ�Դϴ�. �ٽ� �Է����ּ���");
//				}
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	static boolean add() {
//
//			Scanner sc = new Scanner(System.in);
//			System.out.println("�߰��� ��ȣ�� �Է����ּ���: ");
//			int id = sc.nextInt();
//			System.out.println("�߰��� �̸��� �Է����ּ���: ");
//			String name = sc.next();
//			System.out.println("�߰��� ��ȭ��ȣ�� �Է����ּ���: ");
//			String phone = sc.next();
//			System.out.println("�߰��� �̸����� �Է����ּ���: ");
//			String email = sc.next();
//			sc.nextLine();
//			
//		return appendFile(new Member(id, name, phone, email));
//	}
//	
//	static boolean appendFile(Member m) {
//		File dest = new File("C:/Users/ysmin/Javatest/member.txt");
//		FileWriter fw = null;
//		try {
//			fw = new FileWriter(dest, true);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.err.println(e.getMessage());
//			return false;
//		}
//		PrintWriter pw = new PrintWriter(fw);
////		String line = String.format("%d|%s|%s|%s", m.id, m.name, m.phone, m.email);
////		pw.println(line);
//		pw.printf("%d|%s|%s|%s\n", m.id, m.name, m.phone, m.email);
//		pw.close();
//		return true;
//	}
//	
//	static boolean update() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("������ ��ȣ�� �Է����ּ���: ");
//		int num = Integer.valueOf(sc.nextLine().trim());
//		try {
//			Member m = search(num);
//			if(m!=null) {
//				System.out.println("���ο� ��ȭ��ȣ�� �Է����ּ���: ");
//				String newPhone = sc.next();
//				System.out.println("���ο� �̸����� �Է����ּ���: ");
//				String newEmail = sc.next();
//				sc.nextLine();
//				//����Ʈ���� ���� �� ����Ʈ�� ������ ���Ͽ� �ݿ�
//				List<Member> list = loadList();
//				for(int i=0; i<list.size(); i++) {
//					if(list.get(i).id == num) {
//						list.get(i).phone = newPhone;
//						list.get(i).email = newEmail;
//					}
//				}
//				return overwrite(list);
//			}
//		} catch(Exception e){
//			System.err.println(e.getMessage());
//		} 
//		return false;
//	}
//	 
//	static boolean overwrite(List<Member> list) {
//		File dest = new File("C:/Users/ysmin/Javatest/member.txt");
//		FileWriter fw = null;
//		try {
//			fw = new FileWriter(dest);
//		} catch (IOException e) {
//			System.err.println(e.getMessage());
//			return false;
//		}
//		PrintWriter pw = new PrintWriter(fw);
//		Member m = null;
//		for(int i=0; i<list.size(); i++) {
//			m = list.get(i);
//			pw.printf("%d|%s|%s|%s\n", m.id, m.name, m.phone, m.email);
//			pw.flush();
//		}
//		pw.close();
//		return true;
//	}
//	
//	static boolean delete() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("������ ��ȣ�� �Է����ּ���: ");
//		int num = Integer.valueOf(sc.nextLine().trim());
//		try {
//			Member m = search(num);
//				List<Member> list = loadList();
//				list.remove(m);
//				return overwrite(list);
//		} catch(Exception e){
//			System.err.println(e.getMessage());
//		} 
//		return false;
//	}
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		
//		
//		try {
//			List<Member> list = loadList();
//			showList(list);
//			boolean go = true;
//			while(go) {
//				String m = menu();
//				switch(m) {
//				case "s": 
//					showList(loadList());
//					break;
//				case "f":
//					search();
//					break;
//				case "a":
//					if(add()) {
//						System.out.println("ȸ������ �߰� ����");
//					} else {
//						System.err.println("ȸ������ �߰� ����");
//					}
//					break;
//				case "u":
//					if(update()) {
//						System.out.println("ȸ������ ���� ����");
//					} else {
//						System.out.println("ȸ������ ���� ����");
//					}
//					break;
//				case "d":
//					if(delete()) {
//						System.out.println("ȸ������ ���� ����");
//					} else {
//						System.out.println("ȸ������ ���� ����");
//					}
//					break;
//				case "x": 
//					System.out.println("���α׷��� ����Ǿ����ϴ�");
//					go = false;
//					break;
//				default :
//					System.err.println("�޴��Է� ����");
//				}
//			}
//			
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}
