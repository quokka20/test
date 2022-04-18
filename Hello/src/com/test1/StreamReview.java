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
	
	// FileWriter�� ����Ͽ� ���Ͽ� �������� ����
	static void fileWriter() {
		try {
			// 1. FileWriter �������� �����ּҸ� ����
			// FileWriter�� try-catch�� ����ؾ� ��.
			// fw = java.io.FileWriter@4517d9a3
			FileWriter fw = new FileWriter("C:/Users/ysmin/Javatest/FW_Test.txt");
			
			// 2. FileWriter�� ����Ͽ� �ش� �ּҿ� ���� �Է�
			// ���ڿ� ������ �Է�
			fw.write("Hello World\n");
			fw.write("�׷� �ȳ�\n");
		
			// 3. ��� �� FileWriter �ݱ�
			fw.close();
			
			// 4. �ۼ��ƴ��� Ȯ���� ���� ���� ��� Ȯ��
			System.out.println("���� �ۼ� �Ϸ�");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// PrintWriter�� ����Ͽ� �پ��� ���� ����
	static void printWriter() {
		try {
			// 1. FileWriter�������� fw�� �ۼ� �� ���� �ּҸ� ����
			FileWriter fw = new FileWriter("C:/Users/ysmin/Javatest/FW_Test.txt");
			// 2. FileWriter�� PrintWriter �������� ����
			PrintWriter pw = new PrintWriter(fw);
			
			// 3. PrintWriter�� ����Ͽ� �پ��� ������ ���Ͽ� �Է�
			pw.println(100000);
			pw.println(3.141592);
			pw.println(true);
			pw.println('K');
			pw.println("���ͽ�Ʈ�� ����ϱ�");
			
			// 4. ��� �� PrintWriter�� ����
			pw.close();
			
			// 5. �ۼ��ƴ��� Ȯ���� ���� ���� ��� Ȯ��
			System.out.println("���� �ۼ� �Ϸ�");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	// BufferedReadr, PrintWriter�� ����Ͽ� ���� �����Ͽ� ����
	static void bufferReader() {
		// 1. File �������� ������ �ִ� ���� 1���� ���� �ۼ��� ������ ����
		File f1 = new File("C:/Users/ysmin/Javatest/Hello.java");
		File f2 = new File("C:/Users/ysmin/Javatest/Hello_copy.java");
		
		 
		try {
			// 2. BufferedReader������ br�� ������ �ִ� ������ ���
			// �׷��� ���ؼ� BufferedReader�ȿ� FileReader�������� File������ ����
			// new BufferedReader�ȿ� new FileReader(f1)�� �Ʒ��� ���� �ۿ� Ǯ� �� ����
			
			// FileReader fr = new FileReader(f1);
			// BufferedReader br = new BufferedReader(fr);
			BufferedReader br = new BufferedReader(new FileReader(f1));
			
			// 3. PrintWriter�� ����Ͽ� ������ ���� �ּҸ� ����
			PrintWriter pw = new PrintWriter(new FileWriter(f2));
			
			// 4. String ������ line�� null�� ���� �� �ʱ�ȭ
			String line = null;
			
			// 5. line�� BufferedReader�� ���� ������ ���� ������ �� �پ� �ֱ�
			// line�� �־��� ������ PrintWriter�� ����Ͽ� ������ ���Ͽ� �Է�
			// line�� ���̻� ������ ���� ������ �ݺ�
			// flush�� Stream�� �ִ� �����͸� ������ �������� ��Ȱ�� ��.
			while((line = br.readLine()) != null) {
				pw.println(line);
				pw.flush();
			}
			
			// 6. ��� �Ŀ� BufferedReader�� PrintWrinter�� ����
			br.close();
			pw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// ����Ʈ �����͸� �о ���ڽ�Ʈ������ ��ȯ�Ͽ� ���ڸ� �ٷ�� ��
	static void byteString() {
		// 1. File ������ src�� ���� �ּ� �Ҵ�
		File src = new File("C:/Users/ysmin/Javatest/Hello.java");
		
		try {
			// 2. ����Ʈ �����ͷ� �б� ���ؼ� InputStream�� ���
			// �� �߿��� �츮�� File�� ����Ʈ �����ͷ� �о���� ���̱� ������ FileInputStream ���
			FileInputStream fin = new FileInputStream(src);
			
			// 3. FileInputStream�� �о���� ���� InputStreamReader�� ���
			InputStreamReader isr = new InputStreamReader(fin);
			
			// 4. InputStreamReader�� �о���� ���� BufferedReader�� ���
			BufferedReader br = new BufferedReader(isr);
			
			// 5. String ������ line�� null�� ���� �� �ʱ�ȭ
			String line = null;
			
			// 6. line�� BufferReader�� ����Ͽ� �о�� ������ �־� null�� �� ������ ���
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// ���� �����͸� ����Ʈ �����ͷ� ��ȯ�Ͽ� ����ϴ� ��
	// PrintWriter > OutputStreamWriter > FileOutputStream
	// �ؽ�Ʈ�� ���� ������ ���ڽ�Ʈ������ ���྿ �о �ٸ� ���Ͽ� ������ ��, ����Ʈ ��Ʈ��(FileOutputStream)�� ���
	static void stringByte() {
		// 1. File �������� �ּҸ� ����
		File src = new File("C:/Users/ysmin/Javatest/Hello.java");
		
		try {
			// 2. BufferedReader ������ br�� File ������ �ּҸ� �ֱ� ���� �Ʒ��� ���� ������ ��ȯ
			// Ǯ� �� ��
			// FileReader fr = new FileReader(src);
			// BufferedReader br = new BufferedReader(fr);
			BufferedReader br = new BufferedReader(new FileReader(src));
			
			// 3. File �������� ������ �����ּҸ� copy�� ����
			File copy = new File("C:/Users/ysmin/Javatest/copy.java");
			
			// 4. ����Ʈ �������� �����ּҸ� �޾ƿͼ� �Ʒ��� ���� ��ȯ ������ ���� PrinWriter �������� ��ȯ
			// FileOutputStream fout = new FileOutputStream(copy);
			// OutputStreamWriter osw = new OutputStreamWriter(fout);
			// PrintWriter pw = new PrintWriter(osw);
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(copy)));
		
			// 5. String ������ line�� ���� �� �ʱ�ȭ
			String line = null;
			
			// 6. line�� BufferedReader�� ����ؼ� �о�� ������ �־ null�� �� ������ �۵�
			// PrintWriter ������ pw�� ����ؼ� line�� �ִ� ������ �ۼ�
			// pw�� ����Ǿ� �ִ� �ּҸ� �� ���󰡸� ���� �����͸� ����Ʈ �����ͷ� ��ȯ��
			// �������� File ������ copy�� ����Ʈ ��Ʈ���� ����Ͽ� �Է�
			while((line = br.readLine()) != null) {
				// ���� �����͸� ����Ʈ ��Ʈ������ ���
				pw.println(line);
			}
			
			// 7. ����ϰ� �� BufferedReader�� PrintWriter ����
			br.close();
			pw.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// �׸� ������ �����ؼ� �ش� ������ ������ �׸� ���� �����
	static void imgCopy() {
		File img1 = new File("C:/Users/ysmin/Javatest/����.png");
		File img2 = new File("C:/Users/ysmin/Javatest/����2.png");
		
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
			//fout.write(finalArray); // �� ���� ���� ����
			
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
	
	// String �������� �а� ����
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
	
	// Hello.java �ҽ��� ���Ե� ���ڵ��� ��� ��Ƽ� �Ѱ��� ���ڿ��� ǥ���Ͽ� ȭ�鿡 ǥ��
	// �ؽ�Ʈ����(FileReader) -> �޸𸮿� ���ڿ��� ����(StringWriter)
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
	
	// DataInputStream, DataOutputStream Ȱ���Ͽ� ���� ���� �б�
	static void dataStream() {
		// 1. ���� DataOutputStream�� ����Ͽ� ���� ����
		// 1-1. �ۼ��� ���� �ּҸ� dest�� �Է�
		// �ۼ��̱� ������ ���ο� ���� �ּҸ� �Է����൵ ��.
		// dest = C:\Users\ysmin\Javatest\data2.jdata
		File dest = new File("C:/Users/ysmin/Javatest/data2.jdata");
		
		DataOutputStream dout;
		
		try {
			// 1-2. File ������ dest�� �޾� FileOutputStream �������� ��ȯ
			// FileOutputStream�� ����� �� try-catch�� ����ؾ���
			// fout = java.io.FileOutputStream@24d46ca6
			FileOutputStream fout = new FileOutputStream(dest);
			
			// 1-3. FileOutputStream ������ fout�� �޾� DataOutputStream �������� ��ȯ
			// try�� �ȿ��� dout�� �����ϸ� Ȱ���ϱ� �����ϱ� ������ try�� �ۿ��� dout ����
			// dout = java.io.DataOutputStream@4517d9a3
			dout = new DataOutputStream(fout);
			
			// 1-4. DataOutputStream�� Ȱ���Ͽ� File�� �پ��� �������� ����
			dout.writeBoolean(true);
			dout.writeChar('A');
			dout.writeDouble(3.14);
			dout.writeUTF("Hello");
			
			// 1-5. �ۼ��� ������ DataOutputStream �ݱ�
			dout.close();
			
			// 1-6. ���� �ڵ尡 ���� �۵��Ͽ��ٸ� "���� ���� ����"�̶�� ���� ���
			System.out.println("���� ���� ����");
			
			// 2. DataInputStream�� ����Ͽ� �ۼ��� ���� �б�
			// 2-1. src�� File���� �ּҸ� ����
			File src = new File("C:/Users/ysmin/Javatest/data2.jdata");
			
			// 2-2. File �ּҸ� �޾� FileInputStream �������� ��ȯ
			FileInputStream fin = new FileInputStream(src);
			
			// 2-3. FileInputStream ������ DataInputStream �������� ��ȯ
			DataInputStream din = new DataInputStream(fin);
			
			// 2-4. DataInputStream�� ����Ͽ� ���� �˸´� �������� ����
			boolean b = din.readBoolean();
			char ch = din.readChar();
			double d = din.readDouble();
			String s = din.readUTF();
			
			// 2-5. ������ ������ printf ���� ����Ͽ� ����
			System.out.printf("%b\t%c\t%f\t%s\n", b,ch,d,s);
			
			// 2-6. �бⰡ ������ DataInputStream �ݱ�
			din.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
