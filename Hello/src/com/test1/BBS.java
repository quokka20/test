package com.test1;

public class BBS {
	int id;
	String title;
	String writer;
	String date;
	
	public BBS() {}
	
	public BBS(int id, String title, String writer, String date) {
		super(); 	// ���� Ŭ������ ������ ȣ��
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.date = date;
	}
	
	public void print() {
		System.out.printf("%d\t%s\t%s\t%s \n",id,title,writer,date);
	}
}
