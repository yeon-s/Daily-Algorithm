package practice;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Boj_2468_안전영역 {

	static int N;
	static int[][] map;
	static boolean[][] tempMap;
	static int max;
	static boolean[][] visited;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		max = 0;
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>max) max = map[i][j];
			}
		}
		//입력 끝
		
		tempMap = new boolean[N][N];
		int answer =0;
		
		while(max-->0) {
			//boolean map 만들기
			create();
			//dfs
			visited = new boolean[N][N];
			int count = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j] && tempMap[i][j]) {
						dfs(i,j);
						count++;
					}
				}
			}
			//answer 갱신
			answer = Math.max(count, answer);
		}
		System.out.println(answer);
		
	}
	
	static void create() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]>max) {
					tempMap[i][j] = true;
				}
			}
		}
	}
	
	static void dfs(int nowi,int nowj) {
		visited[nowi][nowj]=true;
		
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=N || nextj>=N || visited[nexti][nextj] || !tempMap[nexti][nextj]) {
				continue;
			}
			dfs(nexti,nextj);
		}
	}

}
