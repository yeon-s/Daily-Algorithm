package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2606_바이러스 {

	static int[][] adjMatrix;
	static int V;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		adjMatrix = new int[V+1][V+1];
		
		for(int i=0;i<E;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;
		}
		//입력 끝
		
//		boolean[] visited = new boolean[V+1];
//		dfs(1,visited);
		result = 0;
		bfs();
		System.out.println(result);
	}

	static void dfs(int current, boolean[] visited) {
		visited[current] = true;
		result++;
		for(int i=0;i<=V;i++) {
			if(!visited[i] && adjMatrix[current][i] !=0) {
				dfs(i,visited);
			}
		}
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[V+1];
		
		queue.offer(1);
		visited[1] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(int i=0;i<=V;i++) {
				if(!visited[i] && adjMatrix[current][i] !=0) {
					queue.offer(i);
					visited[i] = true;
					result++;
				}
			}
		}
	}
}
