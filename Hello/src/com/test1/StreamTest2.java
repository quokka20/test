package com.test1;

import java.io.*;
import java.util.ArrayList;

public class StreamTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		dataStream();
//		objectStream();
//		objectInput();
		empList();
	}
	
	static void dataStream() {
		//	DataInputStream, DataOutputStream
		File dest = new File("C:/Users/ysmin/Javatest/data.jdata");
		DataOutputStream dout = null;
		try {
			FileOutputStream fout = new FileOutputStream(dest);
			dout = new DataOutputStream(fout);
			dout.writeBoolean(true);
			dout.writeChar('A');
			dout.writeDouble(3.141592);
			dout.writeUTF("Hello");
			dout.close();
			System.out.println("파일쓰기성공");
			
			File src = new File("C:/Users/ysmin/Javatest/data.jdata");
			FileInputStream fin = new FileInputStream(src);
			DataInputStream din = new DataInputStream(fin);
			boolean b = din.readBoolean();
			char ch = din.readChar();
			double db = din.readDouble();
			String s = din.readUTF();
			System.out.printf("%b\t%c\t%f\t%s\n",b,ch,db,s);
			din.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

	static void objectStream() {
		File dest = new File("C:/Users/ysmin/Javatest/emp.obj");
		try {
			//FileOutputStream fout = new FileOutputStream(dest);
			//ObjectOutputStream oos = new ObjectOutputStream(fout);
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dest));
			Emp emp = new Emp();
			emp.empno = 11;
			emp.ename = "Smith";
			emp.salary = 12.3F;
			emp.married = false;
//			emp.print();
			
			oos.writeObject(emp);
			oos.flush();
			oos.close();
			System.out.println("직렬화 성공");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void objectInput() {
		try {
			File src = new File("C:/Users/ysmin/Javatest/emp.obj");
			FileInputStream fin = new FileInputStream(src);
			ObjectInputStream oin = new ObjectInputStream(fin);
			
			Object obj = oin.readObject();
			Emp emp = (Emp)obj;
			emp.print();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// Emp 객체 3개를 직렬화/역직렬화하여 print()를 호출해보세요.
	static void empList() {
		try {
			File dest = new File("C:/Users/ysmin/Javatest/emp2.obj");
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dest));
			
			ArrayList<Emp> list = new ArrayList<>();
			list.add(new Emp(12, "Blake", 15.2F,true));
			list.add(new Emp(13, "Steve", 13.2F, false));
			list.add(new Emp(14, "Kevin", 11.6F, false));
			
			oos.writeObject(list); // 직렬화
			oos.flush();
			oos.close();
			System.out.println("직렬화성공");
			
			File src = new File("C:/Users/ysmin/Javatest/emp2.obj");
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream(dest));
			
			ArrayList<Emp> list2 = (ArrayList<Emp>)oin.readObject(); // 역직렬화
			for(int i = 0; i<list2.size(); i++) {
				list2.get(i).print();
			}
			
			oin.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}

// 직렬화(Serializable)
class Emp implements Serializable{
	int empno;
	String ename;
	float salary;
	boolean married;
	
	public Emp() {}

	public Emp(int empno, String ename, float salary, boolean married) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.salary = salary;
		this.married = married;
	}
	
	public void print() {
		System.out.printf("%d %s %.1f %b \n", empno, ename, salary, married);
	}
}







