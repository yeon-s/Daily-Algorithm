package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1238_파티 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[][] D = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				D[i][j] = 10000000;
				if(i==j) {
					D[i][j]=0;
				}
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			D[from][to] = weight;
		}
		
		//플로이드 워샬
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					D[i][j] = Math.min(D[i][k]+D[k][j], D[i][j]);
				}
			}
		}
		
		int[] d = new int[N+1];
		int max=0;
		
		for(int i=1;i<=N;i++) {
			d[i] = D[i][X]+D[X][i];
			if(d[i]>max) {
				max= d[i];
			}
		}
		
		System.out.println(max);
		
	}

}
