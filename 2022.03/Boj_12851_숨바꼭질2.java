package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_12851_숨바꼭질2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(N==K) {
			System.out.println(0);
			System.out.println(1);
			return;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		int[] visited = new int[100001];
		Arrays.fill(visited, Integer.MAX_VALUE);
		visited[N] = 0;
		queue.offer(N);
		
		int time = 0;
		int cnt=0;
		boolean flag=false;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				int cur = queue.poll();
				
				if(cur==K) {
					flag= true;
					cnt++;
				}
				int next = cur+1;
				if(next<=100000 && time<=visited[next]) {
					queue.offer(next);
					visited[next]=time;
				}
				next = cur-1;
				if(next>=0 && time<=visited[next]) {
					queue.offer(next);
					visited[next]=time;
				}
				next = cur*2;
				if(next<=100000 && time<=visited[next]) {
					queue.offer(next);
					visited[next]=time;
				}
			}
			if(flag) {
				break;
			}
			time++;
		}
		
		System.out.println(time);
		System.out.println(cnt);

	}

}
