package practice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Boj_2493_탑_실패 {

	static int index;
	static int height;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Stack<Top> stack = new Stack<>();
		int[] result = new int[N+1];	
		
		for(int i=1;i<=N;i++) {
			stack.push(new Top(sc.nextInt(), i));
		}
		
		boolean flag = false;
		index=N;
		height=stack.peek().h;
		while(!stack.isEmpty()) {
			Top now = stack.pop();
			int nh = now.h;
			int nIndex = now.num;
			
			if (!stack.isEmpty()) {
				Top before = stack.peek();
				if (flag && before.h > height) {
					flag = false;
					for (int i = nIndex; i <= index; i++) {
						result[i] = before.num;
					}
				}

				if (flag) {
					continue;
				}
				
				if (before.h < nh) {
					index = nIndex;
					height = nh;
					flag = true;
				}else {
					result[nIndex] = before.num;
				}
			}else {
				break;
			}
		}
		
		for(int i=1;i<=N;i++) {
			System.out.print(result[i]+" ");
		}
		

	}
	
	static class Top{
		int h;
		int num;
		public Top(int h, int num) {
			super();
			this.h = h;
			this.num = num;
		}
		
	}

}
