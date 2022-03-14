package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11404_플로이드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] D = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==j) {
					continue;
				}
				D[i][j] = 100000000;
			}
		}
		
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if(D[from][to]>weight) {
				D[from][to]=weight;
			}
		}
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				if(k==i) {
					continue;
				}
				for(int j=1;j<=n;j++) {
					if(k==j || i==j) {
						continue;
					}
					D[i][j] = Math.min(D[i][k]+D[k][j], D[i][j]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(D[i][j]==100000000) {
					D[i][j]=0;
				}
				sb.append(D[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
