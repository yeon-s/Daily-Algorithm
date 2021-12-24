package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_9205_맥주마시면서걸어가기2 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=t;tc++) {
			int n = Integer.parseInt(br.readLine());
			
			Point[] arr = new Point[n+2];
			int[][] adjMatrix = new int[n+2][n+2];
			
			for(int i=0;i<n+2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());	
				arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			for(int i=0;i<n+2;i++) {
				for(int j=0;j<n+2;j++) {
					if(i==j) {
						adjMatrix[i][j]=0;
						continue;
					}
					if(Math.abs(arr[i].x-arr[j].x)+Math.abs(arr[i].y-arr[j].y)<=1000) {
						adjMatrix[i][j]=1;
					}else {
						adjMatrix[i][j]=1000;
					}
				}
			}
			
			for(int k=0;k<n+2;k++) {
				for(int i=0;i<n+2;i++) {
					if(i==k) {
						continue;
					}
					for(int j=0;j<n+2;j++) {
						if(j==i || j==k) {
							continue;
						}
						adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k]+adjMatrix[k][j]);
					}
				}
			}
			
			if(adjMatrix[0][n+1]>=1000) {
				sb.append("sad"+"\n");
			}else {
				sb.append("happy"+"\n");
			}
				
		}
		System.out.println(sb);
	}
	
	
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}
