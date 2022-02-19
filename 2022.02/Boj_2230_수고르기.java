package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2230_수고르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N =Integer.parseInt(st.nextToken());
		int M =Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//입력 끝
		
		Arrays.sort(arr);
		
		int start = 0;
		int end=0;
		long min = Long.MAX_VALUE; 
		
		while(end<N && start<=end) {
			
			int num = arr[end]-arr[start];
			
			if(num<M) {
				end++;
			}else {
				start++;
				if(num<min) {
					min=num;
				}
			}
		}
		
		System.out.println(min);
	}

}
