package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_10828_스택 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String str = st.nextToken();
			if(str.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			}else if(str.equals("pop")) {
				if(stack.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(stack.pop()).append("\n");
				}
			}else if(str.equals("size")) {
				sb.append(stack.size()).append("\n");
			}else if(str.equals("empty")) {
				if(stack.isEmpty()) {
					sb.append(1).append("\n");	
				}else {
					sb.append(0).append("\n");
				}
			}else if(str.equals("top")) {
				if(stack.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(stack.peek()).append("\n");
				}
			}
		}
		System.out.println(sb);

	}

}
