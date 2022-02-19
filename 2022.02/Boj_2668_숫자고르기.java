package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj_2668_숫자고르기 {

	static int[] selected;
	static boolean[] visited;
	static int[] arr;
	static boolean flag;
	static int start;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		//입력 끝
		
		visited = new boolean[N+1];
		selected = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			flag=false;
			start=i;
			dfs(i);
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<=N;i++) {
			if(selected[i]==1) {
				list.add(i);
			}
		}
		
		System.out.println(list.size());
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(int i:list) {
			sb.append(i+"\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int current) {
		if(selected[current]==1 || selected[current]==2) {
			return;
		}
		
		if(visited[current]) {
			flag=true;
			selected[current]=1;
			return;
		}
		
		visited[current]=true;
		
		dfs(arr[current]);
		
		if(selected[current]==1) {
			flag=false;
			return;
		}
		
		if(flag) {
			selected[current]=1;
		}else {
			selected[current]=2;
		}
	}

}
