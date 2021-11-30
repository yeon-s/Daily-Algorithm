package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_10157_자리배정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();	//가로
		int R = sc.nextInt();	//세로
		int K = sc.nextInt();
		
		int[][] map = new int[R][C];
		int num=1;
		int[] di = {-1,0,1,0};
		int[] dj = {0,1,0,-1};
		int nowi=R-1;
		int nowj = 0;
		int d=0;
		while(true) {
			
			
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti>=R || nexti<0 || nextj>=C || nextj<0 || map[nexti][nextj]!=0) {
				d++;
				if(d==4) {
					d=0;
				}
				continue;
			}
			map[nowi][nowj]=num++;
			if(num==R*C) {
				map[nexti][nextj]=num;
				break;
			}
			nowi = nexti;
			nowj = nextj;
		}
		if(K>R*C) {
			System.out.print(0);
			return;
		}
		
		int x=0;
		int y=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++){
				if(map[i][j]==K) {
					x=i;
					y=j;
					break;
				}
			}
		}
		System.out.print((y+1)+" "+(R-x));
	}

}
