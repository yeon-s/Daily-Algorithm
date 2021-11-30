package practice;

import java.util.Arrays;
import java.util.Stack;


public class 순열_연습 {

	static int N=6,R=4;
	static int[] arr = {7,8,9,10,11,12};
	static int[] result= new int[4];
	static boolean[] isSelected= new boolean[6];
	
	public static void main(String[] args) {
		
		perm(0);
		
		
		
	}

	
	static void perm(int cnt) {
		if(cnt==R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(isSelected[i]) {
				continue;
			}
			result[cnt]=arr[i];
			isSelected[i]=true;
			perm(cnt+1);
			isSelected[i]=false;
		}
	}
}
