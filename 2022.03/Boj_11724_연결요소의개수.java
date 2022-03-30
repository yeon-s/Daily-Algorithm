package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_11724_연결요소의개수 {

	static boolean[] visited;
	static LinkedList<Integer>[] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N =Integer.parseInt(st.nextToken());
		int M =Integer.parseInt(st.nextToken());
		
		adjList = new LinkedList[N+1];
		for(int i=1;i<=N;i++) {
			adjList[i] = new LinkedList<>();
		}
		for(int i=0;i<M;i++) {
			st= new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		visited = new boolean[N+1];
		int answer=0;
		
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				answer++;
				dfs(i);
			}
		}

		System.out.println(answer);
	}
	
	static void dfs(int current) {
		visited[current]=true;
		
		for(int next: adjList[current]) {
			if(!visited[next]) {
				dfs(next);
			}
		}
	}

}
