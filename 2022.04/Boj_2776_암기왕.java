package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2776_암기왕 {

	static int[] arr1;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			arr1 = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			int[] arr2 = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr1);
			
			for(int i=0;i<M;i++) {
				int answer = check(arr2[i]);
				sb.append(answer+"\n");
			}
		}
		System.out.println(sb);
	}
	
	static int check(int m) {
		int start =0;
		int end = N-1;
		
		while(start<=end) {
			int mid = (start+end)/2;
			
			if(arr1[mid]>m) {
				end=mid-1;
			}else if(arr1[mid]<m) {
				start=mid+1;
			}else {
				return 1;
			}
		}
		
		return 0;
	}

}
