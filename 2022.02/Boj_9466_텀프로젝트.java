package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9466_텀프로젝트 {

	static boolean[] visited;
	static boolean[] selected;
	static int[] check;
	static int[] arr;
 	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(br.readLine());
			
			arr = new int[n+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1;i<=n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			visited = new boolean[n+1];
			selected = new boolean[n+1];
			check= new int[n+1];
			for(int i=1;i<=n;i++) {
				if(!visited[i]) {
					dfs(i);
				}
			}
			
			int sum=0;
			for(int i=1;i<=n;i++) {
				if(check[i]!=2) {
					sum++;
				}
			}
			sb.append(sum+"\n");
		}
		System.out.println(sb);
	}
 	
 	static void dfs(int current) {
 		if(check[current]==1) {
 			return;
 		}
 		if(selected[current]) {
 			return;
 		}
 		if(visited[current]) {
 			selected[current]=true;
 		}
 		
 		visited[current]=true;
 		
 		
 		dfs(arr[current]);
 		if(selected[current]) {
 			check[current]=2;
 		}else {
 			check[current]=1;
 		}
 		
 	}
 	
 	
}
