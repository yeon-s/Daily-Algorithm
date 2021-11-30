package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1987_알파벳_dfs {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static boolean[][] visited;
	static int R;
	static int C;
	static char[][] map;
	static StringBuilder sb;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		//입력 끝
		
		visited = new boolean[R][C];
		sb = new StringBuilder();
		max = 0;
		dfs(0,0);
		System.out.println(max);
	}
	
	static void dfs(int nowi,int nowj) {
		visited[nowi][nowj] = true;
		sb.append(map[nowi][nowj]);
		max = Math.max(max, sb.length());
		
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=R || nextj>=C || visited[nexti][nextj] || (sb+"").contains(map[nexti][nextj]+"")) {
				continue;
			}
			
			dfs(nexti,nextj);
			visited[nexti][nextj]=false;
			sb.setLength(sb.length()-1);
			
		}
	}

}
