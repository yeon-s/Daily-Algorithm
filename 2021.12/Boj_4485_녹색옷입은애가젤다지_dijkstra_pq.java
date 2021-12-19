package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_4485_녹색옷입은애가젤다지_dijkstra_pq {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N;
	static int[][] map;
	static int[][] D;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num=1;
		StringBuilder sb = new StringBuilder();
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) {
				break;
			}
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 끝
			D= new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					D[i][j] = Integer.MAX_VALUE;
				}
			}
			D[0][0] = map[0][0];
			
			bfs();
			sb.append("Problem "+num+": "+D[N-1][N-1]).append("\n");
			num++;
		}
		
		System.out.println(sb);

	}
	
	static void bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		
		pq.offer(new Point(0, 0,map[0][0]));
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			int nowi = cur.i;
			int nowj = cur.j;
			int w = cur.weight;
			
			if(nowi==N-1 && nowj==N-1) {
				return;
			}
			
			if(visited[nowi][nowj]) {
				continue;
			}
			
			visited[nowi][nowj] = true;
			
			for(int d=0;d<4;d++) {
				int nexti = nowi+di[d];
				int nextj = nowj+dj[d];
				
				if(nexti<0 || nextj<0 || nexti>=N || nextj>=N || visited[nexti][nextj] || D[nexti][nextj]<=w+map[nexti][nextj]) {
					continue;
				}
				D[nexti][nextj] = w+map[nexti][nextj];
				pq.offer(new Point(nexti, nextj, w+map[nexti][nextj]));
			}
			
		}
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
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
		
		
	}

}
