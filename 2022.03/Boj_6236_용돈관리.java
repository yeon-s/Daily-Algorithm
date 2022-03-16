package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_6236_용돈관리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int max = 0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		int start=max;
		int end = 1000000000;

		int answer=0;
		while(start<=end) {
			int mid = (start+end)/2;
			
			int cnt=1;
			int temp=mid;
			for(int i=0;i<N;i++) {
				if(temp>=arr[i]) {
					temp-=arr[i];
				}else {
					temp=mid;
					cnt++;
//					if(temp<arr[i]) {
//						cnt=M+1;
//						break;
//					}
					temp-=arr[i];
				}
			}
			
			if(cnt<=M) {
				end=mid-1;
				answer=mid;
			}else {
				start=mid+1;
			}
		}
		
		System.out.println(answer);
	}

}
