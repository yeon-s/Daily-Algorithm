package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Swea_1954_달팽이숫자 {

	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			
			int[][] map = new int[N][N];
			
			int count = N*N;
			int nowi=0;
			int nowj=0;
			int num=1;
			int d=0;
			
			while(count-->0) {
				map[nowi][nowj]= num;
				
				int nexti = nowi+di[d];
				int nextj = nowj+dj[d];
				
				if(nexti <0 || nextj <0 || nexti>N-1 || nextj>N-1 || map[nexti][nextj]!=0) {
					nexti = nowi;
					nextj = nowj;
					d++;
					if(d>3) {
						d=0;
					}
					nexti +=di[d];
					nextj +=dj[d];
				}
				
				nowi = nexti;
				nowj = nextj;
				num++;
			}
			
			System.out.println("#"+tc);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}

	}

}
