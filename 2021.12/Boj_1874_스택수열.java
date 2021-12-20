package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_1874_스택수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//입력 끝
		
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		int index=0;
		int num=1;
		
		while(true) {
			if(index==n) {
				break;
			}
			if(num>n+1) {
				break;
			}
			if(stack.isEmpty()) {
				stack.push(num);
				num++;
				sb.append("+").append("\n");
			}else {
				int number = stack.peek();
				if(arr[index]==number) {
					stack.pop();
					sb.append("-").append("\n");
					index++;
				}else {
					stack.push(num);
					num++;
					sb.append("+").append("\n");
				}				
			}
		}
		
		if(stack.isEmpty()) {
			System.out.println(sb);			
		}else {
			System.out.println("NO");
		}
	}

}
