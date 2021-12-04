package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14500_테트로미노 {

	static int[] di= {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int max;
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		max=0;	
		visited= new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
//				visited= new boolean[N][M];
				dfs(i,j,0,0);
				check(i,j);
				visited[i][j]=false;
			}
		}

		System.out.println(max);
	}
	
	static void dfs(int nowi,int nowj,int num,int sum) {
		visited[nowi][nowj] = true;
		num++;
		sum+=map[nowi][nowj];
		if(num==4) {
			max= Math.max(sum, max);
			return;
		}
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			if(nexti<0 || nextj<0 || nexti>=N || nextj>=M) {
				continue;
			}
			if(!visited[nexti][nextj]) {				
				dfs(nexti,nextj,num,sum);
				visited[nexti][nextj]=false;
			}
		}
	}
	
	static void check(int nowi,int nowj) {
		

		for(int i=0;i<4;i++) {
			int sum=map[nowi][nowj];
			boolean flag = true;
			for(int d=0;d<4;d++) {
				if(i==d) {
					continue;
				}
				int nexti = nowi+di[d];
				int nextj = nowj+dj[d];
				
				if(nexti<0|| nextj<0 || nexti>=N || nextj>=M) {
					flag =false;
					break;
				}
				sum += map[nexti][nextj];
			}
			if(flag) {
				max = Math.max(sum, max);				
			}
		}
	}

}
