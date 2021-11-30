package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Swea_4727_견우와직녀2_실패 {

	static int[] di = {-1,1,0,0};
	static int[] dj= {0,0,-1,1};
	static int N;
	static int M;
	static int[][] map;
	static List<Ojk> list;
	static int[][][] D;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			D = new int[N][N][2];
			
			list = new ArrayList<>();
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					D[i][j][0]=Integer.MAX_VALUE;
					D[i][j][1]=Integer.MAX_VALUE;
					if(map[i][j]>1) {
						list.add(new Ojk(i, j, map[i][j]));
						
					}
				}
			}
			//입력 끝
			
		
			dfs(0,0,0,0);
			int min=Integer.MAX_VALUE;
			min = Math.min(D[N-1][N-1][0], D[N-1][N-1][1]);
			System.out.println("#"+tc+" "+min);
		}

	}

	static void dfs(int nowi,int nowj,int skill,int time) {
		
		for(int i=0;i<list.size();i++) {
			if(time%list.get(i).open==0) {
				map[list.get(i).i][list.get(i).j]=1;
			}else {
				map[list.get(i).i][list.get(i).j]=0;
			}
		}
		if(D[nowi][nowj][skill]<=time) {
			return;
		}
		
		D[nowi][nowj][skill] = Math.min(time, D[nowi][nowj][skill]);
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=N || nextj>=N  ) {
				continue;
			}
			if(map[nowi][nowj]==0 && map[nexti][nextj]==0) {
				continue;
			}
			if(map[nexti][nextj]==1) {
				dfs(nexti,nextj,skill,time+1);
			}
			if(map[nexti][nextj]==0 && skill==0 ) {
			
				int num=time%M;
				num=time-num+M;
				dfs(nexti,nextj,skill+1,num);
			}
			
		}
	}
	
	static class Ojk{
		int i;
		int j;
		int open;
		public Ojk(int i, int j, int open) {
			super();
			this.i = i;
			this.j = j;
			this.open = open;
		}
		
	}
	
}
