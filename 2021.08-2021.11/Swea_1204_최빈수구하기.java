package practice;

import java.util.Scanner;

public class Swea_1204_최빈수구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc=1;tc<=TC;tc++) {
			int tcNum = sc.nextInt();
			int[] index = new int[101];
			int[] score = new int[1000];
			int count=1;
			int max = 0;
			for(int i=0;i<1000;i++) {
				score[i]=sc.nextInt();
			}
			for(int i=0;i<1000;i++) {
				index[score[i]] += count;
			}
			for(int i=0;i<=100;i++) {
				max = Math.max(max, index[i]);
			}
			System.out.print("#"+tc+" ");
			for(int i=100;i>=0;i--) {
				if(index[i]==max) {
					System.out.println(i);
				}
			}
		}

	}

}
