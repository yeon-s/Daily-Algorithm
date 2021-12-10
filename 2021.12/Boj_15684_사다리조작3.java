package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15684_사다리조작3 {

	static int num;
	static int N;
	static int H;
	static boolean[][] map;
	static int[] di= {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static boolean[][] visited;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new boolean[H+2][N+2];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=true;
		}
		//입력 끝
		
		flag=false;
		num=0;
		
		for(int i=0;i<4;i++) {
			num=i;
			comb(0);
			if(flag) {
				break;
			}
		}
		if(flag) {
			System.out.println(num);
		}else {
			System.out.println(-1);
		}
	}
	
	static void comb(int cnt) {
		if(flag) {
			return;
		}
		if(cnt==num) {
			simul();
			return;
		}
		
		for(int i=1;i<=H;i++) {
			for(int j=1;j<N;j++) {
				if(map[i][j] ) {
					continue;
				}
				if(map[i][j-1] || map[i][j+1]) {
					continue;
				}
				map[i][j] = true;
				comb(cnt+1);
				map[i][j]=false;					
			}
		}
	}

	 static boolean simul() {
		 for(int j=1;j<=N;j++) {
			 int tmp=j;
			 for(int i=1;i<=H;i++) {
				 if(map[i][tmp-1]) {
					 tmp--;
				 }else if(map[i][tmp]) {
					 tmp++;
				 }
			 }
			 if(tmp!=j) {
				 return false;
			 }
		 }
		 flag=true;
		 return true;
	 }
}
