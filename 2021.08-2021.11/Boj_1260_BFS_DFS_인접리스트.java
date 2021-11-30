package practice;

import java.awt.event.AdjustmentListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1260_BFS_DFS_인접리스트 {

	static class Node{
		int data;
		Node link;
		public Node(int data, Node link) {
			super();
			this.data = data;
			this.link = link;
		}
		
	}
	
	static int N;
	static Node[] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		adjList = new Node[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from,adjList[to]);
		}
		
		//입력 끝
		boolean[] visited = new boolean[N+1];
		dfs(V,visited);
		System.out.println();
		bfs(V);
	}

	static void bfs(int V) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(V);
		visited[V] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current+" ");
			
			for(Node temp = adjList[current]; temp != null;temp = temp.link ) {
				if(!visited[temp.data]) {
					queue.offer(temp.data);
					visited[temp.data] = true;
				}
			}
		}
	}
	
	static void dfs(int current,boolean[] visited) {
		visited[current] = true;
		System.out.print(current+" ");
		
		for(Node temp = adjList[current];temp!=null;temp= temp.link) {
			if(!visited[temp.data]) {
				dfs(temp.data,visited);
				
			}
		}
	}
}
