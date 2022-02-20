package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14938_서강그라운드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int[][] D = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				D[i][j] = 10000;
			}
		}
		
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			D[from-1][to-1] = weight;
			D[to-1][from-1] = weight;
		}
		
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				if(i==k) {
					continue;
				}
				for(int j=0;j<n;j++) {
					if(k==j || i==j) {
						continue;
					}
					D[i][j] = Math.min(D[i][k]+D[k][j], D[i][j]);
				}
			}
		}
		
		int sum=0;
		int max = 0;
		for(int i=0;i<n;i++) {
			sum = 0;
			for(int j=0;j<n;j++) {
				if(i==j) {
					sum+=arr[j];
					continue;
				}
				if(m>=D[i][j]) {
					sum+=arr[j];
				}
			}
			if(max<sum) {
				max= sum;
			}
		}
		System.out.println(max);
	}

}
