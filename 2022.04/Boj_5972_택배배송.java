package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_5972_택배배송 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] d= new int[N+1];
		LinkedList<Node>[] adjList = new LinkedList[N+1];
		for(int i=1;i<=N;i++) {
			d[i] = Integer.MAX_VALUE;
			adjList[i] = new LinkedList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new Node(to, weight));
			adjList[to].add(new Node(from, weight));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited= new boolean[N+1];
		pq.offer(new Node(1, 0));
		d[1]=0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.vertex]) {
				continue;
			}
			
			visited[cur.vertex]=true;
			
			for(Node n:adjList[cur.vertex]) {
				if(!visited[n.vertex] && d[n.vertex]>cur.weight+n.weight) {
					d[n.vertex]=cur.weight+n.weight;
					pq.offer(new Node(n.vertex, d[n.vertex]));
				}
			}
		}
		System.out.println(d[N]);
	}
	
	static class Node implements Comparable<Node>{
		int vertex;
		int weight;
		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
		
	}

}
