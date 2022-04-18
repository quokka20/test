package com.test1;

import java.util.Arrays;
import java.util.Random;

public class ArrayTest2 {
	// static String[] name;
	// ��� ����
	// static�� ������ static ����(���� ����, Ŭ���� ����)

	public static void main(String[] args) {
//		multiDimArray();
//		arrayOfArray();
//		arrayInit();
		
//		Random rd = new Random();
//		int[] ran;
//		ran = new int[5];
//		for(int i = 0; i<ran.length; i++) {
//			ran[i] = rd.nextInt(10);
//		}
//		System.out.println(Arrays.toString(ran));
//		System.out.println(sumOfArray(ran));
		
		System.out.println(Arrays.toString(getRandom(7)));
		
		
	}
	
	static void multiDimArray() {
		//������ �迭(2���� �迭, two-Dimensional Array)
		int[][] score; //�迭 ���� ����
		
		score = new int[2][3]; // 24����Ʈ �Ҵ�
		score[0][0] = 3;
		score[0][1] = 5;
		score[0][2] = 7;
		score[1][0] = 2;
		score[1][1] = 4;
		score[1][2] = 6;
		
		int sum = 0;
		int count = 0;
		
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				System.out.println(score[i][j]);
				sum += score[i][j];
				count += 1;
			}
		}
		System.out.println("���� "+sum);
		System.out.println("����� "+(float)sum/count);
	}

	static void arrayOfArray() {
		int[][] score;
		score = new int[2][];
		
		score[0] = new int[4];
		score[1] = new int[2];
		
		Random rd = new Random();
		int sum = 0;
		
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				score[i][j] = rd.nextInt(100);
//				System.out.println(score[i][j]);
			}
		}
		
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				sum += score[i][j];
			}
		}
		
		System.out.println(Arrays.toString(score[0]));
		System.out.println(Arrays.toString(score[1]));
		System.out.println(sum);
	}

	//�迭 �ʱ�ȭ�� �����ϰ� �ϴ� �ٸ� ���
	static void arrayInit() {
		int[] score = {3,5,7};
		System.out.println(Arrays.toString(score));
		float avg = (score[0]+score[1]+score[2])/(float)score.length;
		System.out.printf("����� %.1f \n", avg);
		
		int[] num;
//		num = {1,2,3}; ������
		num = new int[] {1,2,3};
		System.out.println(Arrays.toString(num));
	}

	//�迭�� �޼ҵ� �Ķ����, ����Ÿ������ �����ϱ�
	static double[] arrayParam(int[] point) {
		int sum = 0;
		double avg = 0.0;
		for(int i =0; i<point.length; i++) {
			sum += point[i];
		}
		
		avg = sum/(double)point.length;
		double[] variance = new double[point.length];
		for(int i=0; i<point.length; i++) {
			variance[i] = point[i]-avg;
		}
				
		return variance;
	
	}

	static int sumOfArray(int[] ran) {
		int sum = 0;
		
		for(int i = 0; i<ran.length; i++) {
			sum += ran[i];
		}
		return sum;
	}

	static int[] getRandom(int cnt) {
		Random rd = new Random();
		int[] arr;
		arr = new int[cnt];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = rd.nextInt(10);
			System.out.println(arr[i]);
		}
		return arr;
	}
}
