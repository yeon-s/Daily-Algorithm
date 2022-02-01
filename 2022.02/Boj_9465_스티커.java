package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9465_스티커 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int [3][n];
			
			for(int i=1;i<3;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] D = new int[3][n];
			D[0][0] = 0;
			D[1][0] = arr[1][0];
			D[2][0] = arr[2][0];
			
			for(int i=1;i<n;i++) {
				D[0][i] = Math.max(D[0][i-1], D[1][i-1]);
				D[0][i] = Math.max(D[0][i], D[2][i-1]);
				D[1][i] = Math.max(D[0][i-1], D[2][i-1])+arr[1][i];
				D[2][i] = Math.max(D[0][i-1], D[1][i-1])+arr[2][i];
						
			}
			
			int answer = Math.max(D[0][n-1], D[1][n-1]);
			answer = Math.max(answer, D[2][n-1]);
			sb.append(answer+"\n");
			
		}
		System.out.println(sb);
		
		
	}

}
