package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1992_쿼드트리 {

	static int[][] map;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
	
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(str.substring(j, j+1));
			}
		}
		//입력 끝
		
		sb= new StringBuilder();
		
		divide(N,0,0);
		System.out.println(sb);

	}
	
	static void divide(int N,int si,int sj) {
		int sum=0;
		for(int i=si;i<si+N;i++) {
			for(int j=sj;j<sj+N;j++) {
				sum +=map[i][j];
			}
		}
		
		
		if(sum==0 || sum==N*N) {
			if(sum==0) {
				sb.append(0);
			}else {
				sb.append(1);
			}
		}else {
			sb.append("(");
			divide(N/2,si,sj);
			divide(N/2,si,sj+N/2);
			divide(N/2,si+N/2,sj);
			divide(N/2,si+N/2,sj+N/2);
			sb.append(")");
		}
	}

}
