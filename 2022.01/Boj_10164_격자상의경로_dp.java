package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10164_격자상의경로_dp {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int[][] memo = new int[N][M];
		memo[0][0]=0;
		for(int i=1;i<N;i++) {
			memo[i][0]=1;
		}
		for(int j=1;j<M;j++) {
			memo[0][j]=1;
		}
		
		
		if(K==0) {
			for(int i=1;i<N;i++) {
				for(int j=1;j<M;j++) {
					memo[i][j] = memo[i-1][j]+memo[i][j-1]; 
				}
			}
			
			System.out.println(memo[N-1][M-1]);
		}else {
			int num=1;
			int n=0;
			int m=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					map[i][j]=num++;
					if(map[i][j]==K) {
						n=i;
						m=j;
					}
				}
			}
			
			int one;
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					memo[i][j] = memo[i-1][j]+memo[i][j-1]; 
				}
			}
			one = memo[n][m];
			
			memo = new int[N][M];
			memo[n][m]=0;
			for(int i=n+1;i<N;i++) {
				memo[i][m]=1;
			}
			for(int j=m+1;j<M;j++) {
				memo[n][j]=1;
			}
			
			int two;
			for(int i=n+1;i<N;i++) {
				for(int j=m+1;j<M;j++) {
					memo[i][j] = memo[i-1][j]+memo[i][j-1]; 
				}
			}
			two = memo[N-1][M-1];
			System.out.println(one*two);
			
		}
		

	}

}
