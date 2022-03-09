package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2616_소형기관차 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		
		//슬라이딩 윈도우
		
		int sum = 0;
		for(int i=1;i<=M;i++) {
			sum+=arr[i];
		}
		
		int[] arr2 = new int[N-M+2];
		arr2[1]=sum;
		for(int i=2;i<N-M+2;i++) {
			sum+=arr[i+M-1];
			sum-=arr[i-1];
			arr2[i] = sum;
		}
		
		int[][] D = new int[4][N+1];
		for(int i=1;i<4;i++) {
			for(int j=i*M;j<=N;j++) {
				D[i][j] = Math.max(D[i][j-1], D[i-1][j-M]+arr2[j-M+1]);
			}
		}
		
		System.out.println(D[3][N]);
		
	}

}
