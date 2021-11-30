package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_15649_n과m_1 {

	static int N,M;
	static int[] arr;
	static boolean[] isSelected;
	static int[] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();

		arr= new int[N];
		isSelected =new boolean[N];
		result= new int[M];
		
		for(int i=0;i<N;i++) {
			arr[i]= i+1;
		}
		
		perm(0);
	}

	static void perm(int cnt) {
		if(cnt==M) {
			for(int i=0;i<M;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(isSelected[i]) {
				continue;
			}
			result[cnt] = arr[i];
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i]=false;
		}
	}
}
