package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2661_좋은수열 {

	static int N;
	static int[] result;
	static boolean flag;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		result= new int[N];
		flag= false;
		sb= new StringBuilder();
		
		dfs(0);
		System.out.println(sb);
		
		
	}
	
	static void dfs(int cnt) {
		if(flag) {
			return;
		}
		
		if(cnt>3) {
			for(int i=2;i<=cnt/2;i++) {
				boolean check=false;
				for(int j=cnt-i;j<cnt;j++) {
					if(result[j]!=result[j-i]) {
						check=true;
						break;
					}
				}
				if(!check) {
					return;
				}
			}
		}
		if(cnt==N) {
			for(int i:result) {
				sb.append(i);
			}
			flag=true;
			return;
		}
		
		for(int i=1;i<=3;i++) {
			if(cnt==0) {
				result[cnt]=i;
				dfs(cnt+1);
			}else {
				if(result[cnt-1]!=i) {
					result[cnt]=i;
					dfs(cnt+1);
				}
			}
		}
		
	}

}
