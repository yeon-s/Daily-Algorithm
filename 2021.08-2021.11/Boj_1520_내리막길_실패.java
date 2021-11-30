package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1520_내리막길_실패 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int M;
	static int N;
	static int[][] map;
	static int[][] D;
	int sum;
	static int desti;
	static int destj;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		D = new int[M][N];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				D[i][j] = Integer.MAX_VALUE;
			}
		}
		//입력 끝
//		D[0][0] =1;
//		dfs(0,0);
//		

	}

//	static void dfs(int nowi,int nowj) {
//		
//		
//		if(D[nowi][nowj] != Integer.MAX_VALUE) {
//			
//		}
//		
//		if(nowi==desti && nowj==destj) {
//			sum++;
//			return;
//		}
//		
//		for(int d=0;d<4;d++) {
//			int nexti = nowi+di[d];
//			int nextj = nowj+dj[d];
//			
//			if(nexti<0 || nextj<0 || nexti>=M || nextj >=N || map[nexti][nextj] >=map[nowi][nowj]) {
//				continue;
//			}
//			
//			dfs(nexti,nextj);
//		}
//	}
}
