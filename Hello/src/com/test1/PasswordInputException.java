package com.test1;

public class PasswordInputException extends Exception {

	public PasswordInputException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "���� 2�� �̻�, ���ĺ� 4�� �̻����� �������ּ���.";
	}

	
	public String getAdvice() {
		return "���� 2�� �̻�, ���ĺ� 4�� �̻����� �������ּ���.";
		
	}
}
