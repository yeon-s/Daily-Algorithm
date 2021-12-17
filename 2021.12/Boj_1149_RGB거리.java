package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1149_RGB거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] house = new int[N][3];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			house[i][0] = Integer.parseInt(st.nextToken());
			house[i][1] = Integer.parseInt(st.nextToken());
			house[i][2] = Integer.parseInt(st.nextToken());
		}
		//입력 끝
		
		int[][] D = new int[N][3];
		
		for(int i=0;i<3;i++) {
			D[0][i] = house[0][i];
		}
		
		for(int i=1;i<N;i++) {
			D[i][0] = Math.min(D[i-1][1], D[i-1][2])+house[i][0];
			D[i][1] = Math.min(D[i-1][0], D[i-1][2])+house[i][1];
			D[i][2] = Math.min(D[i-1][1], D[i-1][0])+house[i][2];
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0;i<3;i++) {
			min = Math.min(min, D[N-1][i]);
		}
		
		System.out.println(min);

	}

}
