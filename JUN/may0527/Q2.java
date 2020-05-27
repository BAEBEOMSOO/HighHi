package may0527;

public class Q2 {

	public static void main(String[] args) {
		int[] a = new int[10]; //0~9 번호
		int[] b = new int[100]; //실행값 저장
		int cnt =0; //중복
		int temp=a[0]; //최빈값 검출 위한 변수
		int x=0; // 최빈값 번호....검출
		
//배열 채우기
		for (int i = 0; i <10; i++) {
			a[i]=i;
		} 
		for (int i = 0; i <100; i++) {
			b[i]=(int)(Math.random()*10);
		} 
		
//중복검사
		for (int i = 0; i <a.length; i++) {
			for (int j = 0; j < b.length; j++) {	
				if(a[i]==b[j]) {
					cnt+=1;
				}
			}	
			System.out.printf("a[%d]열의 중복 수  : %d번\n",i,cnt);
			a[i]=cnt;
			cnt=0;
		}
		
//빈도+최빈값
		for (int j = 0; j < a.length; j++) {	
			if(a[j]>a[temp]) {
				temp=j;
			}
			
//			for (int j = 0; j < a.length; j++) {	
//				if(a[j]>temp) {
//					temp=a[j];
//				}
//				if(a[j]==temp) {
//					x=j;
//				}
//			}		
			
		
//최빈값
//		for (int j = 0; j < a.length; j++) {	
//			if(a[j]==temp) {
//				x=j;
//				//break;
//			}
		}

		System.out.printf("최빈값 : %d, 발생빈도 : %d회\n",temp,a[temp]);
	}

}	