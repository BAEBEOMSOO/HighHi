package may0527;

public class Ex02 {
public static void main(String[] args) {
	int arr[]=new int[5];
	int i;
	int temp;
	
	
	
	
	
	for(i=0; i<arr.length; i++) {
		arr[i]=(int)(Math.random()*100)+1;
	}
	
	for( i=0; i<arr.length-1; i++) {
		for(int j = i+1; j<arr.length; j++) {
			if(arr[j]<arr[i]) {
				temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}
		}
	}
			
			for( i=0; i<arr.length; i++) {
				System.out.println(arr[i]);
			
			
	}
	
	

	
}
}
