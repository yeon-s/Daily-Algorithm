package practice;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Boj_17070_파이프옮기기1 {

	static int[] di = {0,1,1};
	static int[] dj = {1,1,0};
	static int N;
	static int answer;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		answer =0;
		dfs(0,1,0);
		System.out.println(answer);
		
	}
	
	static void dfs(int nowi,int nowj,int direction) {
		if(nowi==N-1 && nowj==N-1) {
			answer++;
			return;
		}
		
		
		for(int d=0;d<3;d++) {
			if(direction==0 && d==2) {
				continue;
			}
			if(direction==2 && d==0) {
				continue;
			}
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti <0 || nextj<0 || nexti>=N || nextj>=N) {
				continue;
			}
			if(d==1) {
				if(map[nexti][nextj]==1 || map[nexti-1][nextj]==1 || map[nexti][nextj-1]==1) {
					continue;
				}
			}else {
				if(map[nexti][nextj]==1) {
					continue;
				}
			}
			dfs(nexti,nextj,d);
		}
	}

}
