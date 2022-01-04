package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10974_모든순열 {

	static int N;
	static boolean[] isSelected;
	static int[] result;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		isSelected = new boolean[N];
		result = new int[N];
		sb= new StringBuilder();
		perm(0);
		System.out.println(sb);
	}
	
	static void perm(int cnt) {
		if(cnt==N) {
			for(int i:result) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(isSelected[i-1]) {
				continue;
			}
			
			isSelected[i-1]=true;
			result[cnt]=i;
			perm(cnt+1);
			isSelected[i-1]=false;
		}
	}

}
