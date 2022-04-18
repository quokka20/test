package com.test1;

public class BBS {
	int id;
	String title;
	String writer;
	String date;
	
	public BBS() {}
	
	public BBS(int id, String title, String writer, String date) {
		super(); 	// 상위 클래스의 생성자 호출
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.date = date;
	}
	
	public void print() {
		System.out.printf("%d\t%s\t%s\t%s \n",id,title,writer,date);
	}
}
