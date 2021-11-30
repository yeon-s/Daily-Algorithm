package practice;

import java.util.Scanner;

public class Boj_2798_블랙잭 {

	static boolean[] isSelected;
	static int N;
	static int[] arr;
	static int M;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		//입력 끝
		
		isSelected = new boolean[N];
		max=0;
		comb(0,0,0);
		System.out.println(max);
		
	}

	static void comb(int target,int cnt,int sum) {
		if(sum>M) {
			return;
		}
		if(cnt==3) {
			max = Math.max(max, sum);
			return;
		}
		if(target==N) {
			return;
		}
		
		isSelected[target] = true;
		comb(target+1,cnt+1,sum+arr[target]);
		isSelected[target]=false;
		comb(target+1,cnt,sum);
		
	}
}
