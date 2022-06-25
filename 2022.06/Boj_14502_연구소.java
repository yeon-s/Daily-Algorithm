package repeat;

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
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int answer;
	static boolean[][] visited;
	static int wallCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 0;
		wallCnt = 0;
		
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) wallCnt++;
			}
		}
		
		comb(0,0);
		
		System.out.println(answer);
	}
	
	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==2) {
					queue.offer(new Point(i,j));
					visited[i][j]=true;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for(int d=0;d<4;d++) {
				int nexti = cur.i+di[d];
				int nextj = cur.j+dj[d];
				
				if(nexti<0 || nextj<0 || nexti>=N || nextj>=M || map[nexti][nextj]==1 || visited[nexti][nextj]) {
					continue;
				}
				queue.offer(new Point(nexti, nextj));
				visited[nexti][nextj]=true;
			}
		}
	}
	
	static int count() {
		int temp =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visited[i][j]) {
					temp++;
				}
			}
		}
		temp-=(wallCnt+3);
		return temp;
	}
	
	static void comb(int cnt,int start) {
		if(cnt==3) {
			bfs();
			answer = Math.max(answer, count());
			return;
		}
		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				if(map[i][j]==0) {
//					map[i][j]=1;
//					comb(cnt+1,(i*M)+j+1);
//					map[i][j]=0;
//				}
//			}
//		}
		
		for(int i=start;i<N*M;i++) {
			int r = i/M;
			int c = i%M;
			if(map[r][c]==0) {
				map[r][c]=1;
				comb(cnt+1,i+1);
				map[r][c]=0;
			}
		}
	}
	
	static class Point{
		int i;
		int j;
		public Point(int i,int j) {
			this.i=i;
			this.j=j;
		}
	}

}
