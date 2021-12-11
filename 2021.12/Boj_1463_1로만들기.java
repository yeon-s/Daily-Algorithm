package practice;

import java.util.Scanner;

public class Boj_1463_1로만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] D = new int[1000001];		//1로 만드는데 쓰는 최소연산수
		D[1]=0;
		
		for(int i=2;i<=N;i++) {
			int min = Integer.MAX_VALUE;
			if(i%3==0) min=Math.min(min, D[i/3]+1);
			if(i%2==0) min=Math.min(min, D[i/2]+1);
			min=Math.min(min, D[i-1]+1);
			
			D[i] = min;
			
		}

		System.out.println(D[N]);
	}

}
