package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_3079_입국심사 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] test = new int[N];
		long max=0;
		
		for(int i=0;i<N;i++) {
			test[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, test[i]);
		}
		//입력 끝
		
		long start=0;
		long end = max*M;
		long answer=Long.MAX_VALUE;
		while(start<=end) {
			long mid = (start+end)/2;
			
			long sum=0;
			for(int i=0;i<N;i++) {
				sum+=mid/test[i];
			}
			
			if(sum>=M) {
				end = mid-1;
				answer=Math.min(answer, mid);
			}else {
				start=mid+1;
			}
		}
		
		System.out.println(answer);
		
	}

}
