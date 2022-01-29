package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1068_트리2 {

	static int num;
	static int answer;
	static int[] parent;
	static int[][] tree;
	static boolean[] visited;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		parent = new int[N];
		for(int i=0;i<N;i++) {
			parent[i] = Integer.parseInt(st.nextToken());
		}
		
		tree = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				tree[i][j]=-1;
			}
		}
		
		
		for(int i=0;i<N;i++) {
			if(parent[i]==-1) {
				continue;
			}
			tree[parent[i]][i]=1;
		}
		
		num= Integer.parseInt(br.readLine());
		
		answer=0;
		visited = new boolean[N];
		if(parent[num]!=-1) {
			tree[parent[num]][num]=-1;			
		}
		dfs(num);

		for(int i=0;i<N;i++) {
			if(visited[i]) {
				continue;
			}
			
			boolean flag =false;
			for(int j=0;j<N;j++) {
				if(tree[i][j]!=-1) {
					flag=true;
					break;
				}
			}
			if(!flag) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	static void dfs(int current) {
		visited[current] = true;
		
		for(int i=0;i<N;i++) {
			if(!visited[i] && tree[current][i]==1) {
				dfs(i);
			}
		}
		
	}

}
