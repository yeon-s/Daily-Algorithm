package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1012_유기농배추 {

	static int[] di = {-1,1,0,0};			//상하좌우
	static int[] dj = {0,0,-1,1};
	static int[][] map;
	static int M;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int width =Integer.parseInt(st.nextToken());
				int height = Integer.parseInt(st.nextToken());
				map[height][width] = 1;
			}
			//입력 끝
			int num=0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==1) {
						num++;
						dfs(i,j);
					}
				}
			}
			System.out.println(num);
		}
	}

	static void dfs(int nowi,int nowj) {
		map[nowi][nowj] = 0;
		
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti>=N || nextj>=M || nexti<0 || nextj<0 || map[nexti][nextj]==0) {
				continue;
			}
			
			dfs(nexti,nextj);
		}
		
	}
}
