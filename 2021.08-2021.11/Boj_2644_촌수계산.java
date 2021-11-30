package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2644_촌수계산 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] adjMatrix = new int[n+1][n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		for(int i=0;i<m;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st2.nextToken());
			int to = Integer.parseInt(st2.nextToken());
			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;
		}
		//입력 끝
		
		boolean[] visited = new boolean[n+1];
		Queue<Integer> queue = new LinkedList<>();
		
		visited[start] = true;
		queue.offer(start);
		
		int chon = 0;
		boolean flag = false;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-->0) {
				int current = queue.poll();
			
				if(current==end) {
					flag=true;
					break;
				}
				for(int i=1;i<=n;i++) {
					if(!visited[i] && adjMatrix[current][i]==1) {
						queue.offer(i);
						visited[i]=true;
					}
				}
			}
			if(flag) {
				break;
			}
			chon++;
		}
		if(!flag) {
			System.out.println(-1);
		}else {
			System.out.println(chon);			
		}

	}

}
