package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1654_랜선자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		long start=1;
		long end = 0;
		int[] lan = new int[K];
		
		for(int i=0;i<K;i++) {
			lan[i] = Integer.parseInt(br.readLine());
			end = Math.max(end, lan[i]);
		}
		
		long answer=0;
		while(start<=end) {
			long mid = (start+end)/2;
			
			long sum=0;
			for(int i=0;i<K;i++) {
				sum+=lan[i]/mid;
			}
			
			if(sum>=N) {
				start=mid+1;
				answer=mid;
			}else {
				end = mid-1;
			}
		}
		
		System.out.println(answer);

	}

}
