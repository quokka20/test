package com.test1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


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


public class Collection_test {

	// 초기 값 여러곳에서 편하게 쓰기 위해서
	static List<Product> p = init();
	
	// 초기 값
	static List<Product> init() {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product("갤럭시","삼성","2021-12-06",10000));
		list.add(new Product("g102", "로지텍", "2021-09-07", 2000));
		list.add(new Product("진라면","오뚜기","2021-10-22", 200));
		list.add(new Product("아메리카노", "스타벅스", "2021-12-06", 400));
		list.add(new Product("예거", "독일", "2021-03-10", 3000));

		return list;
	}
	
	// 메뉴바
	static String menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("----------------------------------------------");
		System.out.print("목록(s), 검색(f), 추가(a), 수정(u), 삭제(d), 종료(x): ");
		String m = sc.nextLine();
		
		return m;
	}
	
	// 목록 정보
	static void list(List<Product> list) {
		System.out.println("----------------------------------------------");
		System.out.println("상품 목록");
		for(int i = 0; i<list.size(); i++) {
			list.get(i).print();
		}
	}
	
	// 목록 검색
	static Product search() {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 상품명을 입력해주세요: ");
		String name = sc.nextLine();
		
		for(int i = 0; i<p.size(); i++) {
			if(p.get(i).getName().equals(name)) {
				return p.get(i);
			}
		}
		return null;
	}
	
	// 목록에 값 추가
	static void add() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("추가할 상품명을 입력해주세요: ");
			String name = sc.next();
			System.out.print("추가할 상품의 제조사를 입력해주세요: ");
			String madeBy = sc.next();
			System.out.print("추가할 상품의 제조일을 입력해주세요: ");
			String date = sc.next();
			System.out.print("추가할 상품의 가격을 입력해주세요: ");
			int price = sc.nextInt();
			sc.nextLine();
			p.add(new Product(name,madeBy,date,price));
		} catch(InputMismatchException ime) {
			System.err.println("알맞은 값을 입력하세요");
		}

	}
	
	static void update() {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 상품을 입력해주세요: ");
		String name = sc.next();
		Product uProduct = null;
		for(int i = 0; i<p.size(); i++) {
			if(p.get(i).getName().equals(name)) {
				uProduct = p.get(i);
				break;
			}
		}
		
		if(uProduct != null) {
			System.out.print("바꿀 상품명을 입력해주세요: ");
			String u_name = sc.next();
			System.out.print("바꿀 상품의 제조사를 입력해주세요: ");
			String u_madeBy = sc.next();
			System.out.print("바꿀 상품의 제조일을 입력해주세요: ");
			String u_date = sc.next();
			System.out.print("바꿀 상품의 가격을 입력해주세요: ");
			int u_price = sc.nextInt();
			
			uProduct.setName(u_name);
			uProduct.setMadeBy(u_madeBy);
			uProduct.setDate(u_date);
			uProduct.setPrice(u_price);
			System.out.println("수정 성공했습니다.");
		} else {
			System.out.println("수정 실패했습니다.");
		}
	}
	
	static void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 상품명을 입력해주세요: ");
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
			System.out.println("삭제 성공했습니다.");
			
		} else {
			System.out.println("삭제 실패했습니다.");
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
				System.out.println("시스템을 종료합니다");
				go = false;
			} else if(m.equals("s")) {
				list(p);
			} else if(m.equals("f")) {
				Product s = search();
				if(s != null) {
					s.print();
				} else {
					System.err.println("해당 상품이 없습니다.");
				}
			} else if(m.equals("a")) {
				add();
			} else if(m.equals("u")) {
				update();
			} else if(m.equals("d")) {
				delete();
			} else {
				System.err.println("해당 메뉴가 없습니다 다시 입력해주세요.");
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}