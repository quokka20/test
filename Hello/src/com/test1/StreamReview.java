package com.test1;

import java.io.*;

public class StreamReview {

	public static void main(String[] args) {
//		dataStream();
//		fileWriter();
//		printWriter();
//		bufferReader();
//		byteString();
//		stringByte();
//		imgCopy();
//		fileReaderStringWriter();
	}
	
	// FileWriter를 사용하여 파일에 문자형식 쓰기
	static void fileWriter() {
		try {
			// 1. FileWriter 형식으로 파일주소를 지정
			// FileWriter는 try-catch문 사용해야 됨.
			// fw = java.io.FileWriter@4517d9a3
			FileWriter fw = new FileWriter("C:/Users/ysmin/Javatest/FW_Test.txt");
			
			// 2. FileWriter를 사용하여 해당 주소에 직접 입력
			// 문자열 형식을 입력
			fw.write("Hello World\n");
			fw.write("그럼 안녕\n");
		
			// 3. 사용 후 FileWriter 닫기
			fw.close();
			
			// 4. 작성됐는지 확인은 파일 직접 열어서 확인
			System.out.println("파일 작성 완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// PrintWriter를 사용하여 다양한 형식 쓰기
	static void printWriter() {
		try {
			// 1. FileWriter형식으로 fw에 작성 할 곳의 주소를 받음
			FileWriter fw = new FileWriter("C:/Users/ysmin/Javatest/FW_Test.txt");
			// 2. FileWriter를 PrintWriter 형식으로 저장
			PrintWriter pw = new PrintWriter(fw);
			
			// 3. PrintWriter를 사용하여 다양한 형식을 파일에 입력
			pw.println(100000);
			pw.println(3.141592);
			pw.println(true);
			pw.println('K');
			pw.println("필터스트림 사용하기");
			
			// 4. 사용 후 PrintWriter을 종료
			pw.close();
			
			// 5. 작성됐는지 확인은 파일 직접 열어서 확인
			System.out.println("파일 작성 완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	// BufferedReadr, PrintWriter를 사용하여 파일 복사하여 쓰기
	static void bufferReader() {
		// 1. File 형식으로 기존에 있는 파일 1개와 새로 작성할 파일을 지정
		File f1 = new File("C:/Users/ysmin/Javatest/Hello.java");
		File f2 = new File("C:/Users/ysmin/Javatest/Hello_copy.java");
		
		 
		try {
			// 2. BufferedReader형식인 br에 기존에 있는 파일을 담기
			// 그러기 위해선 BufferedReader안에 FileReader형식으로 File형식을 받음
			// new BufferedReader안에 new FileReader(f1)는 아래와 같이 밖에 풀어쓸 수 있음
			
			// FileReader fr = new FileReader(f1);
			// BufferedReader br = new BufferedReader(fr);
			BufferedReader br = new BufferedReader(new FileReader(f1));
			
			// 3. PrintWriter를 사용하여 복사할 곳의 주소를 지정
			PrintWriter pw = new PrintWriter(new FileWriter(f2));
			
			// 4. String 형식의 line에 null로 선언 및 초기화
			String line = null;
			
			// 5. line에 BufferedReader을 통해 가져온 기존 파일의 한 줄씩 넣기
			// line에 넣어진 문장을 PrintWriter을 사용하여 지정된 파일에 입력
			// line에 더이상 넣을게 없을 때까지 반복
			// flush는 Stream에 있는 데이터를 강제로 내보내는 역활을 함.
			while((line = br.readLine()) != null) {
				pw.println(line);
				pw.flush();
			}
			
			// 6. 사용 후에 BufferedReader과 PrintWrinter을 종료
			br.close();
			pw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// 바이트 데이터를 읽어서 문자스트림으로 변환하여 문자를 다루는 예
	static void byteString() {
		// 1. File 형식인 src에 파일 주소 할당
		File src = new File("C:/Users/ysmin/Javatest/Hello.java");
		
		try {
			// 2. 바이트 데이터로 읽기 위해서 InputStream을 사용
			// 그 중에서 우리는 File을 바이트 데이터로 읽어오는 것이기 때문에 FileInputStream 사용
			FileInputStream fin = new FileInputStream(src);
			
			// 3. FileInputStream을 읽어오기 위해 InputStreamReader을 사용
			InputStreamReader isr = new InputStreamReader(fin);
			
			// 4. InputStreamReader을 읽어오기 위해 BufferedReader을 사용
			BufferedReader br = new BufferedReader(isr);
			
			// 5. String 형식의 line에 null로 선언 및 초기화
			String line = null;
			
			// 6. line에 BufferReader를 사용하여 읽어온 문장을 넣어 null이 될 때까지 출력
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 문자 데이터를 바이트 데이터로 변환하여 출력하는 예
	// PrintWriter > OutputStreamWriter > FileOutputStream
	// 텍스트를 가진 파일을 문자스트림으로 한행씩 읽어서 다른 파일에 복사할 때, 바이트 스트림(FileOutputStream)을 사용
	static void stringByte() {
		// 1. File 형식으로 주소를 저장
		File src = new File("C:/Users/ysmin/Javatest/Hello.java");
		
		try {
			// 2. BufferedReader 형식인 br에 File 형식의 주소를 넣기 위해 아래와 같은 순서로 변환
			// 풀어서 쓴 것
			// FileReader fr = new FileReader(src);
			// BufferedReader br = new BufferedReader(fr);
			BufferedReader br = new BufferedReader(new FileReader(src));
			
			// 3. File 형식으로 복사할 파일주소를 copy에 저장
			File copy = new File("C:/Users/ysmin/Javatest/copy.java");
			
			// 4. 바이트 형식으로 파일주소를 받아와서 아래와 같은 변환 과정을 거쳐 PrinWriter 형식으로 변환
			// FileOutputStream fout = new FileOutputStream(copy);
			// OutputStreamWriter osw = new OutputStreamWriter(fout);
			// PrintWriter pw = new PrintWriter(osw);
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(copy)));
		
			// 5. String 형식인 line을 선언 및 초기화
			String line = null;
			
			// 6. line에 BufferedReader를 사용해서 읽어온 문장을 넣어서 null이 될 때까지 작동
			// PrintWriter 형식인 pw를 사용해서 line에 있는 문장을 작성
			// pw와 연결되어 있는 주소를 쭉 따라가면 문자 데이터를 바이트 데이터로 변환함
			// 마지막에 File 형식인 copy에 바이트 스트림을 사용하여 입력
			while((line = br.readLine()) != null) {
				// 문자 데이터를 바이트 스트림으로 출력
				pw.println(line);
			}
			
			// 7. 사용하고 난 BufferedReader과 PrintWriter 종료
			br.close();
			pw.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 그림 파일을 복사해서 해당 사진과 동일한 그림 파일 만들기
	static void imgCopy() {
		File img1 = new File("C:/Users/ysmin/Javatest/사진.png");
		File img2 = new File("C:/Users/ysmin/Javatest/사진2.png");
		
		try {
			FileInputStream fin = new FileInputStream(img1);
			FileOutputStream fout = new FileOutputStream(img2);
			
			ByteArrayOutputStream bao = new ByteArrayOutputStream();
			
			byte[] buf = new byte[1024];
			int read = 0;
			while((read = fin.read(buf)) != -1) {
				bao.write(buf, 0, read);
			}
			
			byte[] finalArray = bao.toByteArray();
			//fout.write(finalArray); // 한 번에 파일 쓰기
			
			ByteArrayInputStream bai = new ByteArrayInputStream(finalArray);
			
			while((read = bai.read(buf)) != -1) {
				fout.write(buf,0,read);
			}
			
			fin.close();
			fout.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// String 형식으로 읽고 쓰기
	static void stringReaderAndWriter() {
		StringReader sr = new StringReader("Hello World");
		try {
			int ch = sr.read();
			System.out.println((char)ch); //H
			
			StringWriter sw = new StringWriter();
			sw.write("H");
			sw.write("e");
			sw.write("l");
			sw.write("l");
			sw.write("o");
			
			String result = sw.toString();
			System.out.println(result);
			
			sr.close();
			sw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Hello.java 소스에 포함된 문자들을 모두 모아서 한개의 문자열에 표현하여 화면에 표시
	// 텍스트파일(FileReader) -> 메모리에 문자열로 누적(StringWriter)
	static void fileReaderStringWriter() {
		File src = new File("C:/Users/ysmin/Javatest/Hello.java");
		try {
			FileReader fr = new FileReader(src);
			StringWriter sw = new StringWriter();
			
			int read = 0;
			char[] buf = new char[64];
			while((read = fr.read(buf)) != -1) {
				sw.write(buf);
			}
			String res = sw.toString();
			System.out.println(res);
			
			sw.close();
			fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// DataInputStream, DataOutputStream 활용하여 파일 쓰고 읽기
	static void dataStream() {
		// 1. 먼저 DataOutputStream을 사용하여 파일 쓰기
		// 1-1. 작성할 곳의 주소를 dest에 입력
		// 작성이기 때문에 새로운 파일 주소를 입력해줘도 됨.
		// dest = C:\Users\ysmin\Javatest\data2.jdata
		File dest = new File("C:/Users/ysmin/Javatest/data2.jdata");
		
		DataOutputStream dout;
		
		try {
			// 1-2. File 형식인 dest를 받아 FileOutputStream 형식으로 변환
			// FileOutputStream을 사용할 때 try-catch문 사용해야함
			// fout = java.io.FileOutputStream@24d46ca6
			FileOutputStream fout = new FileOutputStream(dest);
			
			// 1-3. FileOutputStream 형식인 fout을 받아 DataOutputStream 형식으로 변환
			// try문 안에서 dout을 선언하면 활용하기 불편하기 때문에 try문 밖에서 dout 선언
			// dout = java.io.DataOutputStream@4517d9a3
			dout = new DataOutputStream(fout);
			
			// 1-4. DataOutputStream을 활용하여 File에 다양한 형식으로 쓰기
			dout.writeBoolean(true);
			dout.writeChar('A');
			dout.writeDouble(3.14);
			dout.writeUTF("Hello");
			
			// 1-5. 작성이 끝나면 DataOutputStream 닫기
			dout.close();
			
			// 1-6. 위의 코드가 정상 작동하였다면 "파일 쓰기 성공"이라는 글이 출력
			System.out.println("파일 쓰기 성공");
			
			// 2. DataInputStream을 사용하여 작성된 파일 읽기
			// 2-1. src에 File형식 주소를 담음
			File src = new File("C:/Users/ysmin/Javatest/data2.jdata");
			
			// 2-2. File 주소를 받아 FileInputStream 형식으로 변환
			FileInputStream fin = new FileInputStream(src);
			
			// 2-3. FileInputStream 형식을 DataInputStream 형식으로 변환
			DataInputStream din = new DataInputStream(fin);
			
			// 2-4. DataInputStream을 사용하여 각각 알맞는 형식으로 읽음
			boolean b = din.readBoolean();
			char ch = din.readChar();
			double d = din.readDouble();
			String s = din.readUTF();
			
			// 2-5. 각각의 형식을 printf 문을 사용하여 읽음
			System.out.printf("%b\t%c\t%f\t%s\n", b,ch,d,s);
			
			// 2-6. 읽기가 끝나면 DataInputStream 닫기
			din.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
