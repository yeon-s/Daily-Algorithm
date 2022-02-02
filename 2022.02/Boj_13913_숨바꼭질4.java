package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_13913_숨바꼭질4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		boolean[] visited= new boolean[100001];
		Queue<Integer> queue = new LinkedList<>();
		int[] D = new int[100001];
		
		queue.offer(N);
		visited[N]=true;
		
		int time=0;
		
		Loop : while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				int current = queue.poll();
				D[current]=time;
				if(current==K) {
					break Loop;
				}
				
				if(current-1>=0 && !visited[current-1]) {
					queue.offer(current-1);
					visited[current-1]=true;
				}
				if(current+1<=100000 && !visited[current+1]) {
					queue.offer(current+1);
					visited[current+1]=true;
				}
				if(current*2<=100000 && !visited[current*2]) {
					queue.offer(current*2);
					visited[current*2]=true;
				}
			}
			time++;
		}
		
		Stack<Integer> stack = new Stack<>();
		
		queue.clear();
		queue.offer(K);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			stack.push(current);
			
			if(current==N) {
				break;
			}
			
			if(current-1>=0 && visited[current-1] && D[current-1]+1==D[current]) {
				queue.offer(current-1);
			}else if(current+1<=100000 &&visited[current+1] && D[current+1]+1==D[current]) {
				queue.offer(current+1);
			}else if(current%2==0 && current/2>=0 && visited[current/2] && D[current/2]+1==D[current]) {
				queue.offer(current/2);
			}
		}
		
		StringBuilder sb= new StringBuilder();
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop()+" ");
		}
		System.out.println(time);
		System.out.println(sb);

	}

}
