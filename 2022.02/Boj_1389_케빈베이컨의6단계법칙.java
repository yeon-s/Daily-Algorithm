package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1389_케빈베이컨의6단계법칙 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] D = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==j) {
					D[i][j]=0;
					continue;
				}
				D[i][j] = 1000;
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			D[from][to] = D[to][from] = 1;
		}
		
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				if(i==k) {
					continue;
				}
				for(int j=1;j<=N;j++) {
					if(i==j || k==j) {
						continue;
					}
					D[i][j] = Math.min(D[i][k]+D[k][j], D[i][j]);
				}
			}
		}
		
		int min = 5000;
		int[] answer = new int[N+1];
		for(int i=1;i<=N;i++) {
			int sum = 0;
			for(int j=1;j<=N;j++) {
				sum+=D[i][j];
			}
			answer[i]=sum;
			min = Math.min(min, sum);
		}
		
		for(int i=1;i<=N;i++) {
			if(answer[i]==min) {
				System.out.println(i);
				return;
			}
		}
	}

}
