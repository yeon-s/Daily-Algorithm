package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Boj_2407_조합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		BigInteger[][] D = new BigInteger[n+1][m+1];
		for(int i=0;i<=n;i++) {
			int num = Math.min(i, m);
			for(int j=0;j<=num;j++) {
				if(i==j || j==0) {
					D[i][j]=new BigInteger ("1");
				}else {
					D[i][j] = D[i-1][j-1].add(D[i-1][j]);
				}
			}
		}
		System.out.println(D[n][m]);
	}

}
