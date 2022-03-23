package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_1005_ACMcraft2_메모이제이션 {

	static boolean[] visited;
	static LinkedList<Integer>[] adjList;
	static int[] arr;
	static int max;
	static int[] D;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			arr = new int[N+1];		//각 건물 건설에 걸리는 시간
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			adjList = new LinkedList[N+1];
			for(int i=1;i<=N;i++) {
				adjList[i] = new LinkedList<>();
			}
			 
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[to].add(from);		//반대로
			}
			
			int W = Integer.parseInt(br.readLine());	//도착점
			
			visited = new boolean[N+1];
			max=0;
			D = new int[N+1];
			Arrays.fill(D, -1);
			sb.append(dfs(W)+"\n");
		}

		System.out.println(sb);
	}
	
	static int dfs(int current) {
		
		if(D[current]!=-1) {
			return D[current];
		}
		int num = 0;
		
		for(int i:adjList[current]) {
			num = Math.max(num, dfs(i));
		}
		D[current]=num+arr[current];
		return D[current];
		
	}

}
