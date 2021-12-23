package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1932_정수삼각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<=i;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		int[][] D = new int[n][n];
		D[0][0] = map[0][0];
		for(int i=1;i<n;i++) {
			D[i][0]=D[i-1][0]+map[i][0];
			for(int j=1;j<i;j++) {
				D[i][j]= Math.max(D[i-1][j-1], D[i-1][j])+map[i][j];
			}
			D[i][i]= D[i-1][i-1]+map[i][i];
		}
		
		int max=0;
		for(int i=0;i<n;i++) {
			max = Math.max(max, D[n-1][i]);
		}
		System.out.println(max);
		
	}
	
}
