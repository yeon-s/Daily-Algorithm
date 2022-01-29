package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2665_미로만들기 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		int[][] distance = new int[n][n];
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j]= (str.charAt(j)-'0');
				distance[i][j] = Integer.MAX_VALUE;
			}
		}
		//입력 끝
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(0, 0, 0));
		boolean[][] visited = new boolean[n][n];
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			
			if(visited[cur.i][cur.j]) {
				continue;
			}
			
			if(cur.i==n-1 && cur.j==n-1) {
				break;
			}
			
			visited[cur.i][cur.j]=true;
			
			for(int d=0;d<4;d++) {
				int nexti = cur.i+di[d];
				int nextj = cur.j+dj[d];
				
				if(nexti<0 || nextj<0 || nexti>=n || nextj>=n || visited[nexti][nextj]) {
					continue;
				}
				
				if(map[nexti][nextj]==0 && distance[nexti][nextj]>cur.weight+1) {
					distance[nexti][nextj]=cur.weight+1;
					pq.offer(new Point(nexti, nextj, distance[nexti][nextj]));
				}else if(map[nexti][nextj]==1 && distance[nexti][nextj]>cur.weight) {
					distance[nexti][nextj]=cur.weight;
					pq.offer(new Point(nexti, nextj, cur.weight));
				}
			}
		}
		
		System.out.println(distance[n-1][n-1]);
		
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
