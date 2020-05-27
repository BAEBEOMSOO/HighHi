package may0527;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		int[] arr=new int[10];
		boolean bo =true;
		Scanner sc = new Scanner(System.in);

		while(bo) {
			System.out.println("1. 예약확인 | 2. 예약");
			int i = sc.nextInt();

			if (i==1) {
				book(arr);
			}

			else if (i==2) {
				System.out.println("좌석선택(1~10) : ");
				int x=sc.nextInt();

				if(x>0&&x<11) {

					if(arr[x-1]==1) {
						System.out.println("예약석 입니다.");
						book(arr);
						continue;

					} 
					else {
						arr[x-1] = arr[x-1]+1;
						book(arr);
					}
				}

				else {
					System.out.println("잘못된 값 입력");
					continue;
				}
			}

			else {
				System.out.println("잘못된 값 입력.");
			}

			

			System.out.println("계속하시겠습니까? y/n");
			sc.nextLine();
			char t = sc.nextLine().charAt(0);
			if(t=='y') {
				continue;
			}
			else if(t=='n'){
				System.out.println("종료");
				bo= false;
			}else {
				System.out.println("잘못된 값 입력");
			}
		}
	}
	/////////////////////////////////////////////////////////////////////////////

	public static void book(int[] v) {
		System.out.print("--------------------------------------------------\n");
		for (int j = 1; j < v.length+1; j++) {
			System.out.printf("%4d",j);
		}
		System.out.println();
		for (int j = 0; j < v.length; j++) {
			System.out.printf("%4d",v[j]);
		}
		System.out.print("\n--------------------------------------------------\n");
	}


}