package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9095_123더하기 {

	static int n;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine());
	
			count=0;
			dfs(0);
			sb.append(count+"\n");
			
		}
		System.out.println(sb);

	}
	
	static void dfs(int sum) {
		if(sum>n) {
			return;
		}
		if(sum==n) {
			count++;
			return;
		}
		
		dfs(sum+1);
		dfs(sum+2);
		dfs(sum+3);
	}

}
