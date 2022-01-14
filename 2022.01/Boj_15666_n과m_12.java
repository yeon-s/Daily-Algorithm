package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15666_n과m_12 {

	static int N;
	static int M;
	static int[] arr;
	static int[] result;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//입력 끝
		
		Arrays.sort(arr);
		result = new int[M];
		sb= new StringBuilder();
		comb(0,0);
		System.out.println(sb);

	}
	
	static void comb(int cnt,int start) {
		if(cnt==M) {
			for(int i:result) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start;i<N;i++) {
			if(i>0 && arr[i-1]==arr[i]) {
				continue;
			}
			result[cnt] = arr[i];
			comb(cnt+1,i);
		}
	}

}
