package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_9465_스티커2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] map = new int[2][n];
			for(int i=0;i<2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 끝
			
			boolean[][] visited = new boolean[2][n];
			int[] D = new int[n];
			D[0] = Math.max(map[0][0], map[1][0]);
			for(int i=1;i<n;i++) {
				if(visited[0][i-1]) {
					if(map[0][i-1]+map[1][i]>map[0][i]) {
						visited[1][i] = true;
						D[i] = D[i-1]+map[1][i];
					}else {
						visited[0][i-1]=false;
						visited[0][i] =true;
						D[i]=D[i-1]-map[0][i-1]+map[0][i];
					}
				}else {
					if(map[1][i-1]+map[0][i]>map[1][i]) {
						visited[0][i] = true;
						D[i] = D[i-1]+map[0][i];
					}else {
						visited[1][i-1]=false;
						visited[1][i] =true;
						D[i]=D[i-1]-map[1][i-1]+map[1][i];
					}
				}
			}
			System.out.println(D[n-1]);
		}
	}

}
