package com.codingtest;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class GetDayOfWeek {
	public static void main(String[] args) {
// 1. LocalDate ����
		LocalDate date = LocalDate.of(2021, 12, 25);
// LocalDateTime date = LocalDateTime.of(2021, 12, 25, 1, 15, 20);
		System.out.println(date); // // 2021-12-25
// 2. DayOfWeek ��ü ���ϱ�
		DayOfWeek dayOfWeek = date.getDayOfWeek();
// 3. ���� ���� ���ϱ�
		int dayOfWeekNumber = dayOfWeek.getValue();
// 4. ���� ���� ���
		System.out.println(dayOfWeekNumber); // 6

		String answer = "";
		switch (dayOfWeekNumber) {
		case 1:
			answer = "MON";
			break;
		case 2:
			answer = "TUE";
			break;
		case 3:
			answer = "WED";
			break;
		case 4:
			answer = "THU";
			break;
		case 5:
			answer = "FRI";
			break;
		case 6:
			answer = "SAT";
			break;
		case 7:
			answer = "SUN";
			break;
		}
	}
}
