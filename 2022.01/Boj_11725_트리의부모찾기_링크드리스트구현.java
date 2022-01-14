package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11725_트리의부모찾기_링크드리스트구현 {

	static boolean[] visited;
	static int N;
	static Node[] adjList;
	static int[] trie;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		adjList = new Node[N+1];
		
		trie = new int[N+1];
		visited = new boolean[N+1];
		
		StringTokenizer st;
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			
			adjList[one] = new Node(two, adjList[one]);
			adjList[two] = new Node(one, adjList[two]);
		}
	
		dfs(1);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=2;i<=N;i++) {
			sb.append(trie[i]+"\n");
		}
		System.out.println(sb);
		

	}
	
	static void dfs(int current) {
		visited[current] = true;
		
		for(Node temp=adjList[current]; temp!=null;temp=temp.link) {
			if(!visited[temp.vertex]) {
				trie[temp.vertex] = current;
				dfs(temp.vertex);
			}
		}
	}
	
	static class Node{
		int vertex;
		Node link;
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		
	}

}
