package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1504_특정한최단경로 {

	static boolean[] visited;
	static LinkedList<Node>[] adjList;
	static int[] d1;
	static int[] d2;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		adjList = new LinkedList[N+1];
		d1 = new int[N+1];
		d2 = new int[N+1];
		visited = new boolean[N+1];	//써야하나 말아야하나?
		for(int i=1;i<=N;i++) {
			adjList[i] = new LinkedList<>();
			d1[i]=Integer.MAX_VALUE;
			d2[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new Node(to, weight));
			adjList[to].add(new Node(from, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int answer= 0;
		
		dijkstra(v1,d1);
		visited = new boolean[N+1];
		dijkstra(v2,d2);
		
		if((d1[1]==Integer.MAX_VALUE || d1[v2]==Integer.MAX_VALUE || d2[N]==Integer.MAX_VALUE) && 
				(d2[1]==Integer.MAX_VALUE || d2[v2]==Integer.MAX_VALUE || d1[N]==Integer.MAX_VALUE)) {
			System.out.println(-1);
			return;
		}
		
		answer= d1[1]+d1[v2]+d2[N];
		answer = Math.min(d2[1]+d2[v1]+d1[N], answer);
		
		System.out.println(answer);

	}
	
	static void dijkstra(int start,int[] d) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		d[start]=0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.vertex]) {
				continue;
			}
			
			visited[cur.vertex]=true;
			
			for(Node n:adjList[cur.vertex]) {
				if(!visited[n.vertex] &&d[n.vertex]>cur.weight+n.weight) {
					d[n.vertex] = cur.weight+n.weight;
					pq.offer(new Node(n.vertex, d[n.vertex]));
				}
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int vertex;
		int weight;		//인접리스트에서는 정점간 이동거리,pq에서는 현재 정점까지 온 거리
		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
		
	}

}
