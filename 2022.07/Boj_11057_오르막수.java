package repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11057_오르막수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] D = new int[N+1][10];
		for(int i=0;i<10;i++) {
			D[1][i]=1;
		}
		
		for(int i=2;i<=N;i++) {
			for(int j=0;j<10;j++) {
				for(int k=0;k<=j;k++) {
					D[i][j]+=D[i-1][k];
					D[i][j]%=10007;
				}
			}
		}
		
		
		int answer=0;
		for(int i=0;i<10;i++) {
			answer+=D[N][i];
		}
		System.out.println(answer%10007);
	}

}
