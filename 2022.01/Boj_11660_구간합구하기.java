package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11660_구간합구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] D = new int[N+1][N+1];		//각 행들의 합
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				D[i][j]=D[i][j-1]+Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int k=0;k<M;k++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			
			for(int i=x1;i<=x2;i++) {
				sum += D[i][y2]-D[i][y1-1];
			}
			sb.append(sum+"\n");
		}
		
		System.out.println(sb);

	}

}
