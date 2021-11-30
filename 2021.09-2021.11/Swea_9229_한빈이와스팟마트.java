package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_9229_한빈이와스팟마트 {

	static int N;
	static int M;
	static int[] arr;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N  = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			//입력 끝
			max=0;
			comb(0,0,0);
			if(max==0) {
				System.out.println("#"+tc+" -1");
			}else {
				System.out.println("#"+tc+" "+max);				
			}
		}
	}
	
	static void comb(int start,int cnt,int sum) {
		if(sum>M) {
			return;
		}
		if(cnt==2) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=start;i<N;i++) {
			
			comb(i+1,cnt+1,sum+arr[i]);
		}
	}

}
