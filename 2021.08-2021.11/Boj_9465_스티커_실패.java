package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9465_스티커_실패 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] map = new int[2][n];
			for(int i=0;i<2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 끝
			long sum1=0;
			long sum2=0;
			
			for(int i=0;i<n-2;i++) {
				if(i%2==0) {
					sum1 += map[0][i];
					sum2 += map[1][i];
				}else {
					sum1 += map[1][i];
					sum2 += map[0][i];
				}
			}
			long sum = Math.max(sum1, sum2);
			
			int max=0;
			for(int i=0;i<2;i++) {
				for(int j=n-2;j<n;j++) {
					max = Math.max(max, map[i][j]);
				}
			}
			sum +=max;
			System.out.println(sum);
			
		}
	}

}
