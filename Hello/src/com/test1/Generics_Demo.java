package com.test1;

import java.util.ArrayList;
import java.util.List;

class Stack<T>{
	List<T> nums = new ArrayList<T>();
	public void add(T itg) {
		nums.add(itg);
	}
	public T pop() {
		int topIdx = nums.size()-1;
		T tmp = nums.get(topIdx);
		nums.remove(topIdx);
		return tmp;
	}
}

class Queue<T>{
	List<T> nums = new ArrayList<T>();
	public void add(T value) {
		nums.add(value);
	}
	public T pop() {
		T value = nums.get(0);
		nums.remove(0); 
		return value;
	}
}


public class Generics_Demo {
	
	public static void main(String[] args) {

//		Stack<Integer> stack = new Stack();
//		stack.add(1);
//		stack.add(2);
//		stack.add(3);
//		stack.add(4);
//		stack.add(5);
//		System.out.println(stack.nums.toString());
//		int top = stack.pop();
//		System.out.println(top);
//		System.out.println(stack.nums.toString());
//		
//		stack.add(7);
//		stack.add(8);
//		System.out.println(stack.nums.toString());
		
		
		Queue<Integer> queue = new Queue();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		System.out.println(queue.nums.toString());
		queue.pop();
		System.out.println(queue.nums.toString());
		
		queue.add(6);
		queue.add(7);
		queue.pop();
		System.out.println(queue.nums.toString());

	}

}
