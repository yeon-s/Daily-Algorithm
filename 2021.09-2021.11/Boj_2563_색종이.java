package practice;

import java.util.Scanner;

public class Boj_2563_색종이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] map = new int[100][100];
		
		
		for(int i=0;i<N;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int j=x;j<x+10;j++) {
				for(int k=y;k<y+10;k++) {
					map[k][j]=1;
				}
			}
		}
		
		int count=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j]==1) {
					count++;
				}
			}
		}
		System.out.println(count);
		
		
	}
	
	
		
	

}
