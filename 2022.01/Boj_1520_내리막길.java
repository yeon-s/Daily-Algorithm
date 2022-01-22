package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1520_내리막길 {

	static int M;
	static int N;
	static int[][] map;
	static int[] di= {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[][] D;
	static boolean[][] visited;
	static int cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M  = Integer.parseInt(st.nextToken());
		N  = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		D = new int[M][N];		//D[i][j] = i,j에서 갈 수 있는 경로의 수
		for(int i=0;i<M;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				D[i][j]=-1;
			}
		}
		//입력 끝

		System.out.println(dfs(0,0));

	}
	
	static int dfs(int nowi,int nowj) {

		if(D[nowi][nowj]!=-1) {
			return D[nowi][nowj];
		}
		
		if(nowi==M-1 && nowj==N-1) {
			return 1;
		}
		
		D[nowi][nowj]=0;
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=M || nextj>=N || map[nexti][nextj]>=map[nowi][nowj]) {
				continue;
			}

			D[nowi][nowj] +=dfs(nexti,nextj); 
		}
		
		return D[nowi][nowj];
	}
	
}
