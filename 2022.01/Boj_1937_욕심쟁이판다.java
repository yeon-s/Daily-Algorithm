package practice;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Boj_1937_욕심쟁이판다 {

	static boolean[][] visited;
	static int[][] map;
	static int n;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int max=0;
	static int[][] D;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		D = new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		max=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				max =Math.max(max, dfs(i,j));
			}
		}
		System.out.println(max+1);
	}
	
	static int dfs(int nowi,int nowj) {
		if(D[nowi][nowj]>0) {
			return D[nowi][nowj];
		}
		
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=n || nextj>=n || map[nexti][nextj]<=map[nowi][nowj]) {
				continue;
			}
		
			D[nowi][nowj] = Math.max(D[nowi][nowj], dfs(nexti,nextj)+1);
		
		}
		return D[nowi][nowj];
		
	}

}
