package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_11399_ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		//입력 끝
		
		Arrays.sort(arr);
		int sum=0;
		int num=0;
		for(int i=0;i<N;i++) {
			num = num+arr[i];
			sum +=num;
		}
		System.out.println(sum);
	}
}
