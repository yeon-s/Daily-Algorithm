package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Swea_3124_최소스패닝트리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
		
			int[] minEdge = new int[V+1];
			boolean[] visited = new boolean[V+1];
			LinkedList<Node>[] adjList = new LinkedList[V+1];
			for(int i=0;i<=V;i++) {
				adjList[i] = new LinkedList<>();
				minEdge[i] = Integer.MAX_VALUE;
			}
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				adjList[from].add(new Node(to, weight));
				adjList[to].add(new Node(from, weight));
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(1, 0));
			
			minEdge[1]=0;
			long result = 0;
			
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				int current = cur.vertex;
				int min = cur.weight;
				
				if(visited[current]) {
					continue;
				}
				
				visited[current] = true;
				result+=min;
				
				for(Node temp:adjList[current]) {
					if(!visited[temp.vertex] && minEdge[temp.vertex]>temp.weight) {
						minEdge[temp.vertex]=temp.weight;
						pq.offer(new Node(temp.vertex, temp.weight));
					}
				}
			}
			
			System.out.println("#"+tc+" "+result);
			
			
		}

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
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
		
	}

}
