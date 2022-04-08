package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11403_경로찾기 {

	static int N;
	static int[][] adjMatrix;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N= Integer.parseInt(br.readLine());
		adjMatrix = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
				if(adjMatrix[i][j]==0) {
					adjMatrix[i][j]=1000;
				}
			}
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k]+adjMatrix[k][j]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(adjMatrix[i][j]==1000) {
					sb.append(0+" ");
				}else {
					sb.append(1+" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
	}

}
