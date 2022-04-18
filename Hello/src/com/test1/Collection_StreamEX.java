package com.test1;

import java.util.HashSet;
import java.util.Objects;
import java.io.*;
// HashSet, HashMap, Hashtable
// hashing, hash�Լ�
// - �÷����� ���Ҹ� ������ �� �� ��ġ�� ���ϱ� ���ؼ� �� ���� �Ӽ��̳� Ű�� ������� 
// ���ڸ� ����Ͽ� �� ��ġ�� ���Ҹ� ����

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
		
		System.out.println("hs�� ����� ���Ҽ�:"+hs.size());
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
		System.out.println("���Ҽ�:"+hs.size()); 
		
		System.out.printf("%d %d\n", m1.hashCode(), m2.hashCode());
		System.out.printf("%b\n", m1.equals(m2));
	}
			// ���� ��Ʈ��: �� ����(2����Ʈ)
			// ����Ʈ ��Ʈ��: �� ����Ʈ ������ �ٷ�
			// ���� �Է� ��Ʈ�� : Reader
			// ���� ��� ��Ʈ�� : Writer
			// ����Ʈ �Է� ��Ʈ�� : InputStream
			// ����Ʈ ��� ��Ʈ�� : OutputStream
			// FileReader : ������ �ҽ��� �����̸� �ؽ�Ʈ�� �Է��ϴ� ��Ʈ��
			// FileWriter : ���Ͽ� ���ڸ� ����ϴ� ��Ʈ��
			// FileInputStream : ���Ͽ��� ����Ʈ �����͸� �Է��ϴ� ��Ʈ��
			// FileOutputStream : ���Ͽ� ����Ʈ �����͸� ����ϴ� ��Ʈ��
			// BufferedReader : ���۸� ����Ͽ� ���� ���, �� �� ������ �о�� �� �ִ�.
			// PrintWriter : print,printf,println ���� �޼ҵ尡 �����ε�Ǿ� ����
			 			   //������¿� ����(����) ��Ʈ��
			// ByteArrayInputStream : byte�迭�κ��� �о�� �� �ִ� ��Ʈ��
			// ByteArrayOutputStream : byte�迭�� �����͸� �����Ͽ� ������ �� �ִ� ��� ��Ʈ��
			// StringReader : �޸𸮿� �ִ� ���ڿ��κ��� ���ڸ� �о�� �� �ִ� ��Ʈ��
			// StringWriter : �޸𸮿� ���ڸ� �����Ͽ� ������ �� �ִ� ���� ��Ʈ��
			// DataInputStream : �ڹ��� �������� �״�� �о�� �� �ִ� ����Ʈ ��Ʈ��(����)
			// DataOutputStream : �ڹ��� �������� �״�� ����� �� �ִ� ����Ʈ ��Ʈ��(����)
			// ObjectInputStream : ����ȭ�� �����͸� �ٽ� ������Ʈ�� �о�� �� �ִ� ���ͽ�Ʈ��
			// ObjectOutputStream : �޸𸮿� �ִ� ��ü�� ����ȭ�Ͽ� ������ �� �ִ� ���ͽ�Ʈ��
			// InputStreamReader : ����Ʈ �����͸� �о�ͼ� ���ڷ� ��ȯ���ִ� �Է� ��ȯ ��Ʈ��
			// OutputStreamReader : ���� �����͸� ����Ʈ �����ͷ� ��ȯ�Ͽ� ����ϴ� ��Ʈ��
	
	static void characterTest() throws Exception {
		//FileReader�� ����Ͽ� �� ���ھ� ��ü ���� �����͸� �о���� ��
		File src = new File("C:/Users/ysmin/Javatest/Hello.java");
		if(src.exists()) {
			System.out.println(src.length());
		}
		
		FileReader fr = new FileReader(src); // Node ��Ʈ��(Source ��Ʈ��)
		
		int ch = 0;
		while((ch=fr.read())!=-1) {
			System.out.println((char)ch);
		}
		fr.close();
		
	}
	
	static void charArrayReader() throws Exception{
		//char �迭�� �̿��Ͽ� �ټ����� ���ڸ� �о���� ��
		File f = new File("C:/Users/ysmin/Javatest/Hello.java");
		FileReader fr = new FileReader(f);
		char[] buf = new char[128];
		int read = fr.read(buf);
		System.out.printf("�о�� ���ڼ�:%d\n", read);
		System.out.println(new String(buf));
		fr.close();
	}
	
	static void charArrayLoop() throws Exception{
		// char�迭�� ����Ͽ� �ؽ�Ʈ ���� ��ü �о����
		File f = new File("C:/Users/ysmin/Javatest/Hello.java");
		FileReader fr = new FileReader(f);
		char[] buf = new char[128];
		int read = 0;
		while((read=fr.read(buf))!=-1) {
			System.out.println(new String(buf,0,read));
			System.out.println();
			System.out.println("�о�� ���� ��:"+read);		
		}
		fr.close();
		System.out.println("�޼ҵ� ����");
	}
	
	static void readLine() throws Exception{
		// ���ͽ�Ʈ��(BufferedReader)�� ����Ͽ� �ؽ�Ʈ ���Ͽ��� ���྿ �о����
		File f = new File("C:/Users/ysmin/Javatest/Hello.java");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while((line=br.readLine())!=null) {
			System.out.println(line);
		}
		br.close();
	}
	
	// PrintWriter�� ����ϸ� �پ��� ������ �Է°��� ���� �� �� �ִ�.
	static void writerTest() throws Exception{
		File f = new File("C:/Users/ysmin/Javatest/sample.txt");
		FileWriter fw = new FileWriter(f);
		PrintWriter pw = new PrintWriter(fw);
		pw.println("Hello");
		pw.println("World");
		pw.println(3.1415926535);
		pw.close();
	}
	
	// �̹����� ����Ʈ �����̱� ������ InputStream/OutputStream�� ����ؾ� �Ѵ�.
	static void imageCopy() throws Exception{
		File f = new File("C:/Users/ysmin/Javatest/����.png");
		File dest = new File("C:/Users/ysmin/Javatest/����ī��.png");
		FileInputStream fin = new FileInputStream(f);
		FileOutputStream fout = new FileOutputStream(dest);
		byte[] buf = new byte[1024];
		int read = 0;
		while((read=fin.read(buf))!=-1) {
			fout.write(buf,0,read);
		}
		fin.close();
		fout.close();
		System.out.println("�̹��� ���� ����");
	}
	
	static void imgCopy2() throws Exception {
		File src = new File("C:/Users/ysmin/Javatest/����.png");
		if(!src.exists()) {
			System.err.println("����� �̹��� ������ �����ϴ�");
			return;
		}
		long fsize = src.length();
		byte[] img = new byte[(int)fsize];
		FileInputStream fin = new FileInputStream(src);
		String destPath = "C:/Users/ysmin/Javatest/����ī��.png";
		FileOutputStream fout = new FileOutputStream(destPath);
		fin.read(img);
		fout.write(img);
		fin.close();
		fout.close();
		System.out.println("�̹��� ���� ����");
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
		System.out.println("����ȭ ����");
		
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
		
		//����Ʈ�迭�� ����� ���ڿ��� �߰��� ���ڷ� ��ȯ�Ͽ� ȭ�鿡 ���ڿ��� ǥ���Ϸ���?
		InputStreamReader isr = new InputStreamReader(bai);
		char[] buf = new char[result.length];
		int read = isr.read(buf);
		System.out.println((new String(buf,0,read)));
	}
	
	static void textToBytes() throws Exception{
		// Hello.java �ҽ������� �о osw�� ����Ͽ� ����Ʈ�迭�� ����
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
		// �̹��� ������ �ε��Ͽ� �޸𸮿� ����Ʈ �迭�� �����ϰ�
		// �� �ε�� �����͸� �ٽ� ���Ͽ� ����Ͽ� ������ �̹����� �����غ�����
		
		File src = new File("C:/Users/ysmin/Javatest/����.png");
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
		File dest = new File("C:/Users/ysmin/Javatest/����_����.png");
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
		File src = new File("C:/Users/ysmin/Javatest/����.png");
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
		File src = new File("C:/Users/ysmin/Javatest/����.png");
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
		File src = new File("C:/Users/ysmin/Javatest/����.png");
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
		
		String pic = "C:/Users/ysmin/Javatest/����_test.png";
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
