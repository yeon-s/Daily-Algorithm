package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1260_DFS와BFS_인접행렬 {

	static boolean[] visited;
	static boolean[][] adjMatrix;
	static int N;
	static int V;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		adjMatrix = new boolean[N+1][N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = true;
			adjMatrix[to][from] = true;
		}
		//입력 끝
		
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		bfs();
	}
	
	static void dfs(int now) {
		visited[now] = true;
		System.out.print(now+" ");
		
		for(int i=1;i<=N;i++) {
			if(adjMatrix[now][i] && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs() {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		
		visited[V] = true;
		queue.offer(V);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current+" ");
			
			for(int i=1;i<=N;i++) {
				if(adjMatrix[current][i] && !visited[i]) {
					queue.offer(i);
					visited[i]=true;
				}
			}
		}
	}

}
