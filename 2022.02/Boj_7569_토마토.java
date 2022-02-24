package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7569_토마토 {

	static int H;
	static int M;
	static int N;
	static int[][][] map;
	static boolean[][][] visited;
	static int[] dk = {-1,1,0,0,0,0};
	static int[] di = {0,0,-1,1,0,0};
	static int[] dj = {0,0,0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N][M];
		visited = new boolean[H][N][M];
		Queue<Point> queue = new LinkedList<>();
		int cnt=0;
		
		for(int k=0;k<H;k++) {
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[k][i][j] = Integer.parseInt(st.nextToken());
					if(map[k][i][j]==1) {
						queue.offer(new Point(k, i, j));
						visited[k][i][j]=true;
					}
					if(map[k][i][j]!=-1) {
						cnt++;
					}
				}
			}
		}

		//입력 끝
		if(queue.size()==cnt) {
			System.out.println(0);
			return;
		}
		
		int time=0;
		int count=0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Point cur = queue.poll();
				count++;
				for(int d=0;d<6;d++) {
					int nextk =cur.k+dk[d];
					int nexti = cur.i+di[d];
					int nextj = cur.j+dj[d];
					
					if(nextk<0 || nexti<0 || nextj<0 || nextk>=H || nexti>=N || nextj>=M || visited[nextk][nexti][nextj]) {
						continue;
					}
					
					if(map[nextk][nexti][nextj]==0) {
						queue.offer(new Point(nextk, nexti, nextj));
						visited[nextk][nexti][nextj]=true;						
					}
				}
			}
			time++;
		}
		if(count==cnt) {
			System.out.println(time-1);			
		}else {
			System.out.println(-1);
		}
	}
	
	static class Point{
		int k;
		int i;
		int j;
		public Point(int k, int i, int j) {
			super();
			this.k = k;
			this.i = i;
			this.j = j;
		}
	}

}
