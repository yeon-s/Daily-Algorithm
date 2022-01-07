package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2343_기타레슨 {

	static int N;
	static int M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int start = 0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i]>start) {
				start=arr[i];
			}
		}
		//입력 끝
		
		int end = ((N*10000)/M)+1;
		int mid=0;
		int min=Integer.MAX_VALUE;
		while(start<=end) {
			mid = (start+end)/2;
			
			if(check(mid)) {
				end=mid-1;
				min=mid;
			}else {
				start=mid+1;
			}
		}
		
		System.out.println(min);
		
	}
	
	static boolean check(int mid) {
		int num=0;
		long sum=arr[0];
		for(int i=1;i<N;i++) {
			if(sum+arr[i]<=mid) {
				sum+=arr[i];
			}else {
				sum=arr[i];
				num++;
			}
		}
		
		if(num+1<=M) {
			return true;
		}else {
			return false;
		}
	}

}
