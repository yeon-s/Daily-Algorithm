package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringBuilder sb= new StringBuilder();
		Stack<String> stack = new Stack<>();
		
		boolean flag = false;
		int length = str.length();
		
		for(int i=0;i<length;i++) {
			String tmp = str.substring(i, i+1);
			if(flag) {
				sb.append(tmp+"");
				if(tmp.equals(">")) {
					flag=false;
				}
			}else {
				if(!tmp.equals("<") && !tmp.equals(" ")) {
					stack.push(tmp);
				}else {
					if(tmp.equals(" ")) {
						while(!stack.isEmpty()) {
							sb.append(stack.pop());
						}	
						sb.append(" ");
					}else if(tmp.equals("<")) {
						flag = true;
						while(!stack.isEmpty()) {
							sb.append(stack.pop());
						}
						sb.append("<");
					}
				}				
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);

	}

}
