package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1912_연속합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] D = new int[n];
		D[0]= arr[0];
		int max = D[0];
		
		for(int i=1;i<n;i++) {
			D[i] = Math.max(D[i-1]+arr[i], arr[i]);
			max = Math.max(max, D[i]);
		}
		System.out.println(max);
		
	}

}
