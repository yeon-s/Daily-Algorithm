package practice;

import java.util.Arrays;

public class 조합_연습 {
	
	static int N=7,R=4;
	static int[] arr = {5,6,7,8,9,10,11};
	static boolean[] isSelected = new boolean[N];
	static int[] result = new int[R];
	public static void main(String[] args) {
		
		comb(0,0);
	}
	
	static void comb(int target, int cnt ) {
		if(cnt==R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		if(target==N) {
			
			return;
		}
		
		isSelected[target] = true;
		result[cnt] = arr[target];
		comb(target+1,cnt+1);
		isSelected[target] = false;
		comb(target+1,cnt);
	}
}
