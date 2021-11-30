package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_2493_탑2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Top[] arr = new Top[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = new Top(Integer.parseInt(st.nextToken()), i);
		}
		
		Stack<Top> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int[] result = new int[N+1];
		stack.push(arr[1]);
		result[1]=0;
		
		for(int i=2;i<=N;i++) {
			Top now = arr[i];
			
			int h = stack.peek().height;
			int num = stack.peek().index;
			
			if(h>now.height) {
				result[i] = num;
				stack.push(now);
			}else {
				while(true) {
					if(stack.isEmpty()) {
						result[i]=0;
						stack.push(now);
						break;
					}
					int height = stack.peek().height;
					if(height<now.height) {
						stack.pop();
					}else {
						result[i] = stack.peek().index;
						stack.push(now);
						break;
					}
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			sb.append(result[i]).append(" ");	
		}
		System.out.println(sb);
	}
	
	static class Top{
		int height;
		int index;
		public Top(int height, int index) {
			super();
			this.height = height;
			this.index = index;
		}
		
	}
}