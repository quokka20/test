package com.test1;

public class Test_Exe {

	public static void main(String[] args) {
		// 구구단 실행
//		Gugudan gd = new Gugudan(5);
//		gd.printGugudan();
		
		//벡터 실행
//		Vector v1 = new Vector(2,3);
//		Vector v2 = new Vector(3,6);
//		
//		Vector v3 = v1.add(v2);
//		Vector v4 = v1.sub(v2);
//
//		v3.print();	//(5,9)
//		v4.print();
		
		//계산기 실행
//		int res = Arith.add(3,5);	// 8
//		System.out.println(res);
//		res = Arith.sub(3,5);		// -2
//		System.out.println(res);
//		res = Arith.mul(3,5);		// 15
//		System.out.println(res);
//		res = Arith.div(10,2);		// 5
//		System.out.println(res);
		
		//게시판 실행
//		BBS[] b = new BBS[5];
//		
//		b[0] = new BBS(1, "안녕", "sm", "2021-10-29");
//		b[1] = new BBS(2, "나는", "tts", "2021-07-20");
//		b[2] = new BBS(3, "성민", "성민", "2021-10-03");
//		b[3] = new BBS(4, "이야", "jj", "2021-08-17");
//		b[4] = new BBS(5, "반갑", "ik", "2021-03-10");
//
//		for(int i = 0; i<b.length; i++) {
//			b[i].print();
//		}
		
		ElectronicDevices[] e = new ElectronicDevices[3];
		Desktop d1 = new Desktop("그램", 1000000, "LG", "2018");
		Desktop d2 = new Desktop("디자인슬림", 600000, "레노버", "2019");
		SmartPhone p1 = new SmartPhone("갤럭시", 900000, "삼성", 270);
		
		e[0] = d1;
		e[1] = d2;
		e[2] = p1;
		
		int price = 0;
		
		for(int i = 0; i<e.length; i++) {
			e[i].print();
			price += e[i].getPrice();
		}
		System.out.println("총 제품 가격: "+price+"원 입니다.");
		
		
	}

}
