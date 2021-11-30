package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1753_최단경로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		Node[] adjList = new Node[V+1];
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		//입력 끝
		boolean[] visited = new boolean[V+1];
		int[] distance = new int[V+1];
		final int MAX = Integer.MAX_VALUE;
		Arrays.fill(distance, MAX);
		distance[K]=0;
		
		for(int i=0;i<V;i++) {
			int current = -1;
			int min = Integer.MAX_VALUE;
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
			
			for(Node temp = adjList[current]; temp !=null;temp = temp.link) {
				if(!visited[temp.vertex] && distance[temp.vertex] > min+temp.weight) {
					distance[temp.vertex] = min+temp.weight;
				}
			}
		}
		for(int i=1;i<=V;i++) {
			if(distance[i] !=MAX) {
				System.out.println(distance[i]);				
			}else {
				System.out.println("INF");
			}
		}

	}

	static class Node{
		int vertex;
		int weight;
		Node link;
		public Node(int vertex, int weight, Node link) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}
		
	}
}
