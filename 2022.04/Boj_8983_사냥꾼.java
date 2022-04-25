package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_8983_사냥꾼 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=  new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int[] a = new int[N];
		int[] b = new int[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer=0;
		
		for(int i=0;i<N;i++) {
			int start = 0;
			int end = M-1;
			boolean flag=false;
			
			while(start<=end) {
				int mid = (start+end)/2;
				
				int dist = Math.abs(arr[mid]-a[i])+b[i];
				
				if(dist<=L) {
					flag=true;
					break;
				}else {
					if(arr[mid]>a[i]) {
						end=mid-1;
					}else {
						start=mid+1;
					}
				}
			}
			if(flag) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
		
	}

}
