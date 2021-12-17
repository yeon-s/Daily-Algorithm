package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2579_계단오르기_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] stairs = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] D = new int[N+1][3];
		
		D[1][1]= stairs[1];
		
		for(int i=2;i<=N;i++) {
			D[i][1] = Math.max(D[i-2][1], D[i-2][2])+stairs[i];
			D[i][2] = D[i-1][1]+stairs[i];
		}
		
		System.out.println(Math.max(D[N][1], D[N][2]));
		
	}

}
