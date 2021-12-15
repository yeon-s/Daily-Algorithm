package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1753_최단경로_2_pq {

	static class Node implements Comparable<Node>{
		int vertex;
		Node link;
		int weight;
		public Node(int vertex, Node link, int weight) {
			super();
			this.vertex = vertex;
			this.link = link;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		Node[] adjList = new Node[V+1];
		int[] distance = new int[V+1];
		boolean[] visited = new boolean[V+1];
		
		for(int i=0;i<=V;i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from], w);
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(new Node(K, null, 0));
		distance[K] = 0;
		
		while(!pq.isEmpty()) {
			Node currentNode = pq.poll();
			int current = currentNode.vertex;
			int d = currentNode.weight;
			
			if(visited[current]) {
				continue;
			}
			
			visited[current] = true;
			
			for(Node temp=adjList[current]; temp!=null; temp= temp.link) {
				if(!visited[temp.vertex] && distance[temp.vertex]>d+temp.weight) {
					distance[temp.vertex] = d+temp.weight;
					pq.offer(new Node(temp.vertex, null, d+temp.weight));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=V;i++) {
			if(distance[i]==Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			}else {
				sb.append(distance[i]+"\n");
			}
		}
		System.out.println(sb);
	}

}
