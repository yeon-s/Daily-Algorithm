package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1010_다리놓기2_dp {

	static int N;
	static int M;
	static int ans;
	static int[][] D;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		D = new int[31][31];
		
		for(int i=0;i<31;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0 || j==i) {
					D[i][j]=1;
				}else {
					D[i][j] = D[i-1][j-1]+D[i-1][j];
				}
			}
		}
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N =Integer.parseInt(st.nextToken());
			M =Integer.parseInt(st.nextToken());
			ans= D[M][N];
			
			sb.append(ans+"\n");
			
		}
		System.out.println(sb);
		
	}
	
}
