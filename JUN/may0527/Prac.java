package may0527;

import java.util.Scanner;

public class Prac {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] lo = new int[6];
		int[] lot=new int[6];
		int cnt=0;
		
		
		while(true) {
			System.out.println("1.로또 번호 입력 | 2. 이번주 로또 번호 |3. 당첨 확인");
			int lotto = sc.nextInt();
			
	///////자기로또///////////////////////////////////////////////
		if(lotto==1) {
			for (int i = 0; i < lot.length; i++) {
			System.out.print("로또 번호 입력 "+(i+1)+" : ");
			lot[i]=sc.nextInt();
		}
		}
		
		
		
		////////////////////기계로또////////////////////////////
		else if(lotto==2) { for(int i = 0;i<lo.length; i++) {
			lo[i]=(int)(Math.random()*44)+1;
//			System.out.println(lo[i]);
			if(i>=1) {
			for(int j = 0; j<i;j++) {
				if(lo[j]==lo[i]) {
					cnt+=1;
				}	
				else if(cnt>0) {
					i--;
					cnt=0;
					continue;
				}
			}
		}	 System.out.println((i+1)+" 번 : "+lo[i]);
	}
}
		
	
		////////일치검사///////
		else if(lotto==3) {
			for (int i = 0; i <lot.length; i++) {
			for(int j = 0;j<=i; j++) {
				
				if(lo[j]==lot[i]) {
						cnt+=1;
				}
			}	
		}
			System.out.println("일치 번호 수 :" + cnt);
				}
		
		
		}

		
		}	
	}
	

