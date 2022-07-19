package repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_14621_나만안되는연애 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		LinkedList<Node>[] adjList = new LinkedList[N+1];
		for(int i=1;i<=N;i++) {
			adjList[i] = new LinkedList<>();
		}
		
		char[] sex = new char[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			sex[i] = st.nextToken().charAt(0);
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if(sex[from]==sex[to]) continue;
			adjList[from].add(new Node(to, weight));
			adjList[to].add(new Node(from, weight));
		}
		
		int count = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		int temp =0;
		pq.offer(new Node(1,0));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			char currentSex = sex[n.vertex];
			if(visited[n.vertex]) continue;
			
			visited[n.vertex]=true;
			temp+=n.weight;
			
			for(Node next:adjList[n.vertex]) {
				if(!visited[next.vertex] && sex[next.vertex]!=currentSex) {
					pq.offer(new Node(next.vertex, next.weight));
				}
			}
			if(++count==N) break;
		}

		for(int i=1;i<=N;i++) {
			if(!visited[i]) temp=-1; 
		}
		
		System.out.println(temp);
	}

	static class Node implements Comparable<Node>{
		int vertex;
		int weight;
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
