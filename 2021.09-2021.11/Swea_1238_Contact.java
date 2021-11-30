package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_1238_Contact {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T=10;
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int length = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			boolean[][] adjMatrix = new boolean[101][101];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<length/2;i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjMatrix[from][to] = true; 
			}
			//입력 끝
			
			List<Integer> list = new ArrayList<>();
			
			boolean[] visited = new boolean[101];
			Queue<Integer> queue = new LinkedList<>();
			
			visited[start] = true;
			queue.offer(start);
			
			while(!queue.isEmpty()) {
				int size = queue.size();
				list.clear();
				while(size-->0) {
					int current = queue.poll();
					list.add(current);
					
					for(int i=1;i<101;i++) {
						if(!visited[i] && adjMatrix[current][i]) {
							queue.offer(i);
							visited[i]=true;
						}
					}
				}
			}
			
			Collections.sort(list);
			System.out.println("#"+tc+" "+list.get(list.size()-1));
			
		}

	}

}
