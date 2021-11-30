package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2846_오르막길 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}

		int[] D = new int[N];
		
		int sum=0;
		int max = 0;
		for(int i=1;i<N;i++) {
			if(arr[i]>arr[i-1]) {
				D[i] = arr[i]-arr[i-1];
				sum +=D[i];
			}else {
				D[i]=0;
				sum =0;
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
		System.out.println(Arrays.toString(D));
	}

}
