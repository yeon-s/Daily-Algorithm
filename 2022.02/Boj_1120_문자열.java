package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1120_문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		int n = b.length()-a.length();
		int answer=100;
		for(int i=0;i<=n;i++) {
			int sum=0;
			for(int j=0;j<a.length();j++) {
				if(a.charAt(j)!=b.charAt(i+j)) {
					sum++;
				}
			}
			answer = Math.min(answer, sum);
		}
		System.out.println(answer);
	}

}
