package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_6064_카잉달력 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			long a=0;
			long b=0;
			
			while(true) {
				
				long num1=x+(M*a);
				long num2 = y+(N*b);
				
				if(num2>num1) {
					a++;
				}else if(num2<num1) {
					b++;
				}else if(num1==num2) {
					sb.append(num1+"\n");
					break;
				}
				
				if(num1>M*N || num2>M*N) {
					sb.append(-1+"\n");
					break;
				}
			}
			
		}
		System.out.println(sb);

	}

}
