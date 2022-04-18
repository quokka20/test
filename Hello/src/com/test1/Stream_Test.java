package com.test1;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

public class Stream_Test {

	// 텍스트(2바이트) : *Reader, *Writer
	// 바이너리(1바이트) : *InputStream, *OutputStream 
	public static void main(String[] args) {
		try {
//			FileWriter fw = new FileWriter("C:/Users/ysmin/Javatest/FW_Test.txt");
//			fw.write("Hello World\n");
//			fw.write("Byebye\n");
//			fw.close();
			
//			PrintWriter pw = new PrintWriter(fw);
//			pw.println(10000);
//			pw.println(3.141592);
//			pw.println(false);
//			pw.println('k');
//			pw.println("필터스트림 사용하기");
//			pw.close();
			
//			File f = new File("C:/Users/ysmin/Javatest/Hello.java");
//			File f2 = new File("C:/Users/ysmin/Javatest/Hello_copy.java");
//			f2.exists();
//			BufferedReader br = new BufferedReader(new FileReader(f));
//			PrintWriter pw = new PrintWriter(new FileWriter(f2));
//			String line = null;
//			while((line=br.readLine())!=null) {
//				pw.println(line);
//			}
//			pw.close();
//			br.close();
			
			// 바이트 데이터를 읽어서 문자스트림으로 변환하여 문자를 다루는 예
//			File src = new File("C:/Users/ysmin/Javatest/Hello.java");
//			FileInputStream fin = new FileInputStream(src);
//			InputStreamReader isr = new InputStreamReader(fin);
//			BufferedReader br = new BufferedReader(isr);
//			String line = null;
//			while((line = br.readLine())!=null) {
//				System.out.println(line);
//			}
			
			// 문자 데이터를 바이트 데이터로 변환하여 출력하는 예
			// PrintWriter > OutputStreamWriter > FileOutputStream
//			File src = new File("C:/Users/ysmin/Javatest/Hello.java");
//			BufferedReader br = new BufferedReader(new FileReader(src));
//			
//			File copy = new File("C:/Users/ysmin/Javatest/copy.txt");
//			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(copy)));
//			
//			String line = null;
//			while((line = br.readLine())!=null) {
//				//문자 데이터를 바이트 스트림으로 출력한다
//				pw.println(line);
//			}
//			br.close();
//			pw.close();
			
//			int ch = isr.read(); // 한 문자씩
//			char[] buf = new char[128];
//			isr.read(buf); // 여러 문자씩
			
//			System.out.println("파일 읽고 쓰기 성공");
			
//			FileReader fr = new FileReader("C:/Users/ysmin/Javatest/Hello.java");
//			// 한행을 읽어올 수  있는 가공(필터) 스트림
//			BufferedReader br = new BufferedReader(fr);
//			String line =null;
//			while((line=br.readLine())!=null) {
//				System.out.println(line);
//			}
//			int ch;
//			char[] buf = new char[128];
//			int read = 0;
//			while((read=fr.read(buf))!=-1) {
//				String str = new String(buf);
//				System.out.print(str);
//				System.out.println(read);
//			}
//			for(int i = 0; i<128; i++) {
//				System.out.print(buf[i]);
//			}
//			while((ch = fr.read()) != -1) {
//				System.out.print((char)ch);
//			}
//			fr.close();
			
			
//			File fng = new File("C:/Users/ysmin/Javatest/사진.png");
//			File fng2 = new File("C:/Users/ysmin/Javatest/사진2.png");
//
//			String res = fng.exists() ? "파일 있음":"파일 없음";
//			System.out.println(res);
//			FileInputStream fis = new FileInputStream(fng);
//			FileOutputStream fos = new FileOutputStream(fng2);
//			ByteArrayOutputStream bao = new ByteArrayOutputStream();
//			
//			byte[] buf = new byte[1024];
//			int read = 0;
//			while((read = fis.read(buf))!=-1) {
//				bao.write(buf, 0, read);
//			}
//			byte[] finalArray = bao.toByteArray();
//			
//			fos.write(finalArray);	// 한 번에 파일에 쓰기
//			ByteArrayInputStream bai = new ByteArrayInputStream(finalArray);
//			while((read = bai.read(buf))!=-1) {
//				fos.write(buf,0,read);
//			}
			
			
//			long fileSize = fng.length();
//			System.out.println(fileSize);
//			
//			byte[] buf = new byte[(int)fileSize];
//			int fileRead = fis.read(buf);
//			System.out.println(fileRead);
//			
//			fos.write(buf);
			
//			int data = fis.read();
//			System.out.println(data);
			
//			byte[] buf = new byte[128];
//			int read = 0;
//			while((read=fis.read(buf))!=-1) {
//				fos.write(buf, 0, read);
//			}
			
//			fis.close();
//			fos.close();
			
//			StringReader sr = new StringReader("Hello World");
//			int ch = sr.read();
//			System.out.println((char)ch);
//			
//			StringWriter sw = new StringWriter();
//			sw.write("H");
//			sw.write("e");
//			sw.write("l");
//			sw.write("l");
//			sw.write("o");
//			sw.write("!");
//
//			String result = sw.toString();
//			System.out.println(result);
			
			File src = new File("C:/Users/ysmin/Javatest/Hello.java");
			FileReader fr = new FileReader(src);
			StringWriter sw = new StringWriter();

			int read = 0;
			char[] buf = new char[64];
			while((read = fr.read(buf))!=-1) {
				sw.write(buf);
			}
			
			String result = sw.toString();
			System.out.println(result);
			// 텍스트파일(FileReader) -> 메모리에 문자열로 누적
			
			
		}  catch(Exception e) {
			e.printStackTrace();
		}
//		}	catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException ioe) {
//			ioe.printStackTrace();
//		}
	}

}
