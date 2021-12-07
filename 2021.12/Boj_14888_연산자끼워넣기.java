package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14888_연산자끼워넣기 {

	static int N;
	static int[] arr;
	static int[] cal;
	static long max;
	static long min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		cal = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}
		max = Long.MIN_VALUE;
		min = Long.MAX_VALUE;
		perm(1,arr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	static void perm(int cnt,long sum) {
		
		if(cnt==N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(cal[i]<=0) {
				continue;
			}
			cal[i]--;
			if(i==0) {
				perm(cnt+1,sum+arr[cnt]);
			}else if(i==1) {
				perm(cnt+1,sum-arr[cnt]);
			}else if(i==2) {
				perm(cnt+1,sum*arr[cnt]);
			}else if(i==3) {
				perm(cnt+1,sum/arr[cnt]);
			}
			cal[i]++;
		}
	}

}
