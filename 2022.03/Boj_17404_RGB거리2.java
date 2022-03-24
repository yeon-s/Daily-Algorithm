package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17404_RGB거리2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][3];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		int answer=Integer.MAX_VALUE;
		for(int k=0;k<3;k++) {
			int[][] D = new int[N][3];
			for(int i=0;i<3;i++) {
				if(i==k) {
					D[0][i] = map[0][i];
					continue;
				}
				D[0][i] = 1001*N;
			}
			
			
			for(int i=1;i<N;i++) {
				D[i][0] = Math.min(D[i-1][1], D[i-1][2])+map[i][0];
				D[i][1] = Math.min(D[i-1][0], D[i-1][2])+map[i][1];
				D[i][2] = Math.min(D[i-1][0], D[i-1][1])+map[i][2];
			}
			
			int temp=0;
			if(k==0) {
				temp = Math.min(D[N-1][1], D[N-1][2]);
			}else if(k==1) {
				temp = Math.min(D[N-1][0], D[N-1][2]);
			}else {
				temp = Math.min(D[N-1][1], D[N-1][0]);
			}
			answer = Math.min(answer, temp);
		}
		
		System.out.println(answer);
		
		

	}
	
	static class Point{
		int start;
		int d;
		public Point(int start, int d) {
			super();
			this.start = start;
			this.d = d;
		}
		
	}

}
