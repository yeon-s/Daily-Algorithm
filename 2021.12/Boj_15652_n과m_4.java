package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_15652_n과m_4 {

	static int N;
	static int M;
	static StringBuilder sb;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		result = new int[M];

		comb(0,1);
		System.out.println(sb);
	}
	
	static void comb(int cnt,int start) {
		if(cnt==M) {
			for(int num:result) {
				sb.append(num+" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i=start;i<=N;i++) {
			result[cnt] = i;
			comb(cnt+1,i);
		}
		
	}

}
