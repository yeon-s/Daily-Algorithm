package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1799_비숍_시간초과해결 {

	static boolean[][] color;
	static int[] di = {-1,-1};
	static int[] dj = {-1,1};
	static int[][] map;
	static int N;
	static int[] answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		color = new boolean[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if( (i%2==0 && j%2==0) || (i%2==1 && j%2==1) ) {
					color[i][j]=true;
				}
			}
		}
		//입력 끝
		
		answer = new int[2];
		dfs(0,0,0,true);
		dfs(0,1,0,false);
		System.out.println(answer[0]+answer[1]);
	}
	
	static void dfs(int nowi,int nowj,int cnt,boolean isBlack) {
		
		//System.out.println(nowi+" "+nowj);
		for(int i=nowi;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==nowi && j<nowj) {
					continue;
				}
				if(map[i][j]==1 && isAvailable(i,j) && color[i][j]==isBlack) {
					map[i][j]=3;
					dfs(i,j,cnt+1,isBlack);
					//백트래킹
					map[i][j]=1;
				}
			}
		}
		
		if(isBlack) {
			answer[0] = Math.max(answer[0], cnt);
		}else {
			answer[1] = Math.max(answer[1], cnt);
		}
		
	}
	
	static boolean isAvailable(int nowi,int nowj) {
		for(int d=0;d<2;d++) {
			int ti = nowi;
			int tj = nowj;
			while(true) {
				int nexti = ti+di[d];
				int nextj = tj+dj[d];
				
				if(nexti<0 || nextj<0 || nexti>=N || nextj>=N) {
					break;
				}
				if(map[nexti][nextj]!=3) {
					ti=nexti;
					tj=nextj;
				}else {
					return false;
				}
			}
			
		}
		return true;
	}

}
