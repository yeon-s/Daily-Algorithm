package practice;

import java.util.Arrays;

public class 부분조합_연습 {

	static int N=5;
	static int[] arr = {2,4,6,8,10};
	static int[] result = new int[N];
	static boolean[] isSelected=new boolean[N];
	
	
	public static void main(String[] args) {
		subset(0);

	}

	static void subset(int target) {
		if(target==N) {
			for(int i=0;i<N;i++) {
				if(isSelected[i]) {
					System.out.print(arr[i]);
				}
			}
			System.out.println();
			return;
		}
		
		isSelected[target]=true;
	
		subset(target+1);
		isSelected[target]=false;
		
		subset(target+1);
	}
}
