package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//에라토스테네스의 체
public class Boj_1929_소수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		boolean prime[] = new boolean[N+1];
		prime[0]=prime[1]=true;
		
		for(int i=2;i<=N;i++) {
			if(!prime[i]) {
				for(int j=2;j<=N/i;j++) {
					prime[i*j]=true;
				}
			}
		}
		
		for(int i=M;i<=N;i++) {
			if(!prime[i]) {
				sb.append(i+"\n");
			}
		}
		
		
		System.out.println(sb);

	}

}
