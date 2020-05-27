package may0527;

import java.util.Scanner;

public class Lotto01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] lo = new int[6];
		int[] lot=new int[6];
		int cnt=0;
	///////자기로또///////////////////////////////////////////////
		for (int i = 0; i < lot.length; i++) {
			System.out.print("로또 번호 입력 "+(i+1)+" : ");
			lot[i]=sc.nextInt();
		}
		
		
		
		////////////////////기계로또////////////////////////////
		for(int i = 0;i<lo.length; i++) {
			lo[i]=(int)(Math.random()*44)+1;
//			System.out.println(lo[i]);
			if(i>=1) {
			for(int j = 0; j<i;j++) {
				if(lo[j]==lo[i]) {
//					System.out.println("lo[i]:"+lo[i]);
//					System.out.println("lo[j]:"+lo[j]);
					cnt+=1;
//					System.out.println("cnt"+cnt);
				}	
				else if(cnt>0) {
					i--;
					cnt=0;
					continue;
				}
			}
		}	
	}
//		for(int i = 0;i<lo.length; i++) {
//			System.out.printf("%1t번호 %d : %d",i+1,lo[i]);
//		}
///////////////////////////////////////////////		
		
	
		////////일치검사///////
		for (int i = 0; i < lot.length; i++) {
			for(int j = 0;j<i; j++) {
				
				if(lo[j]==lot[i]) {

						cnt+=1;
				
					}	
					}
				}
		System.out.println("일치 수 :" + cnt);
		
			}	
		
	
	
	
	////////////////////////메소드////////////////////////////////////////////
	
	public void com(int v[]) {
		
		
	}
}
