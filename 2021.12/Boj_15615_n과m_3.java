package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15615_n과m_3 {

	static int n;
	static int m;
	static int[] result;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		result = new int[m];
		sb= new StringBuilder();
		comb(0,1);
		System.out.println(sb);
	}
	
	static void comb(int cnt,int start) {
		if(cnt==m) {
			for(int i:result) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start;i<=n;i++) {
			result[cnt] = i;
			comb(cnt+1,start);
		}
	}

}
