package may0527;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
//		String str1="홍길동";
//		String str2="임꺽정";
//		String str4="임꺽정";
//		String str3=new String("홍길동");
//		
//		if(str1.equals(str2))
//			System.out.println("일치");
//		else
//		System.out.println("불일치");
//		
//		
//		if(str4.equals(str2))
//		System.out.println("일치");		
//		else
//		System.out.println("불일치");
		
		
//		int[] score = new int[5];
//		Scanner sc=new Scanner(System.in);
//		int sum=0;
//		
//		for (int i = 0; i < score.length; i++) {
//			System.out.println("값 입력");
//			score[i]=sc.nextInt();
//			sum += score[i];
//		}
//		
//		double avg = (double)sum/score.length;
//		System.out.println("평균"+avg);
		
		int[] arr= new int[5];
		int temp=arr[0];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*101);
			System.out.println(arr[i]);
			
			if(arr[i]>temp) {
				temp=arr[i];
		}
	}
		
		System.out.println("최대값"+temp);
		

		}
	}
