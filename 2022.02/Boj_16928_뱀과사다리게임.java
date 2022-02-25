package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16928_뱀과사다리게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[101];
		for(int i=0;i<N+M;i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		boolean[] visited = new boolean[101];
		visited[1]=true;
		
		int time=0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				int current = queue.poll();
				
				if(current==100) {
					System.out.println(time);
					return;
				}
				for(int i=1;i<=6;i++) {
					int next = current+i;
					
					if(next>100 || visited[next]) {
						continue;
					}
					
					if(arr[next]==0) {
						queue.offer(next);
						visited[next]=true;
					}else {
						queue.offer(arr[next]);
						visited[arr[next]]=true;
					}
				}
			}
			time++;
		}
		
	}

}
