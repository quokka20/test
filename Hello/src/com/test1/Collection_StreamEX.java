package com.test1;

import java.util.HashSet;
import java.util.Objects;
import java.io.*;
// HashSet, HashMap, Hashtable
// hashing, hash함수
// - 컬렉션이 원소를 저장할 때 그 위치를 정하기 위해서 몇 개의 속성이나 키를 대상으로 
// 숫자를 계산하여 그 위치에 원소를 저장

public class Collection_StreamEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		hash_custom_class();
		try {
//			characterTest();
//			charArrayLoop();
//			imageCopy();
//			objectStrea();
			byteArrayStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void hashtest() {
		HashSet<String> hs = new HashSet<>();
		
		String s1 = new String("A");
		String s2 = new String("A");
		
		System.out.printf("%d\n", s1.hashCode());
		System.out.printf("%d\n", s2.hashCode());
		
		System.out.printf("%b\n", s1.equals(s2));
		
		hs.add(s1);
		hs.add(s2);
		
		System.out.println("hs에 저장된 원소수:"+hs.size());
	}
	
	static void hash_custom_class() {
		class Member{
			int num;
			String name;
			public Member() {}	
			public Member(int num, String name) {
				super();
				this.num = num;
				this.name = name;
			}
			@Override
			public int hashCode() {
				return Objects.hash(num,name);
			}
			@Override
			public boolean equals(Object obj) {
				// TODO Auto-generated method stub
				Member m = (Member) obj;
				if(m.num == num && m.name.equals(name)) {
					return true;
				}
				return false;
			}
		}
		
		HashSet<Member> hs = new HashSet<>();
		Member m1 = new Member(11,"smith");
		Member m2 = new Member(11,"smith");
		hs.add(m1);
		hs.add(m2);
		System.out.println("원소수:"+hs.size()); 
		
		System.out.printf("%d %d\n", m1.hashCode(), m2.hashCode());
		System.out.printf("%b\n", m1.equals(m2));
	}
			// 문자 스트림: 한 문자(2바이트)
			// 바이트 스트림: 한 바이트 단위로 다룸
			// 문자 입력 스트립 : Reader
			// 문자 출력 스트림 : Writer
			// 바이트 입력 스트림 : InputStream
			// 바이트 출력 스트림 : OutputStream
			// FileReader : 데이터 소스는 파일이며 텍스트를 입력하는 스트림
			// FileWriter : 파일에 문자를 출력하는 스트림
			// FileInputStream : 파일에서 바이트 데이터를 입력하는 스트림
			// FileOutputStream : 파일에 바이트 데이터를 출력하는 스트림
			// BufferedReader : 버퍼를 사용하여 성능 향상, 한 행 단위로 읽어올 수 있다.
			// PrintWriter : print,printf,println 등의 메소드가 오버로드되어 편리한
			 			   //문자출력용 필터(가공) 스트림
			// ByteArrayInputStream : byte배열로부터 읽어올 수 있는 스트림
			// ByteArrayOutputStream : byte배열에 데이터를 누적하여 저장할 수 있는 출력 스트림
			// StringReader : 메모리에 있는 문자열로부터 문자를 읽어올 수 있는 스트림
			// StringWriter : 메모리에 문자를 누적하여 저장할 수 있는 문자 스트림
			// DataInputStream : 자바의 데이터형 그대로 읽어올 수 있는 바이트 스트림(필터)
			// DataOutputStream : 자바의 데이터형 그대로 출력할 수 있는 바이트 스트림(필터)
			// ObjectInputStream : 직렬화된 데이터를 다시 오브젝트로 읽어올 수 있는 필터스트림
			// ObjectOutputStream : 메모리에 있는 객체를 직렬화하여 저장할 수 있는 필터스트림
			// InputStreamReader : 바이트 데이터를 읽어와서 문자로 변환해주는 입력 변환 스트림
			// OutputStreamReader : 문자 데이터를 바이트 데이터로 변환하여 출력하는 스트림
	
	static void characterTest() throws Exception {
		//FileReader를 사용하여 한 문자씩 전체 파일 데이터를 읽어오는 예
		File src = new File("C:/Users/ysmin/Javatest/Hello.java");
		if(src.exists()) {
			System.out.println(src.length());
		}
		
		FileReader fr = new FileReader(src); // Node 스트림(Source 스트림)
		
		int ch = 0;
		while((ch=fr.read())!=-1) {
			System.out.println((char)ch);
		}
		fr.close();
		
	}
	
	static void charArrayReader() throws Exception{
		//char 배열을 이용하여 다수개의 문자를 읽어오는 예
		File f = new File("C:/Users/ysmin/Javatest/Hello.java");
		FileReader fr = new FileReader(f);
		char[] buf = new char[128];
		int read = fr.read(buf);
		System.out.printf("읽어온 문자수:%d\n", read);
		System.out.println(new String(buf));
		fr.close();
	}
	
	static void charArrayLoop() throws Exception{
		// char배열을 사용하여 텍스트 파일 전체 읽어오기
		File f = new File("C:/Users/ysmin/Javatest/Hello.java");
		FileReader fr = new FileReader(f);
		char[] buf = new char[128];
		int read = 0;
		while((read=fr.read(buf))!=-1) {
			System.out.println(new String(buf,0,read));
			System.out.println();
			System.out.println("읽어온 문자 수:"+read);		
		}
		fr.close();
		System.out.println("메소드 종료");
	}
	
	static void readLine() throws Exception{
		// 필터스트림(BufferedReader)을 사용하여 텍스트 파일에서 한행씩 읽어오기
		File f = new File("C:/Users/ysmin/Javatest/Hello.java");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while((line=br.readLine())!=null) {
			System.out.println(line);
		}
		br.close();
	}
	
	// PrintWriter를 사용하면 다양한 형식의 입력값을 쉽게 쓸 수 있다.
	static void writerTest() throws Exception{
		File f = new File("C:/Users/ysmin/Javatest/sample.txt");
		FileWriter fw = new FileWriter(f);
		PrintWriter pw = new PrintWriter(fw);
		pw.println("Hello");
		pw.println("World");
		pw.println(3.1415926535);
		pw.close();
	}
	
	// 이미지는 바이트 형식이기 때문에 InputStream/OutputStream을 사용해야 한다.
	static void imageCopy() throws Exception{
		File f = new File("C:/Users/ysmin/Javatest/사진.png");
		File dest = new File("C:/Users/ysmin/Javatest/사진카피.png");
		FileInputStream fin = new FileInputStream(f);
		FileOutputStream fout = new FileOutputStream(dest);
		byte[] buf = new byte[1024];
		int read = 0;
		while((read=fin.read(buf))!=-1) {
			fout.write(buf,0,read);
		}
		fin.close();
		fout.close();
		System.out.println("이미지 복사 성공");
	}
	
	static void imgCopy2() throws Exception {
		File src = new File("C:/Users/ysmin/Javatest/사진.png");
		if(!src.exists()) {
			System.err.println("사용할 이미지 파일이 없습니다");
			return;
		}
		long fsize = src.length();
		byte[] img = new byte[(int)fsize];
		FileInputStream fin = new FileInputStream(src);
		String destPath = "C:/Users/ysmin/Javatest/사진카피.png";
		FileOutputStream fout = new FileOutputStream(destPath);
		fin.read(img);
		fout.write(img);
		fin.close();
		fout.close();
		System.out.println("이미지 복사 성공");
	}
	
	static void objectStrea() throws Exception{
		Member m = new Member(11,"Andrea","010-9577-7242","anrea@naver.com");
		m.printMem();
		String fpath = "C:/Users/ysmin/Javatest/member.obj";
		
		FileOutputStream fout = new FileOutputStream(fpath);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(m);
		oos.flush();
		oos.close();
		System.out.println("직렬화 성공");
		
		FileInputStream fin = new FileInputStream(fpath);
		ObjectInputStream ois = new ObjectInputStream(fin);
		
		Member m2 = (Member)ois.readObject();
		m2.printMem();
		ois.close();
	}

	static void byteArrayStream() throws Exception{
		//ByteArrayInputStream / ByteArrayOutputStream
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		
		byte[] data = "Hello World".getBytes();
		bao.write(data);
		
		data = "ByeBye".getBytes();
		bao.write(data);
		
		byte[] result = bao.toByteArray();
		bao.close();
		
		System.out.println(new String(result));
		
		ByteArrayInputStream bai = new ByteArrayInputStream(result);
//		bai.read();
		
		//바이트배열에 저장된 문자열을 중간에 문자로 변환하여 화면에 문자열로 표시하려면?
		InputStreamReader isr = new InputStreamReader(bai);
		char[] buf = new char[result.length];
		int read = isr.read(buf);
		System.out.println((new String(buf,0,read)));
	}
	
	static void textToBytes() throws Exception{
		// Hello.java 소스파일을 읽어서 osw를 사용하여 바이트배열에 누적
		File src = new File("C:/Users/ysmin/Javatest/Hello.java");
		FileReader fr = new FileReader(src);
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(bao);
		char[] buf = new char[128];
		int read = 0;
		while((read=fr.read(buf))!=-1) {
			osw.write(buf, 0, read);
		}
		
		fr.close();
		osw.close();
		byte[] fdata = bao.toByteArray();
		
		File dest = new File("C:/Users/ysmin/Javatest/Hello2.java");
		FileWriter fw = new FileWriter(dest);
		ByteArrayInputStream bai = new ByteArrayInputStream(fdata);
		InputStreamReader isr = new InputStreamReader(bai);
	
		char[] buff = new char[128];
		read = 0;
		while((read=isr.read(buf))!=-1) {
			fw.write(buff,0,read);
		}
		isr.close();
		fw.close();
		File f = dest;
	}
	
	
	static void imgLoadNSave() throws Exception{
		// 이미지 파일을 로드하여 메모리에 바이트 배열에 누적하고
		// 그 로드된 데이터를 다시 파일에 기록하여 동일한 이미지를 복사해보세요
		
		File src = new File("C:/Users/ysmin/Javatest/사진.png");
		FileInputStream fin = new FileInputStream(src);
		ByteArrayOutputStream bao = new ByteArrayOutputStream();

		byte[] buf = new byte[1024];
		int read = 0;
		while((read=fin.read(buf))!=-1) {
			bao.write(buf, 0, read);
		}
		fin.close();
		byte[] img = bao.toByteArray();
		bao.close();

		ByteArrayInputStream bin = new ByteArrayInputStream(img);
		File dest = new File("C:/Users/ysmin/Javatest/사진_연습.png");
		FileOutputStream fout = new FileOutputStream(dest);
		byte[] buff = new byte[128];
		read = 0;
		while((read=bin.read(buff))!=-1) {
			fout.write(buff, 0, read);
		}
		bin.close();
		fout.close();
	}
	
	
	static void nodeStreamOnly() throws Exception{
		File src = new File("C:/Users/ysmin/Javatest/사진.png");
		FileInputStream fs = new FileInputStream(src);
		byte[] buf = new byte[128];
		int read = 0;
		long start = System.currentTimeMillis();
		while((read=fs.read(buf))!=-1) {
			
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		fs.close();
	}
	
	static void filterStream() throws Exception{
		File src = new File("C:/Users/ysmin/Javatest/사진.png");
		FileInputStream fs = new FileInputStream(src);
		BufferedInputStream bin = new BufferedInputStream(fs);
		byte[] buf = new byte[128];
		int read = 0;
		long start = System.currentTimeMillis();
		while((read=bin.read(buf))!=-1) {
			
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		bin.close();
	}
	
	static void filterStream2() throws Exception{
		File src = new File("C:/Users/ysmin/Javatest/사진.png");
		FileInputStream fs = new FileInputStream(src);
		BufferedInputStream bin = new BufferedInputStream(fs);
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		byte[] buf = new byte[128];
		int read = 0;
		long start = System.currentTimeMillis();
		while((read=bin.read(buf))!=-1) {
			bao.write(buf, 0, read);
		}
		byte[] total = bao.toByteArray();
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		bin.close();
		bao.close();
		
		String pic = "C:/Users/ysmin/Javatest/사진_test.png";
		FileOutputStream fout = new FileOutputStream(pic);
		BufferedOutputStream bout = new BufferedOutputStream(fout);
		ByteArrayInputStream bai = new ByteArrayInputStream(total);
		byte[] buff = new byte[128];
		read = 0;
		long start2 = System.currentTimeMillis();
		while((read=bai.read(buff))!=-1) {
			bout.write(buff, 0, read);
		}
		long end2 = System.currentTimeMillis();
		System.out.println(end2-start2);
		bai.close();
		bout.close();
	}
	
}
