package practice;

import java.util.Scanner;

public class Boj_2578_빙고 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] map = new int[5][5];
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		int[] arr = new int[26];
		for(int i=1;i<=25;i++) {
			arr[i] = sc.nextInt();
		}
		//입력 끝
		int num=0;
		
		while(++num<25) {
			int bingo=0;
			
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					if(map[i][j]==arr[num]) {
						map[i][j]=-1;
					}
				}
			}
			//가로확인
			for(int i=0;i<5;i++) {
				int sum=0;
				for(int j=0;j<5;j++) {
					sum=sum+map[i][j];
					if(sum==-5) {
						bingo++;
					}
				}
			}
			//세로 확인
			for(int j=0;j<5;j++) {
				int sum=0;
				for(int i=0;i<5;i++) {
					sum=sum+map[i][j];
					if(sum==-5) {
						bingo++;
					}
				}
			}
			//대각선확인
			int sum=0;
			for(int i=0;i<5;i++) {
				sum=sum+map[i][i];
			}
			if(sum==-5) {
				bingo++;
			}
			int sum2=0;
			for(int i=0;i<5;i++) {
				sum2 = sum2+map[i][4-i];
			}
			if(sum2==-5) {
				bingo++;
			}
			
			if(bingo>=3) {
				System.out.println(num);
				break;
			}
		}
	}

}
