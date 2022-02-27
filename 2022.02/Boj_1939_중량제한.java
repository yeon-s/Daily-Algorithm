package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_1939_중량제한 {

	static boolean[] visited;
	static int end;
	static LinkedList<Node>[] adjList;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		adjList = new LinkedList[N+1];
		for(int i=1;i<=N;i++) {
			adjList[i]=new LinkedList<>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new Node(to, weight));
			adjList[to].add(new Node(from, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		//입력 끝
		
		int left=1;
		int right=1000000000;
		
		int answer=0;
		while(left<=right) {
			int mid = (left+right)/2;
			
			flag = false;
			visited = new boolean[N+1];
			dfs(start,mid);
			
			if(flag) {
				left = mid+1;
				answer=mid;
			}else {
				right=mid-1;
			}
			
		}
		System.out.println(answer);

	}
	
	static void dfs(int current,int weight) {
		if(flag) {
			return;
		}
		visited[current]=true;
		
		if(current==end) {
			flag=true;
			return;
		}
		
		for(Node n:adjList[current]) {
			if(!visited[n.vertex] && n.weight>=weight) {
				dfs(n.vertex,weight);
				//visited[n.vertex]=false;
			}
		}
	}
	
	static class Node{
		int vertex;
		int weight;
		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		
	}

}
