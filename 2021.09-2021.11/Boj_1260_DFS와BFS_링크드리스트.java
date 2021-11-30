package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1260_DFS와BFS_링크드리스트 {

	static LinkedList<Integer>[] adjList;
	static int N;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		adjList = new LinkedList[N+1];
		for(int i=1;i<=N;i++) {
			adjList[i] = new LinkedList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
		//입력 끝
		
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		bfs(V);
	}
	
	static void dfs(int current) {
		visited[current] = true;
		
		System.out.print(current+" ");
		
		for(int i=0;i<adjList[current].size();i++) {
			if(!visited[adjList[current].get(i)]) {
				dfs(adjList[current].get(i));
			}
		}
	}
	
	static void bfs(int start) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		
		visited[start] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current+" ");
			
			for(int i=0;i<adjList[current].size();i++) {
				if(!visited[adjList[current].get(i)]) {
					queue.offer(adjList[current].get(i));
					visited[adjList[current].get(i)]=true;
				}
			}
		}
	}

}
