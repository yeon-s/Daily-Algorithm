package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_11779_최소비용구하기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		LinkedList<Node>[] adjList = new LinkedList[n+1];
		int[] d = new int[n+1];
		for(int i=1;i<=n;i++) {
			adjList[i] = new LinkedList<>();
			d[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new Node(to, weight));
		}
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		//입력 끝
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n+1];
		
		pq.offer(new Node(start, 0,(start+""),1));
		d[start]=0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.vertex]) {
				continue;
			}

			visited[cur.vertex]=true;
			
			if(cur.vertex==end) {
				System.out.println(d[end]);
				System.out.println(cur.num);
				System.out.println(cur.path);
				return;
			}
			
			for(Node node:adjList[cur.vertex]) {
				if(!visited[node.vertex] && d[node.vertex]>cur.weight+node.weight) {
					d[node.vertex]=cur.weight+node.weight;
					pq.offer(new Node(node.vertex, d[node.vertex], cur.path+" "+(node.vertex+""),cur.num+1));
				}
			}
		}
		
		System.out.println(d[end]);
		
	}
	
	static class Node implements Comparable<Node>{
		int vertex;
		int weight;
		String path;
		int num;
		
		public Node(int vertex,int weight) {
			this.vertex=vertex;
			this.weight=weight;
		}
		
		public Node(int vertex, int weight,String path,int num) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.path=path;
			this.num=num;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
		
	}

}
