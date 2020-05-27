package may0527;

public class Ex04 {

	public static void main(String[] args) {
		int[] a = new int[] {10,20,30,40,50};
		
		int result = test(a);
		System.out.printf("result:%d\n",result);
		
	}

	//////////////////////////////////////////
	public static int test(int[] b) {
		int sum = 0;
		for (int i = 0; i < b.length; i++) {
			sum+=b[i];
		}
		return sum;
		
	}
}
