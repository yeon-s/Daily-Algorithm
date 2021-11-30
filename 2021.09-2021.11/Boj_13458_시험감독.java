package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13458_시험감독 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		//입력 끝
		
		long answer = 0;
		
		for(int i=0;i<N;i++) {
			int num = arr[i];
			if (num > B) {
				num -= B;
				answer++;
				if (num % C != 0) {
					answer += (num / C) + 1;
				} else {
					answer += num / C;
				}
			} else {
				answer++;
			}
			
		}
	
		System.out.println(answer);

	}

}
