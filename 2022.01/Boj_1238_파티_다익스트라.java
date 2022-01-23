package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1238_파티_다익스트라 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		LinkedList<Town>[] adjList = new LinkedList[N+1];
		boolean[] visited = new boolean[N+1];
		int[][] d = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			adjList[i] = new LinkedList<>();
			for(int j=1;j<=N;j++) {
				d[i][j] = Integer.MAX_VALUE;				
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new Town(to, weight));
		}
		
		PriorityQueue<Town> pq = new PriorityQueue<>();
		
		for(int i=1;i<=N;i++) {
			visited = new boolean[N+1];
			pq.offer(new Town(i, 0));
			d[i][i] = 0;
			
			while(!pq.isEmpty()) {
				Town cur = pq.poll();
				
				if(visited[cur.vertex]) {
					continue;
				}
				
				visited[cur.vertex] = true;
				
				for(Town t:adjList[cur.vertex]) {
					if(!visited[t.vertex] && d[i][t.vertex] > cur.weight+t.weight) {
						d[i][t.vertex] = cur.weight+t.weight;
						pq.offer(new Town(t.vertex, d[i][t.vertex]));
					}
				}
			}
		}
		
		int max =0;
		for(int i=1;i<=N;i++) {
			if(max<d[i][X]+d[X][i]) {
				max = d[i][X]+d[X][i];
			}
		}
		System.out.println(max);
	}
	
	static class Town implements Comparable<Town>{
		int vertex;
		int weight;
		public Town(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public int compareTo(Town o) {
			return this.weight-o.weight;
		}
		
	}

}
