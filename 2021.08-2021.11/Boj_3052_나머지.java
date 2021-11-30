package practice;

import java.util.Scanner;

public class Boj_3052_나머지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[42];
		
		for(int i=0;i<10;i++) {
			int num = sc.nextInt() % 42;
			
			if(arr[num] ==0) {
				arr[num] =1;				
			}
		}
		int sum =0;
		for(int i=0;i<arr.length;i++) {
			sum +=arr[i];
		}
		System.out.println(sum);

	}

}
