package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_10282_해킹 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			Node[] adjList = new Node[n+1];
			int[] distance = new int[n+1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			boolean[] visited = new boolean[n+1];
			
			for(int i=0;i<d;i++) {
				st = new StringTokenizer(br.readLine());
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				adjList[from] = new Node(to, adjList[from], s);
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(c, 0));
			distance[c]=0;
			
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				
				if(visited[cur.vertex]) {
					continue;
				}
				
				visited[cur.vertex]=true;
				
				for(Node temp=adjList[cur.vertex];temp!=null;temp=temp.link) {
					if(!visited[temp.vertex] && distance[temp.vertex]>cur.weight+temp.weight) {
						distance[temp.vertex] = cur.weight+temp.weight;
						pq.offer(new Node(temp.vertex, distance[temp.vertex]));
					}
				}
			}
			
			int cnt=0;
			int max=0;
			for(int i=1;i<=n;i++) {
				if(distance[i]!=Integer.MAX_VALUE) {
					cnt++;
					max= Math.max(max, distance[i]);
				}
			}
			sb.append(cnt+" "+max+"\n");
		}
		System.out.println(sb);

	}
	
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
