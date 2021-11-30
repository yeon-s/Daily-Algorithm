package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Swea_1238_Contact {

	static int max;
	static boolean[][] adjMatrix;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			int M = sc.nextInt();
			int start = sc.nextInt();
			adjMatrix = new boolean[101][101];
			
			for(int i=1;i<=M/2;i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				adjMatrix[from][to] = true;
			}
			//입력 끝
			bfs(start);
			System.out.println("#"+tc+" "+max);
		}

	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[101];
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			max=0;
			while(size-->0) {
				int current = queue.poll();
				max= Math.max(max, current);
				for(int i=1;i<101;i++) {
					if(!visited[i] && adjMatrix[current][i]) {
						queue.offer(i);
						visited[i] = true;
					}
				}
				
			}
		}
	}
}
