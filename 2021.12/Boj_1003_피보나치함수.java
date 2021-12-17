package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1003_피보나치함수 {

	static int[] memo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
		
			memo= new int[N+2];
			memo[0]=1;
			memo[1]=0;
			for(int i=2;i<=N+1;i++) {
				memo[i] = memo[i-1]+memo[i-2];
			}
			
			sb.append(memo[N]+" "+memo[N+1]+"\n");
		}
		System.out.println(sb);

	}
	
//	static int fibo(int n) {
//		if(n==0) {
//			return 1;
//		}
//		if(n==1) {
//			return 0;
//		}
//		
//		if(memo[n]==0) {
//			memo[n] = fibo(n-1)+fibo(n-2);
//			return memo[n];
//		}
//		
//		return memo[n];
//	}

}
