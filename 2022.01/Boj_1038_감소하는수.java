package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_1038_감소하는수 {

	static int N;
	static int count;
	static int R;
	static int[] result;
	static String answer;
	static boolean flag;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		count =9;
		result = new int[10];
		answer="0";
		flag=false;
		sb = new StringBuilder();
		if(N<10) {
			System.out.println(N);
		}else {
			for(int i=2;i<=10;i++) {
				R=i;
				Arrays.fill(result, 0);
				perm(0);
			}
			
			if(answer.equals("0")) {
				System.out.println(-1);
			}else {
				System.out.println(answer);							
			}
		}
		
	}
	
	static void perm(int cnt) {
		if(flag) {
			return;
		}
		if(cnt==R) {
			count++;

			if(count==N) {
				for(int i=0;i<cnt;i++) {
					sb.append(result[i]);
				}
				answer = (sb+"");
				flag=true;
			}
			return;
		}
		
		for(int i=0;i<=9;i++) {
			if(cnt==0 && i==0) {
				continue;
			}
			if(cnt>=1 && result[cnt-1]<=i) {
				continue;
			}
			result[cnt] = i;
			perm(cnt+1);				
		}
	}

}
