package com.test1;

import java.util.*;

public class Collection_main_T {
	//static List<Product> p = init();
	
	public static void main(String[] args) 
	{
		// Java Collections
		// 다수개의 자바 객체(Object)를 저장할 수 있는 자료구조(Data Structures)
		// 배열의 단점을 극복하고 다양한 활용법을 제공하는 자료구조
		// 배열의 특징은 사용하기 전에 반드시 그 공간을 확보해야 한다는 점
		// 이용자가 'x' 키를 누를 때까지 데이터를 입력 받아서 배열에 저장하는 경우
		
		// 배열을 이용한 입력 데이터 저장하기
		// 키보드에서 회원의 이름을 입력 받아서 배열에 저장한다
		// 반복해서 다수의 회원명을 입력하다가 
		// 이용자가 회원의 이름이 아닌 'x' 키를 누르면 입력이 종료되고
		// 그 때까지 입력된 회원의 이름을 화면에 표시해보세요.
		/*
		Scanner kbd = new Scanner(System.in);
		String[] mem = new String[5];
		int i = 0;
		while(true) {
			System.out.print("회원명:");
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
		/* List : 순서, 중복허용
		 * Set : 무순, 중복불허
		 * Map : value에 key를 연결하여 쌍으로 저장, 검색성능 탁월
		 */
		
		/*
		// 리스트 사용 예
		ArrayList<String> sList = new ArrayList<>();
		sList.add("강호동");
		sList.add("이수근");
		sList.add("손흥민");
		sList.add("이수근");
		
		System.out.println(sList.toString());
		
		for(int i=0; i<sList.size(); i++) {
			//System.out.print(sList.get(i) + " ");
			if(sList.get(i).equals("손흥민")) {
				System.out.printf("%d. %s \n", i+1, sList.get(i));
			}
		}
		
		String msg = sList.contains("홍길동") ? "홍길동은 회원 맞음" : "홍길동은 명단에 없음";
		System.out.println(msg);
		*/
		
		// Set : 무순, 중복불허
		/*
		HashSet<String> set = new HashSet<>();
		set.add("손흥민");
		set.add("홍길동");
		set.add("홍길동");
		
		System.out.println(set.toString());
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String v = it.next();
			System.out.print(v + " ");
		}
		*/
		//Map : key, value를 쌍으로 연결하여 저장
		/*
		HashMap<String, String> mem = new HashMap<>();
		mem.put("id1", "홍길동");
		mem.put("id2", "손흥민");
		mem.put("id3", "홍길동");
		
		System.out.println(mem.toString());
		
		String name = mem.get("id3");
		System.out.printf("id=%s, name=%s \n", "id3", name);
		
		Set<String> keys = mem.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			//System.out.print(key + " ");
			//위에서 구한 key를 사용하여 모든 value를 표시해보세요.
			String value = mem.get(key);
			System.out.print(value + " ");
		}
		*/
		
		// List에 정수를 저장할 수 있을까?
		/*
		// int -> Integer
		Integer i = Integer.valueOf(100);  // int -> Integer변환
		ArrayList<Integer> numList = new ArrayList<>();
		numList.add(i);
		numList.add(200);  // int->Integer 변환, Auto-Boxing
		
		//Integer intg = numList.get(0);
		//int iv = intg.intValue();
		
		int i2 = numList.get(0);  // Unboxing
		*/
		/* 각 기본형 데이터의 Wrapper 클래스
		 * byte -> Byte
		 * short -> Short
		 * int -> Integer
		 * long -> Long
		 * char -> Character
		 * float -> Float
		 * double -> Double
		 * boolean -> Boolean
		 */
		
		// Auto-Boxing, Unboxing 의 예
		/*
		int a = 10;
		a = Integer.valueOf(20);  // Unboxing
		Integer iobj = 30;        // Auto-Boxing
		*/
		
		// 무작위 정수(1~10)를 5개를 중복되지 않도록 컬렉션에 저장해보세요.
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
		
		// 영문 알파벳 문자 10개를 중복되지 않도록 추출하여 표시해보세요.
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
		
		/* Collection API를 활용한 CRUD(Create, Read, Update, Delete)
		 * Product 클래스 선언(상품명, 제조사, 제조일, 가격)
		 * 프로그램이 시작되면 상품정보 리스트(5개)가 화면에 표시된다
		 * 리스트 하단에는 이용자 메뉴가 한 행으로 표시되고 선택을 입력하게 한다
		 * 메뉴 예시) 목록(s), 검색(f), 추가(a), 수정(u), 삭제(d), 종료(x):
		 * s : 목록을 보여준다
		 * f : 상품명입력: > 해당 상품을 검색하여 그 결과를 보여준다
		 * a : 상품명 제조사 제조일 가격: 입력 받고 Product객체 생성 > 컬렉션에 저장
		 * u : 수정할 상품명 > 상품의 새정보 입력 > 컬렉션에서 기존 정보 변경
		 * d : 상품명을 입력 받아서 해당 상품정보를 컬렉션에서 삭제
		 * 모든 메뉴가 실행된 후에는 메뉴가 하단에 다시 보여져야 한다
		 * 이용자가 'x' 를 입력할 때만 프로그램이 종료한다
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
					System.err.println("검색 결과가 없습니다");
				}
			}else if(m.equals("a")) {
				add();
			}else if(m.equals("u")) {
				update(); // 검색/수정
			}else if(m.equals("d")) {
				delete();
			}
		}
		System.out.println("프로그램 종료...");
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
		System.out.print("목록(s), 검색(f), 추가(a), 수정(u), 삭제(d), 종료(x):");
		Scanner kbd = new Scanner(System.in);
		String input = kbd.nextLine();
		return input;
	}
	
	static void list(List<Product> list) {
		System.out.println("\t 상 품 목 록");
		System.out.println("===================================");
		
		for(int i=0;i<list.size();i++) {
			list.get(i).print();
		}
	}
	
	static Product find() {
		Scanner kbd = new Scanner(System.in);
		System.out.print("상품명:");
		String pName = kbd.nextLine();
		for(int i=0;i<p.size();i++) {
			if(p.get(i).getName().equals(pName)) {
				return p.get(i);
			}
		}
		return null;
	}
	
	static void print(Product product) {
		System.out.println("\t검색된 상품 정보");
		product.print();
		System.out.println("---------------------------------------");
	}
	
	static void add() {
		Scanner kbd = new Scanner(System.in);
		System.out.print("추가할 상품명 제조사 제조일 가격:");
		String pName = kbd.next();
		String maker = kbd.next();
		String date = kbd.next();
		int price = Integer.valueOf(kbd.nextLine().trim());
		p.add( new Product(pName,maker,date,price));
	}
	
	static void update() {
		Scanner kbd = new Scanner(System.in);
		System.out.print("수정할 상품명:");
		String pName = kbd.nextLine().trim();
		Product updateProd = null;
		for(int i=0;i<p.size();i++) {
			if(p.get(i).getName().equals(pName)) {
				updateProd = p.get(i);
				break;
			}
		}
		if(updateProd!=null) {
			System.out.print("새 제조사, 새 제조일, 새 가격:");
			String newMaker = kbd.next();
			String newDate = kbd.next();
			int newPrice = Integer.parseInt(kbd.nextLine().trim());
			updateProd.setMadeBy(newMaker);
			updateProd.setDate(newDate);
			updateProd.setPrice(newPrice);
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
		}
	}
	
	static void delete() {
		Scanner kbd = new Scanner(System.in);
		System.out.print("삭제할 상품명:");
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
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
		}
	}
}


