package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1263_사람네트워크2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] adjMatrix = new int[N+1][N+1];
			
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					adjMatrix[i][j] = Integer.parseInt(st.nextToken());
					if(adjMatrix[i][j]==0 && i!=j) {
						adjMatrix[i][j] = 10000;
					}
				}
			}
			//입력 끝
			
			for(int k=1;k<=N;k++) {
				for(int i=1;i<=N;i++) {
					if(i==k) {
						continue;
					}
					for(int j=1;j<=N;j++) {
						if(j==i || j==k) {
							continue;
						}
						adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k]+adjMatrix[k][j]);
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			
			for(int i=1;i<=N;i++) {
				int sum=0;
				for(int j=1;j<=N;j++) {
					sum+=adjMatrix[i][j];
					if(sum>=min) {
						break;
					}
				}
				min = Math.min(min, sum);
			}
			
			System.out.println("#"+tc+" "+min);
			
		}
	}

}
