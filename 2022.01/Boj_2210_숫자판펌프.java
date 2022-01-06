package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_2210_숫자판펌프 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[][] map;
	static Set<String> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[5][5];
		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		set = new HashSet<>();

		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				dfs(i,j,map[i][j]+"",0);
			}
		}
		
		int answer = 0;
		for(String str:set) {
			answer++;
		}
		System.out.println(answer);
		
	}
	
	static void dfs(int nowi,int nowj,String sum,int depth) {
		if(depth>=5) {
			set.add(sum);
			return;
		}
		
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=5 || nextj>=5) {
				continue;
			}
			
			dfs(nexti,nextj,sum+map[nexti][nextj],depth+1);
		}
	}

}
