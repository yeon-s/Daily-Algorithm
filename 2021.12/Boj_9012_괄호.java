package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_9012_괄호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			String str = br.readLine();
			char[] arr =str.toCharArray();
			
			Stack<Character> stack = new Stack<>();
			boolean flag = true;
			for(char c:arr) {
				if(c=='(') {
					stack.push(c);
				}else {
					if(stack.isEmpty()) {
						flag=false;
						break;
					}
					stack.pop();						
				}
			}
			
			if(!stack.isEmpty()) {
				flag=false;
			}
			if(!flag) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
		}
		
	}

}
