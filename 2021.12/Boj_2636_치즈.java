package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2636_치즈 {

	static boolean[][] visited;
	static int[] di= {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int h;
	static int w;
	static int[][] map;
	static int cnt;
	static int time;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		for(int i=0;i<h;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<w;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		visited= new boolean[h][w];
		time=0;
	
		while(true) {
			visited= new boolean[h][w];
			cnt=0;
			dfs(0,0);
			melt();
			time++;
			if(check()) {
				break;
			}
		}
		
		System.out.println(time);
		System.out.println(cnt);
	}
	
	static void dfs(int nowi,int nowj) {
		visited[nowi][nowj] = true;
		
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=h || nextj>=w) {
				continue;
			}
			if(map[nexti][nextj]==1) {
				map[nexti][nextj]=2;
			}
			if(!visited[nexti][nextj] && map[nexti][nextj]==0) {
				dfs(nexti,nextj);
			}
		}
	}
	
	static void melt() {
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(map[i][j]==2) {
					map[i][j]=0;
					cnt++;
				}
			}
		}
	}
	
	static boolean check() {
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(map[i][j]==1) {
					return false;
				}
			}
		}
		return true;
	}

}
