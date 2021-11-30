package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1260_BFS_DFS_인접행렬 {

	static int N;
	static boolean[][] adjMatrix;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		adjMatrix = new boolean[N+1][N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = true;
			adjMatrix[to][from] = true;
		}
		//입력 끝
		
		boolean[] visited = new boolean[N+1];
		dfs(visited,V);
		System.out.println();
		bfs(V);
		

	}

	static void bfs(int V) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(V);
		
		boolean[] visited = new boolean[N+1];
		visited[V] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current+" ");
			
			for(int i=1;i<=N;i++) {
				if(!visited[i] && adjMatrix[current][i]==true) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	
	static void dfs(boolean[] visited,int current) {
		visited[current] = true;
		System.out.print(current+" ");
		
		for(int i=1;i<=N;i++) {
			if(!visited[i] && adjMatrix[current][i]==true) {
				dfs(visited,i);
			}
		}
	}
}
