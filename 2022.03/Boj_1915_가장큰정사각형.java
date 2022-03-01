package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1915_가장큰정사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		//입력 끝
		int[][] D = new int[n][m];
		int max =0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(i<1 || j<1) {
					D[i][j] = map[i][j];
				}else {
					if(map[i][j]==0) {
						D[i][j]=0;
					}else {
						int min=Integer.MAX_VALUE;
						min = Math.min(min, D[i-1][j-1]);
						min = Math.min(min, D[i][j-1]);
						min = Math.min(min, D[i-1][j]);
						D[i][j] = min+1;
					}					
				}
				
				if(max<D[i][j]) {
					max =D[i][j];
				}
			}
		}
		
		System.out.println(max*max);
		
	}

}
