package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_2805_나무자르기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Integer[] arr = new Integer[N];
		st = new StringTokenizer(br.readLine());
		int mx = 0;
		for(int i=0;i<N;i++) {
			 arr[i]= Integer.parseInt(st.nextToken());
			 mx= Math.max(mx, arr[i]);
		}
		//입력 끝
	
		int mid=0;
		int start = 0;
		int end = mx;
		int max=0;
		while(start<=end) {
			mid = (start+end)/2;
			
			long sum=0;
			for(int i=0;i<N;i++) {
				if(arr[i]>mid) {
					sum+=(arr[i]-mid);
				}
			}
			
			if(sum<M) {
				end = mid-1;
			}else{
				start = mid+1;
				max=mid;
			}
			
		}
		
		System.out.println(max);

	}

}
