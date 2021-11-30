package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj_2667_단지번호붙이기 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[][] map;
	static int N;
	static int num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(str.substring(j, j+1));
			}
		}
		//입력 끝
		boolean[][] visited = new boolean[N][N];
		int flex = 0;
		
		List<Integer> numbers = new ArrayList<Integer>();
		for(int i=0;i<N;i++) {
			for(int j =0;j<N;j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					num=0;
					dfs(i,j,visited);
					numbers.add(num);
					flex++;
				}
			}
		}
		System.out.println(flex);
		Collections.sort(numbers);
		for(int i=0;i<numbers.size();i++) {
			System.out.println(numbers.get(i));
		}
		
	}
	
	static void dfs(int nowi,int nowj,boolean[][] visited) {
		visited[nowi][nowj] = true;
		num++;
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj <0 || nexti>=N || nextj>=N) {
				continue;
			}
			if(!visited[nexti][nextj] && map[nexti][nextj]==1) {
				dfs(nexti,nextj,visited);
			}
		}
	}
}
