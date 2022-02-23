package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1629_곱셈 {

	static int[] memo;
	static long A;
	static long C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());

		System.out.println(dfs(B));
	}
	
	static long dfs(long B) {
		if(B==1) {
			return A%C;
		}
		
		long temp = dfs(B/2)%C;
		
		if(B%2==1) {
			return (((temp*temp)%C)*(A%C))%C;
		}else {
			return (temp*temp)%C;
		}
		
	}

}
