package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10026_적록색약 {

	static boolean[][] visited;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N;
	static char[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]= str.charAt(j);
			}
		}
		//입력 끝
		
		visited = new boolean[N][N];
		int answer1 = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {		//방문하지 않았다면 얘로부터 탐색시작
					dfs(i,j);
					answer1++;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]=='G') {		//그린이면 레드로 바꾸기
					map[i][j]='R';
				}
			}
		}
		
		visited = new boolean[N][N];
		int answer2 =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {		//방문하지 않았다면 얘로부터 탐색시작
					dfs(i,j);
					answer2++;
				}
			}
		}
		

		System.out.print(answer1+" "+answer2);
	}
	
	static void dfs(int nowi,int nowj) {
		visited[nowi][nowj]=true;
		
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=N || nextj>=N || visited[nexti][nextj] || map[nowi][nowj] !=map[nexti][nextj]) {
				continue;
			}
			
			dfs(nexti,nextj);
		}
	}

}
