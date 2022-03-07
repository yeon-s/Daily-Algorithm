package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_2467_용액2_투포인터 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Integer[] arr = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start=0;
		int end=N-1;
		int min = Integer.MAX_VALUE;
		int[] answer = new int[2];
		answer[0]=arr[0];
		answer[1]=arr[N-1];
		
		while(start<end) {
			int sum = arr[start]+arr[end];
			
			if(Math.abs(sum)<min) {
				answer[0]=arr[start];
				answer[1]=arr[end];
				min = Math.abs(sum);
			}
			
			if(sum<0) {
				start++;
			}else {
				end--;
			}
			
		}
		System.out.println(answer[0]+" "+answer[1]);
	}

}
