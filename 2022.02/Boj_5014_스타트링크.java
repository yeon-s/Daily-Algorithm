package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_5014_스타트링크 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[F+1];
		
		queue.offer(S);
		visited[S] =true;
		
		int time=0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				int current = queue.poll();
				
				if(current==G) {
					System.out.println(time);
					return;
				}
				
				int up = current+U;
				int down = current-D;
				
				if(up<=F && !visited[up]) {
					queue.offer(up);
					visited[up]=true;
				}
				if(down>=1 && !visited[down]) {
					queue.offer(down);
					visited[down]=true;
				}
			}
			time++;
		}
		
		System.out.println("use the stairs");
		
	}

}
