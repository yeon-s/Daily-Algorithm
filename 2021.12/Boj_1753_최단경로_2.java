package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1753_최단경로_2 {

	static class Node{
		int vertex;
		Node link;
		int weight;
		public Node(int vertex, Node link, int weight) {
			super();
			this.vertex = vertex;
			this.link = link;
			this.weight = weight;
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

		distance[K] = 0;
		
		for(int i=0;i<V;i++) {
			int min = Integer.MAX_VALUE;
			int current = -1;
			for(int j=1;j<=V;j++) {
				if(!visited[j] && min>distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			if(current==-1) {
				break;
			}
			
			visited[current] = true;
			
			for(Node temp=adjList[current]; temp!=null; temp=temp.link) {
				if(!visited[temp.vertex] && distance[temp.vertex] > min+temp.weight) {
					distance[temp.vertex] = min+temp.weight;
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
