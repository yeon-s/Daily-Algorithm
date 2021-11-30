package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_3109_빵집_틀림 {

	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visited;
	static int[] di = {-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]= str.charAt(j);
			}
		}
		//입력 끝
		
		visited = new boolean[R][C];
		for(int i=0;i<R;i++) {
			dfs(i,0);
		}

		int min = 20000;
		for(int j=0;j<C;j++) {
			int num=0;
			for(int i=0;i<R;i++) {
				if(visited[i][j]) {
					num++;
				}
			}
			min = Math.min(min, num);
		}
		System.out.println(min);
	}
	
	static void dfs(int nowi,int nowj) {
		visited[nowi][nowj] = true;
		
		for(int d=0;d<3;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+1;
			
			if(nexti<0 || nexti>=R || nextj>=C || visited[nexti][nextj] || map[nexti][nextj]=='x') {
				continue;
			}
			
			dfs(nexti,nextj);
		}
	}

}
