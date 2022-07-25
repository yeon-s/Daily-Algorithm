package repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1890_점프 {

	static long[][] D;
	static int[][] map;
	static int N;
	static int[] di = {1,0};
	static int[] dj = {0,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		D = new long[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				D[i][j] = -1;
			}
		}
		
		long answer = dfs(0,0);
		System.out.println(answer);
	}
	
	static long dfs(int nowi,int nowj) {
		if(D[nowi][nowj]!=-1) return D[nowi][nowj];
		
		if(nowi==N-1 && nowj==N-1) return D[nowi][nowj]=1;
		D[nowi][nowj] = 0;
		
		for(int d=0;d<2;d++) {
			int nexti = nowi+di[d]*map[nowi][nowj];
			int nextj = nowj+dj[d]*map[nowi][nowj];
			
			if(nexti>=N || nextj>=N) continue;
			D[nowi][nowj] += dfs(nexti,nextj);
		}
		
		return D[nowi][nowj];
	}

}
