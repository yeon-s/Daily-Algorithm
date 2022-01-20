package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2615_오목 {

	static boolean flag;
	static int[][] map;
	static int cnt;
	static int[] di = {1,0,-1,-1};
	static int[] dj = {-1,-1,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[19][19];
		StringTokenizer st;
		for(int i=0;i<19;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<19;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		flag= false;
		cnt=0;
		int answeri=0;
		int answerj=0;
		int win =0;
		
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				int color = map[i][j];
				if(color==0) {
					continue;
				}
				
				for(int d=0;d<4;d++) {
					cnt=0;
					dfs(i,j,1,d,color);
					if(cnt==5) {
						int nexti=i+di[d];
						int nextj = j+dj[d];
						if(nexti <0 || nextj<0 || nexti>=19 || nextj>=19 || map[nexti][nextj] !=color) {
							flag=true;							
						}
					}
				}
		
				if(flag) {
					win=color;
					answeri=i;
					answerj=j;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
		if(flag) {
			System.out.println(win);
			System.out.println((answeri+1)+" "+(answerj+1));
		}else {
			System.out.println(0);
		}
		
	}
	
	static void dfs(int nowi,int nowj,int depth,int d,int color) {
		cnt++;
		if(cnt>=6) {
			return;
		}
		int nexti = nowi;
		int nextj = nowj;
		if(d==1) {
			nextj = nowj+1;
		}else if(d==2) {
			nexti = nowi+1;
			nextj = nowj+1;
		}else if(d==3) {
			nexti = nowi+1;
		}else{
			nexti = nowi-1;
			nextj = nowj+1;
		}
		
		if(nexti<0 || nexti >=19 || nextj>=19) {
			return;
		}
		if(map[nexti][nextj]==color) {
			dfs(nexti,nextj,depth+1,d,color);			
		}
	}

}
