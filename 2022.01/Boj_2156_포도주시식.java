package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2156_포도주시식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] D = new int[n][3];
		D[0][0]=0;
		D[0][1]=arr[0];
		D[0][2]=0;
		
		for(int i=1;i<n;i++) {
			D[i][0]= Math.max(D[i-1][2], D[i-1][1]);
			D[i][0]=Math.max(D[i][0], D[i-1][0]);
			D[i][1]=D[i-1][0]+arr[i];
			D[i][2]=D[i-1][1]+arr[i];
		}
		
		int max = D[n-1][0];
		max = Math.max(D[n-1][1], max);
		max = Math.max(max, D[n-1][2]);
		
		System.out.println(max);
		
		
	}

}
