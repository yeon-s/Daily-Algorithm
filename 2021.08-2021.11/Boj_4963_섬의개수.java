package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_4963_섬의개수 {

	static int[] di = {-1,-1,0,1,1,1,0,-1};
	static int[] dj = {0,1,1,1,0,-1,-1,-1};
	static int w;
	static int h;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			if(str.equals("0 0")) {
				break;
			}
			
			StringTokenizer st = new StringTokenizer(str);
			w = Integer.parseInt(st.nextToken());
			h =Integer.parseInt(st.nextToken());
			map = new int[h][w];
			
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 끝
			
			boolean[][] visited = new boolean[h][w];
			int land = 0;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(!visited[i][j] && map[i][j]==1) {
						dfs(i,j,visited);
						land++;
					}
				}
			}
			
			System.out.println(land);
		}

	}
	
	static void dfs(int nowi,int nowj,boolean[][] visited) {
		
		visited[nowi][nowj] = true;
		
		for(int d=0;d<8;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=h || nextj>=w) {
				continue;
			}
			if(!visited[nexti][nextj] && map[nexti][nextj] ==1) {
				dfs(nexti,nextj,visited);
			}
		}
	}

}
