package com.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Collection_main {

	public static void main(String[] args) {
		// Java Collections
		// 다수개의 객체를 저장할 수 있는 자료구조(Data structures)
		// 배열의 단점을 극복하고 다양한 활용법을 제공하는 자료구조
		// 배열의 특징은 사용하기 전에 반드시 그 공간을 확보해야 됨
		// 이용자가 'x' 키를 누를 때까지 데이터를 입력 받아서 배열에 저장하는 경우
		
//		Scanner sc = new Scanner(System.in);
//		String[] member = new String[5];
//		int i =0;
//		while(true) {
//			System.out.println("회원이름을 입력해주세요: ");
//			String name = sc.nextLine();
//			if(name.equals("x")) {
//				break;
//			}
//			member[i++] = name;
//			if(i==member.length) {
//				// 현재보다 더 큰 배열을 생성하고 기존 배열의 값을 새 배열에 복사한다
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
		// List : 순서, 중복가능
		// Set : 순서없음, 중복불가
		// Map : value에 key를 연결하여 쌍으로 저장, 검색 용이
		
		// 리스트 사용 예
//		ArrayList<String> sList = new ArrayList<>();
//		sList.add("강호동");
//		sList.add("이수근");
//		sList.add("손흥민");
//		sList.add("이수근");
//		System.out.println(sList);
//		
//		for(int i = 0; i<sList.size(); i++) {
//			System.out.println(sList.get(i));
//			if(sList.get(i).equals("손흥민")) {
//				System.out.printf("%d. %s \n",i+1, sList.get(i));
//			}
//		}
//		
//		String msg = sList.contains("홍길동") ? "회원 맞음" : "회원 아님" ;
//		System.out.println(msg);
		
		// set 사용 예(중복은 한개로 처리)
//		HashSet<String> set = new HashSet<>();
//		set.add("홍길동");
//		set.add("손흥민");
//		set.add("홍길동");
//		
//		Iterator<String> it = set.iterator();
//		while(it.hasNext()) {
//			String s = it.next();
//			System.out.println(s);
//		}
//		System.out.println(set.toString());
		
		// map 사용 예
//		HashMap<String, String> mem = new HashMap<>();
//		mem.put("id1", "홍길동");
//		mem.put("id2", "손흥민");
//		mem.put("id3", "홍길동");
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
		
		// List에 정수를 저장할 수 있을까?
		// int -> Integer
//		Integer i = Integer.valueOf(100);
//		ArrayList<Integer> numList = new ArrayList<>();
//		numList.add(i);
//		numList.add(200); // int -> Integer 변환, Auto-Boxing
//		
//		Integer intg = numList.get(0);
//		int iv = intg.intValue();
//		System.out.println(iv);
//		
//		int i2 = numList.get(0); // Unboxing
//		System.out.println(i2);
		
		// 각 기본형 데이터의 Wrapper
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
		
		Product p1 = new Product("갤럭시","삼성","2021-12-06",10000);
		Product p2 = new Product("g102", "로지텍", "2021-09-07", 2000);
		Product p3 = new Product("진라면","오뚜기","2021-10-22", 200);
		Product p4 = new Product("아메리카노", "스타벅스", "2021-12-06", 400);
		Product p5 = new Product("예거마이스터", "독일", "2021-03-10", 3000);
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
			System.out.println("목록(s), 검색(f), 추가(a), 수정(u), 삭제(d), 종료(x): ");
			String input = sc.next();
			sc.nextLine();
			if(input.equals("x")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if(input.equals("s")) {
				for(int i = 0; i<pp.size(); i++) {
					System.out.println(pp.get(i).getName()+" "+ pp.get(i).getMadeBy()+" "+ pp.get(i).getDate()+" "+ pp.get(i).getPrice());			
				}			
			} else if(input.equals("f")) {
				System.out.println("상품명을 입력해주세요: ");
				String p_name = sc.next();
				sc.nextLine();
				int temp = 0;
				for(int i = 0; i<pp.size(); i++) {
					if(pp.get(i).getName().equals(p_name)) {
						System.out.println(pp.get(i).getName()+" "+ pp.get(i).getMadeBy()+" "+ pp.get(i).getDate()+" "+ pp.get(i).getPrice());
						temp ++;
					} 
				} if(temp==0) {
					System.out.println("해당 상품이 없습니다");
				}
			} else if(input.equals("a")) {
				System.out.println("추가하실 상품명을 입력해주세요: ");
				String p_name = sc.next();
				System.out.println("해당상품의 제조사를 입력해주세요: ");
				String p_madeBy = sc.next();
				System.out.println("해당상품의 제조일을 입력해주세요: ");
				String p_date = sc.next();
				System.out.println("해당상품의 가격을 입력해주세요: ");
				int p_price = sc.nextInt();
				sc.nextLine();
				
				pp.add(new Product(p_name, p_madeBy, p_date, p_price));
				System.out.println(p_name+"이(가) 추가되었습니다.");
			} else if(input.equals("d")) {
				System.out.println("삭제할 상품명을 입력해주세요: ");
				String p_name = sc.next();
				sc.nextLine();
				for(int i = 0; i<pp.size(); i++) {
					if(pp.get(i).getName().equals(p_name)) {
						pp.remove(i);
						System.out.println(p_name+"이(가) 삭제되었습니다.");
					}
				}
			} else if(input.equals("u")) {
				System.out.println("수정할 상품명을 입력해주세요: ");
				String p_name = sc.next();
				sc.nextLine();
				for(int i = 0; i<pp.size(); i++) {
					if(pp.get(i).getName().equals(p_name)) {
						pp.remove(i);
					}
				}
				System.out.println("변경된 상품명을 입력해주세요");
				p_name = sc.next();
				System.out.println("변경된 상품의 제조사를 입력해주세요: ");
				String p_madeBy = sc.next();
				System.out.println("변경된 상품의 제조일을 입력해주세요: ");
				String p_date = sc.next();
				System.out.println("변경된 상품의 가격을 입력해주세요: ");
				int p_price = sc.nextInt();
				sc.nextLine();
				
				pp.add(new Product(p_name, p_madeBy, p_date, p_price));
				System.out.println(p_name+"이(가) 변경되었습니다.");
			} else {
				System.err.println("해당 메뉴가 없습니다. 다시 입력해주세요");
			}
		}
		System.out.println("프로그램 종료");

	}
}

