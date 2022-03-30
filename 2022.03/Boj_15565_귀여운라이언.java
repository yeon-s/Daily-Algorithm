package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15565_귀여운라이언 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start=0;
		int end=0;
		int cnt=0;
		if(arr[0]==1) cnt++;
		int answer=Integer.MAX_VALUE;
		boolean flag = false;
		
		while(true) {
			
			if(cnt<K) {
				end++;
				if(end>=N) break;
				if(arr[end]==1) cnt++;
			}else {
				flag=true;
				answer = Math.min(answer, end-start+1);
				if(arr[start]==1) cnt--;
				start++;	
			}
		}
		if(!flag) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(answer);
	}

}
