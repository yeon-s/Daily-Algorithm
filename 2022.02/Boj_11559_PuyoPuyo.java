package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_11559_PuyoPuyo {

	static char[][] map;
	static boolean[][] visited;
	static int cnt;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static boolean[][] visited2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[12][6];
		for(int i=0;i<12;i++) {
			String str =br.readLine();
			for(int j=0;j<6;j++) {
				map[i][j]= str.charAt(j);
			}
		}
		
		int answer=0;
		while(true) {
			boolean flag = false;
			visited = new boolean[12][6];
			
			for(int i=0;i<12;i++) {
				for(int j=0;j<6;j++) {
					if(map[i][j]!='.' && !visited[i][j]) {
						cnt=0;
						dfs(i,j,map[i][j]);
						
						if(cnt>=4) {
							flag=true;
							//돌면서 .으로 바꾸기
							visited2= new boolean[12][6];
							change(i,j,map[i][j]);
						}
					}
				}
			}
			
			if(!flag) {
				break;
			}
			//내리기
			gravity();
			
			answer++;
		}
		System.out.println(answer);

	}
	
	static void dfs(int nowi,int nowj,char color) {
		visited[nowi][nowj]=true;
		cnt++;
		
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=12 || nextj>=6 || visited[nexti][nextj] || map[nexti][nextj] !=color) {
				continue;
			}
			dfs(nexti,nextj,color);
		}
		
	}
	
	static void change(int nowi,int nowj,char color) {
		visited2[nowi][nowj]=true;
		map[nowi][nowj]='.';
		
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=12 || nextj>=6 || visited2[nexti][nextj] || map[nexti][nextj] !=color) {
				continue;
			}
			change(nexti,nextj,color);
		}
	}
	
	static void gravity() {
		List<Character> list = new ArrayList<>();
		for(int j=0;j<6;j++) {
			list.clear();
			for(int i=11;i>=0;i--) {
				if(map[i][j]!='.') {
					list.add(map[i][j]);
					map[i][j]='.';
				}
			}
			
			int index=0;
			if(list.size()==0) {
				continue;
			}
			for(int i=11;i>=0;i--) {
				if(map[i][j]=='.') {
					map[i][j]=list.get(index++);
					if(index>=list.size()) {
						break;
					}
				}
			}
		}
	}

}
