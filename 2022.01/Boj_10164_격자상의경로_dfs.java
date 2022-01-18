package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10164_격자상의경로_dfs {

	static boolean[][] visited;
	static int[] di = {1,0};
	static int[] dj = {0,1};
	static int N;
	static int M;
	static int n;
	static int m;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N][M];
		answer=0;
		int[][] map = new int[N][M];
		int num=1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]=num++;
				if(map[i][j]==K) {
					n=i;
					m=j;
				}
			}
		}
		if(K==0) {
			dfs(0,0,N-1,M-1);
		}else {
			dfs(0,0,n,m);
			int one = answer;
			answer=0;
			dfs(n,m,N-1,M-1);
			answer = answer*one;
		}
		System.out.println(answer);

	}
	
	static void dfs(int nowi,int nowj,int n,int m) {
		visited[nowi][nowj]=true;
		
		if(nowi==n && nowj==m) {
			answer++;
			return;
		}
		
		for(int d=0;d<2;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=N || nextj>=M || visited[nexti][nextj]) {
				continue;
			}
			
			dfs(nexti,nextj,n,m);
			visited[nexti][nextj]=false;
		}
	}

}
