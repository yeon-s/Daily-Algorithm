package practice;

import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Boj_17298_오큰수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = new int[N];
		Stack<Num> stack = new Stack<>();
		for(int i=0;i<N;i++) {
			int num = arr[i];
			
			if(stack.isEmpty() || stack.peek().number>=num) {
				stack.push(new Num(num, i));
			}else {
				while(true) {
					Num n = stack.pop();
					result[n.index]=num;
					if(stack.isEmpty() || stack.peek().number>=num) {
						stack.push(new Num(num, i));
						break;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i:result) {
			if(i==0) {
				sb.append(-1+" ");
				continue;
			}
			sb.append(i+" ");
		}
		System.out.println(sb);
		
		
		
	}
	
	static class Num{
		int number;
		int index;
		public Num(int number, int index) {
			super();
			this.number = number;
			this.index = index;
		}
		
	}

}
