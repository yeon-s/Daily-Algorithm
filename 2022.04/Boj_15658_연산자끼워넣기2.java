package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15658_연산자끼워넣기2 {

	static int N;
	static int[] arr;
	static int[] cal;
	static int[] result;
	static int max;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		cal = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			cal[i]=Integer.parseInt(st.nextToken());
		}
		
		result = new int[N-1];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		perm(0);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	static void perm(int cnt) {
		if(cnt==N-1) {
			int temp = arr[0];
			for(int i=0;i<N-1;i++) {
				if(result[i]==0) {
					temp = temp+arr[i+1];
				}else if(result[i]==1) {
					temp = temp-arr[i+1];
				}else if(result[i]==2) {
					temp = temp*arr[i+1];
				}else if(result[i]==3) {
					temp = temp/arr[i+1];
				}
			}
			
			max = Math.max(max, temp);
			min = Math.min(min, temp);
			
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(cal[i]==0) {
				continue;
			}
			
			result[cnt] = i;
			cal[i]--;
			perm(cnt+1);
			cal[i]++;
			
		}
	}

}
