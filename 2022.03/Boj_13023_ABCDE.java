package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_13023_ABCDE {

	static boolean[] visited;
	static LinkedList<Integer>[] adjList;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		adjList = new LinkedList[N];
		for(int i=0;i<N;i++) {
			adjList[i]= new LinkedList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		flag=false;
		visited = new boolean[N];
		for(int i=0;i<N;i++) {
			dfs(i,1);
			if(flag) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}
	
	static void dfs(int current,int depth) {
		if(flag) {
			return;
		}
		if(depth>=5) {
			flag=true;
			return;
		}
		visited[current]=true;
		
		for(int num:adjList[current]) {
			if(!visited[num]) {
				dfs(num,depth+1);
			}
		}
		visited[current]=false;
		
	}

}
