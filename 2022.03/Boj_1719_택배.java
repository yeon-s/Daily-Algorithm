package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1719_택배 {

	static int n;
	static LinkedList<Point>[] adjList;
	static String[][] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		adjList = new LinkedList[n+1];	
		for(int i=1;i<=n;i++) {
			adjList[i] = new LinkedList<>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new Point(to, weight));
			adjList[to].add(new Point(from, weight));
		}
		
		answer = new String[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j) {
					answer[i][j] = "-";
				}
			}
		}
		for(int i=1;i<=n;i++) {
			dijkstra(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(answer[i][j]+" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
	
	static void dijkstra(int start) {
		int[] d = new int[n+1];
		for(int i=1;i<=n;i++) {
			d[i]=Integer.MAX_VALUE;
		}
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n+1];
		d[start]=0;
		pq.offer(new Point(start, 0, 0));
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
					
			if(visited[cur.vertex]) {
				continue;
			}
			if(cur.vertex!=start) {
				answer[start-1][cur.vertex-1] = (cur.answer+"");
			}
			
			visited[cur.vertex]=true;
			
			for(Point p:adjList[cur.vertex]) {
				if(!visited[p.vertex] && d[p.vertex]>cur.weight+p.weight) {
					d[p.vertex] = cur.weight+p.weight;
					if(cur.answer==0) {
						pq.offer(new Point(p.vertex, d[p.vertex], p.vertex));
					}else {
						pq.offer(new Point(p.vertex, d[p.vertex], cur.answer));
					}
				}
			}
		}
		
	}
	
	static class Point implements Comparable<Point>{
		int vertex;
		int weight;
		int answer;
		public Point(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		public Point(int vertex, int weight, int answer) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.answer = answer;
		}
		public int compareTo(Point o) {
			return this.weight-o.weight;
		}
	}

}
