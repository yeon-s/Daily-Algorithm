package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14502_연구소 {

	static int N;
	static int M;
	static int[][] map;
	static int zero;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int safetyArea;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		zero = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					zero++;
				}
			}
		}
		//입력 끝
		max=0;
		comb(0,0);
		System.out.println(max);
		
	}
	
	static void comb(int cnt,int target) {
		if(cnt==3) {
			safetyArea=0;
			simul();
			findSafetyArea();
			max = Math.max(max, safetyArea);
			setOriginal();
			return;
		}

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					comb(cnt+1,target+1);
					map[i][j]=0;
				}
			}
		}
	}

	 private static void setOriginal() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 3) {
					map[i][j] = 0;
				}
			}
		}
	}

	static void findSafetyArea() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					safetyArea++;
				}
			}
		}
	}

	static void simul() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==2) {
//					dfs(i,j);
					bfs(i,j);
				}
			}
		}
	}

	static void dfs(int nowi, int nowj) {
		map[nowi][nowj]=3;	//시작점은 바꾸면 안됨 (이따 수정)
		
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=N || nextj>=M) {
				continue;
			}
			if(map[nexti][nextj]==0) {
				dfs(nexti,nextj);
			}
		}
		
	}
	
	static void bfs(int si,int sj) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(si, sj));
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			int nowi = cur.i;
			int nowj = cur.j;
			
			for(int d=0;d<4;d++) {
				int nexti = nowi+di[d];
				int nextj = nowj+dj[d];
				
				if(nexti<0 || nextj<0 || nexti>=N || nextj>=M || map[nexti][nextj]!=0) {
					continue;
				}
				if(map[nexti][nextj]==0) {
					queue.offer(new Point(nexti, nextj));
					map[nexti][nextj]=3;
				}
			}
		}
		
	}

	
	static class Point{
		int i;
		int j;
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}
}
