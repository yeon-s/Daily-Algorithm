package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10211_MaximumSubarray {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] sum = new int[N];
			sum[0]=arr[0];
			for(int i=1;i<N;i++) {
				sum[i]=arr[i]+sum[i-1];
			}
			
			int[] D = new int[N];
			D[0]=arr[0];
			for(int i=1;i<N;i++) {
				int max = sum[i];
				for(int j=0;j<i;j++) {
					max = Math.max(max, sum[i]-sum[j]);
				}
				
				D[i] = Math.max(D[i-1], max);
			}
			sb.append(D[N-1]+"\n");
		}
		System.out.println(sb);
	}

}
