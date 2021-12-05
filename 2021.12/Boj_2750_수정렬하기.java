package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2750_수정렬하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		int num=10000;
		for(int i=0;i<N;i++) {
			int current = arr[i];
			if(current==num) {
				continue;
			}else {
				sb.append(current).append("\n");
				num=current;
			}
		}
		System.out.println(sb);

	}

}
