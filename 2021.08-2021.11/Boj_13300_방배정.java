package practice;

import java.util.Scanner;

public class Boj_13300_방배정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int room = 0;
		int[][] students = new int[2][7];
		
		for(int i=0;i<N;i++) {
			students[sc.nextInt()][sc.nextInt()]++;
		}
		//입력 끝
		
		for(int i=0;i<2;i++) {
			for(int j=1;j<7;j++) {
				if(students[i][j]==0) {
					continue;
				}else if(students[i][j]%K==0) {
					room += students[i][j]/K;
				}else {
					room +=(students[i][j]/K)+1;
				}
			}
		}
		System.out.println(room);
	}

}
