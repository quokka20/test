package com.test1;

public class PasswordInputException extends Exception {

	public PasswordInputException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "숫자 2개 이상, 알파벳 4개 이상으로 구성해주세요.";
	}

	
	public String getAdvice() {
		return "숫자 2개 이상, 알파벳 4개 이상으로 구성해주세요.";
		
	}
}
