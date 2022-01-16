package practice;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Boj_11441_합구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] D = new int[N+1];
		D[0]=0;
		for(int i=1;i<=N;i++) {
			D[i] = D[i-1]+arr[i];
		}
		
		int M = Integer.parseInt(br.readLine());
		int answer=0;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int before = Integer.parseInt(st.nextToken());
			int front = Integer.parseInt(st.nextToken());
			
			answer = D[front]-D[before-1];
			sb.append(answer+"\n");
		}
		
		System.out.println(sb);
	}

}
