package repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14500_테트로미노 {

	static boolean[][] visited;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N,M;
	static int[][] map;
	static int max;
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
		
		max=0;
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				dfs(i,j,1,map[i][j]);
				visited[i][j]=false;
				cal(i,j);		//뻐큐모양 확인
			}
		}
		System.out.println(max);

	}
	
	static void cal(int nowi,int nowj) {
		
		for(int i=0;i<4;i++) {
			int sum = map[nowi][nowj];
			for(int d=0;d<4;d++) {
				if(i==d) continue;
				int nexti = nowi+di[d];
				int nextj = nowj+dj[d];
				if(nexti<0 || nextj<0 || nexti>=N || nextj>=M) break;
				sum+=map[nexti][nextj];
			}
			max = Math.max(max, sum);			
		}
	}
	
	static void dfs(int nowi,int nowj,int cnt, int sum) {
		if(cnt==4) {
			max = Math.max(max, sum);
			return;
		}
		visited[nowi][nowj]=true;
		
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=N || nextj>=M || visited[nexti][nextj]) {
				continue;
			}
			
			dfs(nexti,nextj,cnt+1,sum+map[nexti][nextj]);
			visited[nexti][nextj]=false;
		}
	}

}
