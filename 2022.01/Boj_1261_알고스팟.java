package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1261_알고스팟 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] =str.charAt(j)-'0';
			}
		}
		//입력 끝
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][M];
		int[][] D = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				D[i][j] = Integer.MAX_VALUE;
			}
		}
		D[0][0]=0;
		pq.offer(new Point(0, 0, D[0][0]));
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			
			if(cur.i==N-1 && cur.j==M-1) {
				break;
			}
			if(visited[cur.i][cur.j]) {
				continue;
			}
			
			visited[cur.i][cur.j]=true;
			
			for(int d=0;d<4;d++) {
				int nexti = cur.i+di[d];
				int nextj = cur.j+dj[d];
				
				if(nexti<0 || nextj<0 || nexti>=N || nextj>=M || visited[nexti][nextj]) {
					continue;
				}
				
				if(D[nexti][nextj]>cur.weight+map[nexti][nextj]) {
					D[nexti][nextj] = cur.weight+map[nexti][nextj];
					pq.offer(new Point(nexti, nextj, D[nexti][nextj]));
				}
			}
		}
		System.out.println(D[N-1][M-1]);
	}
	
	static class Point implements Comparable<Point>{
		int i;
		int j;
		int weight;
		public Point(int i, int j, int weight) {
			super();
			this.i = i;
			this.j = j;
			this.weight = weight;
		}
		@Override
		public int compareTo(Point o) {
			return this.weight-o.weight;
		}
		
	}

}
