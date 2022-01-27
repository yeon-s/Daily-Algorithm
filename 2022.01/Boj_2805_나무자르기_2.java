package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2805_나무자르기_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] tree = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		int start =0;
		int end = 1000000000;
		int ans=0;
		while(start<=end) {			
			int mid = (start+end)/2;
			int sum=0;
			for(int i=0;i<N;i++) {
				if(tree[i]>mid) {
					sum+=tree[i]-mid;
					if(sum>M) {
						break;
					}
				}
			}
			
			if(sum>=M) {
				start=mid+1;
				ans=mid;
			}else {
				end=mid-1;
			}
		}
		
		System.out.println(ans);

	}

}
