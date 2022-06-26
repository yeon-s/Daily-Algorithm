package repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_1967_트리의지름 {

	static int max;
	static boolean[] visited;
	static boolean[] leaf;
	static LinkedList<Node>[] adjList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		//Parent[] arr = new Parent[N+1];
		//ArrayList<Node>[] children = new ArrayList[N+1];
		adjList = new LinkedList[N+1];
		for(int i=0;i<=N;i++) {
			//children[i] = new ArrayList<>();
			adjList[i] = new LinkedList<>();
		}
		leaf = new boolean[N+1];	//false면 리프노드
		int temp=N-1;
		
		while(temp-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			//arr[child] = new Parent(parent,weight);
			leaf[parent]=true;
			//children[parent].add(new Node(child, weight));
			adjList[parent].add(new Node(child,weight));
			adjList[child].add(new Node(parent,weight));
		}
		
		max = 0;
		for(int i=2;i<=N;i++) {
			if(!leaf[i]) {
				visited = new boolean[N+1];
				dfs(i,0);
			}
		}
		
		System.out.println(max);
	}
	
	static void dfs(int current, int sum) {
		visited[current] = true;
		max = Math.max(max, sum);
//		if(sum!=0 && !leaf[current]) {
//			max = Math.max(max,sum);
//			return;
//		}
		
		for(Node next: adjList[current]) {
			if(!visited[next.num]) {
				dfs(next.num,sum+next.weight);
			}
		}
	}
	
	static class Parent{
		int num;
		int weight;
		public Parent(int num,int weight) {
			this.num=num;
			this.weight=weight;
		}
		
	}
	
	static class Node{
		int num;
		int weight;
		public Node(int num, int weight) {
			super();
			this.num = num;
			this.weight = weight;
		}
		
	}

}
