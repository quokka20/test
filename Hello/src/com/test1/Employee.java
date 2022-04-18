package com.test1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

// Ŭ������ final�� ���̸� �ڽ�Ŭ������ ������� �� ����.
public class Employee {
	
	int empno;
	String ename;
	int deptno;
	int salary;
	
	static final String company = "Good IT";
	
	public Employee() {}
	
	public Employee(int empno, String ename, int deptno, int salary) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.deptno = deptno;
		this.salary = salary;
	}
	
	public void print() {
		System.out.printf("%d %s %d %d \n", empno, ename, deptno, salary);
	}

	
	
	@Override
	public boolean equals(Object obj) {
		Employee e = (Employee) obj;
		return (empno == e.empno) && (ename.equals(e.ename));
	}



	@Override
	public int hashCode() {
		return Objects.hash(empno, ename);
	}
	
	// �޼ҵ忡 final�� ���� �������̵� ����
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%d %s", empno,ename);
	}


	public static void main(String[] args) {
		Employee e1 = new Employee(11,"Smith", 10, 2500);
		Employee e2 = new Employee(12,"Blake", 20, 3100);
		Employee e3 = new Employee(11,"Smith", 10, 2500);
		System.out.println(String.valueOf(e1));
		
		System.out.println(company);
		
		
		// �̷� ��Ȳ���� equals�� �ᵵ ==�� ���� ����� �Ѵ�.
		// equals�� �������̵带 �ؼ� ����ϸ� ��
//		System.out.println(e1==e2);
//		System.out.println(e1.equals(e2));
//		
//		System.out.println(e1==e3);
//		System.out.println(e1.equals(e3));
//		
//		System.out.println(e1.hashCode() == e3.hashCode());
//		
//		
//		Integer intObj = Integer.valueOf(5);
//		
//		int a = intObj;	//Unboxing, intObj.intValue()
//		
//		Integer io = 7; //Auto-Boxing
//		
//		System.out.println(intObj);
		
//		ArrayList<Employee> el = new ArrayList<>();
//		el.add(e1);
//		el.add(e2);
//		el.add(e3);
//		
//		for(int i = 0; i<el.size(); i++) {
//			String name = el.get(i).ename;
//			System.out.println(name);
			
		// Set�� �ߺ��� �����ϱ� ���ؼ� ���ϼ� �񱳸� �����ϴµ�
		// equals()�� true�� �����ϰ�, hashCode()�� ������ ���� �������� ���Ѵ�
		// �׷��� equals()�� true�� �����ϰ� hashCode()�� ������ �� �ߺ����� �����Ѵ�.
//		HashSet<Employee> es = new HashSet<>();
		Set<Employee> es = new HashSet<>();
		es.add(e1);
		es.add(e2);
		es.add(e3);
		System.out.println(es.size());
		Iterator ss = es.iterator();
		while(ss.hasNext()) {
			Employee sss = (Employee)ss.next();
			System.out.println(sss.ename);
			
		}
		
		
	}




		
}


