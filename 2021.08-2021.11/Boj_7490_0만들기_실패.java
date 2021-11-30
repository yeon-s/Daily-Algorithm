package practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Boj_7490_0만들기_실패 {

	
	static String[] result;
	
	
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();

		for(int tc=1;tc<=TC;tc++) {
			N = sc.nextInt();
			
			result = new String[N-1];
			
			//입력 끝
			
			perm(0);
		}

	}
	
	static void perm(int target) {
		if(target==N-1) {
			Queue<String> queue = new LinkedList<>();
			for(int i=1;i<N;i++) {
				queue.offer(i+"");
				queue.offer(result[i-1]);
			}
			queue.offer(N+"");
			while(!queue.isEmpty()) {
				int num = Integer.parseInt(queue.poll());
				String str = queue.poll();
				
			}
			
			return;
		}
			
		result[target] = "+";
		perm(target+1);
		result[target] = "-";
		perm(target+1);
		result[target] = " ";
		perm(target+1);
		
	}

}
