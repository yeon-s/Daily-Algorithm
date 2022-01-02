package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1916_최소비용구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		LinkedList<City>[] adjList = new LinkedList[N+1];
		int[] d = new int[N+1];
		for(int i=0;i<=N;i++) {
			adjList[i] = new LinkedList<>();
			d[i] = Integer.MAX_VALUE;
		}
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new City(to, weight));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<City> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		pq.offer(new City(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			City current = pq.poll();
			
			if(current.vertex==end) {
				break;
			}
			
			if(visited[current.vertex]) {
				continue;
			}
			
			visited[current.vertex]=true;
			
			for(City c:adjList[current.vertex]) {
				if(!visited[c.vertex] && d[c.vertex]>current.weight+c.weight) {
					d[c.vertex] = d[current.vertex]+c.weight;
					pq.offer(new City(c.vertex, d[c.vertex]));
				}
			}
			
			
		}
		System.out.println(d[end]);

	}
	
	static class City implements Comparable<City>{
		int vertex;
		int weight;
		public City(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public int compareTo(City o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
		
	}

}
