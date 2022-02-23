package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Boj_1941_소문난칠공주 {

	static char[][] map;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static List<Point> list;
	static Point[] result;
	static int count;
	static boolean[][] visited;
	static boolean[][] isSelected;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[5][5];
		list = new ArrayList<>();
		int index=1;
		
		for(int i=0;i<5;i++) {
			String str = br.readLine();
			for(int j=0;j<5;j++) {
				map[i][j] = str.charAt(j);
				list.add(new Point(i, j, map[i][j],index++));
			}
		}
		//입력 끝
		
		result = new Point[7];
		answer=0;
		comb(0,0);
		System.out.println(answer);
		
	

	}

	static void comb(int cnt, int start) {
		if(cnt==7) {
			
			isSelected = new boolean[5][5];
			int sNum=0;
			for(int i=0;i<cnt;i++) {
				isSelected[result[i].i][result[i].j]=true;
				if(result[i].c=='S') {
					sNum++;
				}
			}
			if(sNum<4) {
				return;
			}
			
			count=0;
			visited = new boolean[5][5];
			dfs(result[0].i,result[0].j);
			if(count!=7) {
				return;
			}
			
			answer++;
			return;
		}
		
		for(int i=start;i<25;i++) {
			result[cnt] = list.get(i);
			comb(cnt+1,i+1);
		}
	}
	
	static void dfs(int nowi,int nowj) {
		visited[nowi][nowj]=true;
		count++;
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=5 || nextj>=5 || visited[nexti][nextj] || !isSelected[nexti][nextj]) {
				continue;
			}
			
			dfs(nexti,nextj);
		}
	}
	
	static class Point{
		int i;
		int j;
		char c;
		int index;
		public Point(int i, int j, char c,int index) {
			super();
			this.i = i;
			this.j = j;
			this.c = c;
			this.index=index;
		}
		
	}
	
}
