package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_10989_수정렬하기3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		//1.sort 사용
//		int[] arr = new int[N];
//		
//		for(int i=0;i<N;i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//		}
//		Arrays.sort(arr);
//		StringBuilder sb = new StringBuilder();
//		
//		for(int i=0;i<N;i++) {
//			sb.append(arr[i]+"\n");
//		}
//		System.out.println(sb);
		
		int[] arr = new int[10001];
		for(int i=0;i<N;i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<10001;i++) {
			while(arr[i]-->0) {
				sb.append(i+"\n");
			}
		}
		System.out.println(sb);
	}

}
