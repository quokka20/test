package com.test1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StreamEx_test {

	/* 텍스트 파일(member.txt)을 대상으로 CRUD 구현
	 * 프로그램이 시작되면 화면에 회원목록 5인정보가 표시된다
	 * 리스트 하단에 메뉴가 표시된다(목록(s), 검색(f), 추가(a), 수정(u), 삭제(d), 종료(x))
	 * 텍스트 파일에 저장될 데이터 포맷 : num|name|phone|email
	 */
	
	// 파일 위치
	static File src = new File("C:/Users/ysmin/Javatest/member.txt");
	
	// 저장된 파일 불러오기
	static List<Member> fileLoad() throws Exception {

			FileReader fr = new FileReader(src);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			List<Member> list = new ArrayList<>();
			while((line = br.readLine()) != null) {
				String[] token = line.split("\\|");
				int num = Integer.parseInt(token[0]);
				list.add(new Member(num,token[1],token[2],token[3]));
			}
			br.close();
			return list;
	}
	
	// 리스트 화면에 보여주기
	static void showList(List<Member> list) {
		for(int i = 0; i<list.size(); i++) {
			list.get(i).printMem();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
