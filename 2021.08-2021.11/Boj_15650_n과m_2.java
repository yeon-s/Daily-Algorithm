package practice;

import java.util.Scanner;

public class Boj_15650_n과m_2 {

	static int N,M;
	static int[] arr;
	static int[] result;
	static boolean[] isSelected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=i+1;
		}
		isSelected = new boolean[N];
		result = new int[M];
		
		comb(0,0);
	}

	static void comb(int target, int cnt) {
		if(cnt==M) {
			for(int i=0;i<M;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
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
